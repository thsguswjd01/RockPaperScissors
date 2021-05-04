package com.example.rockpaperscissors.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rockpaperscissors.MainActivity
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.databinding.MainFragmentBinding
import com.example.rockpaperscissors.manage.AppManage
import com.example.rockpaperscissors.manage.IPadress
import com.example.rockpaperscissors.ui.game.GameFragment
import com.example.rockpaperscissors.ui.rank.RankFragment
import google.example.Welecom


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var mainFragmentBinding: MainFragmentBinding? = null
    private val binding get() = mainFragmentBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.constraintLoading.visibility = View.GONE
        binding.buttonStart.setOnClickListener {
            if (binding.textFieldName.editText?.text.toString() != "") { loginGame() }
        }

        binding.buttonRank.setOnClickListener {
            if (binding.textFieldName.editText?.text.toString() != "") { viewRank() }
        }
        viewModel.loginStatus.observe(this, Observer {
            when (it) {
                Welecom.Status.WAIT -> {
                    binding.constraintLoading.visibility = View.VISIBLE
                }
                Welecom.Status.READY -> {
                    binding.constraintLoading.visibility = View.GONE
                    when (viewModel.getClientType()) {
                        Welecom.ClientType.HOST -> startGame(true)
                        Welecom.ClientType.GUEST -> startGame(false)
                    }
                }
                Welecom.Status.READY_IS_HOST -> {
                    binding.constraintLoading.visibility = View.GONE
                    startGame(true)
                }
                Welecom.Status.UNRECOGNIZED -> {
                    binding.constraintLoading.visibility = View.GONE
                    Toast.makeText(context, "에러", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun viewRank() {
        if (!AppManage.instanceStubFactory().isInit()) viewModel.connect(
            binding.textFieldIp.editText?.text.toString(),
            binding.textFieldPort.editText?.text.toString().toInt()
        )
        (activity as MainActivity?)!!.replaceFragment(RankFragment.newInstance(binding.textFieldName.editText?.text.toString()))
    }

    private fun startGame(isHost: Boolean) {
        (activity as MainActivity?)!!.replaceFragment(
            GameFragment.newInstance(
                binding.textFieldName.editText?.text.toString(),
                isHost
            )
        )
        viewModel.loginStatus.value = null
    }

    private fun loginGame() {
        binding.constraintLoading.visibility = View.VISIBLE
        if (!AppManage.instanceStubFactory().isInit()) viewModel.connect(
            binding.textFieldIp.editText?.text.toString(),
            binding.textFieldPort.editText?.text.toString().toInt()
        )
        viewModel.grpcLogin(
            binding.textFieldName.editText?.text.toString(),
            IPadress().getIP()
        )

    }

    override fun onDestroyView() {
        mainFragmentBinding = null
        super.onDestroyView()
    }
}