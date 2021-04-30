package com.example.rockpaperscissors.ui.game

import android.animation.Animator
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rockpaperscissors.MainActivity
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.databinding.GameFragmentBinding
import com.example.rockpaperscissors.manage.IPadress
import com.example.rockpaperscissors.model.PlayerInfo
import com.example.rockpaperscissors.ui.game.adapter.PlayerAdapter
import com.example.rockpaperscissors.ui.main.MainFragment
import google.example.GRequest
import google.example.GRequest.Player
import google.example.GResponse

class GameFragment : Fragment() {

    companion object {
        const val NAME = "name"
        const val HOST = "isHost"
        fun newInstance(name: String, isHost: Boolean) = GameFragment().apply {
            arguments = Bundle().apply {
                putString(NAME, name)
                putBoolean(HOST, isHost)
            }
        }
    }

    private val _name by lazy {requireArguments().getString(NAME)}
    private val _isHost by lazy {requireArguments().getBoolean(HOST)}

    private lateinit var player: Player

    private lateinit var viewModel: GameViewModel
    private var gameFragmentBinding: GameFragmentBinding? = null
    private val binding get() = gameFragmentBinding!!

    private var TIMEOUT = 0
    private lateinit var playerAdapter:PlayerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gameFragmentBinding = GameFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        playerAdapter = PlayerAdapter()
        binding.recyclerviewPlayer.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = playerAdapter

        }
        binding.lottie.visibility = View.GONE
        binding.buttonRock.setOnClickListener{ sendItem(GRequest.Select.ROCK) }
        binding.buttonPaper.setOnClickListener{ sendItem(GRequest.Select.PAPER) }
        binding.buttonScissor.setOnClickListener{ sendItem(GRequest.Select.SCISSOR) }

        binding.buttonStart.setOnClickListener{ viewModel.reqToServer(GRequest.MessageType.HOST_GAME_START, player, GRequest.Select.NONE) }

        player = Player.newBuilder().setName(_name).setIp(IPadress().getIP()).build()

        setgrpc()
        setLoadingView()
        setObserver()
    }


    override fun onDestroy() {
        Log.d("hjhj","onDestroy")
        viewModel.disConnect()
        super.onDestroy()
    }

    private fun sendItem(select: GRequest.Select) {
        rspButtonVisibility(false)
        viewModel.reqToServer(GRequest.MessageType.SELECT, player, select)
    }

    private fun setObserver() {
        viewModel.responseMessageStatus.observe(this, Observer {
            when (it) {
                GResponse.MessageType.START -> {
                    startGame()
                }
                GResponse.MessageType.TIMEOUT -> {
                    //중간 TIMOUT체크 종료 1초정도 전에옴
                    viewModel.reqToServer(GRequest.MessageType.TIMEOUT_ACK, player, GRequest.Select.NONE)
                }
                GResponse.MessageType.RESULT -> { resultGame(it) }
                GResponse.MessageType.DRAW -> { resultGame(it) }
                GResponse.MessageType.LEAVE -> { leaveGame() }
                GResponse.MessageType.CHANGE_HOST -> {  }
            }
        })
    }

    private fun resultGame(message: GResponse.MessageType) {
        binding.progressTime.progress = TIMEOUT * 20
        setTimeoutAnim(false)
        rspButtonVisibility(true)

        when(message){
            GResponse.MessageType.RESULT ->{
                val winnerList = viewModel.resultStatus.winnerList !!

                if (winnerList.any { it.equals(player.name) }) {
                    //winner
                    playLottie(R.raw.win, true, "이겼어요! +15점")
                } else {
                    //loser
                    playLottie(R.raw.lose, true, "졌어요ㅠㅠ -1점")
                }
            }
            GResponse.MessageType.DRAW -> { playLottie(R.raw.draw, true, "비겼어요!")}
            GResponse.MessageType.CHANGE_HOST->{}
        }

    }

    private fun leaveGame() {
        //게임종료 모든 커넥션 끊기
        Toast.makeText(context, "LEAVE", Toast.LENGTH_SHORT).show()
        val leave_player = viewModel.playerList

        if(leave_player.any { it.name == player.name }){
            (activity as MainActivity?)!!.replaceFragment(MainFragment.newInstance())
        }
    }

    private fun startGame() {
        //버튼 활성화
        setGameView()
        //에니메이션 재생
        playLottie(R.raw.start,false,"게임 시작!\n하단 버튼을 선택해주세요!")
        //리스트 연결
        setPlayerInfo()
        //카운트 시작
        setProgressbar()
    }

    private fun setProgressbar() {
        TIMEOUT = viewModel.timeoutCount

        setTimeoutAnim(true)
        binding.progressTime.apply {
            max = TIMEOUT * 20
            progress = TIMEOUT * 20
        }
        var i = TIMEOUT * 20
        val mCountDownTimer = object : CountDownTimer((TIMEOUT*1000).toLong(), 50) {
            override fun onTick(millisUntilFinished: Long) {
                i--
                binding.progressTime.progress = i
            }

            override fun onFinish() {
                //Do what you want
                binding.progressTime.progress= 0
                setTimeoutAnim(false)
                sendItem(GRequest.Select.NONE)
            }
        }
        mCountDownTimer.start()
    }

    private fun setPlayerInfo() {
        //todo 서버리턴 데이터를 보면서 맞추기
        val list = viewModel.playerList
        var playerInfos: ArrayList<PlayerInfo> = ArrayList()
        list.forEach {
            val playerInfo = PlayerInfo(
                ip = it.ip,
                name = it.name
            )
            playerInfos.add(playerInfo)
        }

        playerInfos.filter { it.name == viewModel.hostStatus.name }.let {
            if(it.isNotEmpty()) it[0].isHost = View.VISIBLE
        }

        playerAdapter.submitList(playerInfos)
    }

    private fun setgrpc() {
        viewModel.connectGame()
    }

    private fun setLoadingView() {
        if(_isHost){
            binding.constraintClient.visibility = View.GONE
            binding.constraintHost.visibility = View.VISIBLE
        } else {
            binding.constraintClient.visibility = View.VISIBLE
            binding.constraintHost.visibility = View.GONE
            //클라이언트 접속 핑
            viewModel.reqToServer(GRequest.MessageType.SELECT,player,GRequest.Select.NONE)
        }
        rspButtonVisibility(false)
    }

    private fun setGameView() {
        binding.constraintClient.visibility = View.GONE
        binding.constraintHost.visibility = View.GONE

        rspButtonVisibility(true)
    }

    private fun rspButtonVisibility(visible: Boolean){
        binding.buttonRock.isEnabled = visible
        binding.buttonPaper.isEnabled = visible
        binding.buttonScissor.isEnabled = visible
    }

    private fun playLottie(raw: Int, isFinished: Boolean, msg: String) {
        binding.textviewComment.apply {
            visibility = View.VISIBLE
            text = msg
        }
        binding.lottie.apply {
            setAnimation(raw)
            visibility = View.VISIBLE
            playAnimation()
            addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    binding.textviewComment.visibility = View.GONE
                    visibility = View.GONE
                    if(isFinished) setLoadingView()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
        }
    }

    private fun setTimeoutAnim(visible: Boolean){
        binding.lottiePlaying.apply {
            visibility = if(visible) View.VISIBLE else View.GONE
        }
    }


}