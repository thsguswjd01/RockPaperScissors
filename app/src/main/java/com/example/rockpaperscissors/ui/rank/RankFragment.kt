package com.example.rockpaperscissors.ui.rank

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.databinding.RankFragmentBinding
import com.example.rockpaperscissors.manage.IPadress
import com.example.rockpaperscissors.ui.game.GameFragment
import com.example.rockpaperscissors.ui.rank.adapter.RankAdapter
import google.example.Gamer

class RankFragment : Fragment() {
    companion object {
        const val NAME = "name"

        fun newInstance(name: String) = RankFragment().apply {
            arguments = Bundle().apply {
                putString(GameFragment.NAME, name)
            }
        }
    }

    private val _name by lazy {requireArguments().getString(NAME)}

    private lateinit var rankFragmentBinding: RankFragmentBinding
    private val binding get() = rankFragmentBinding

    private lateinit var viewModel: RankViewModel
    private lateinit var rankAdapter: RankAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rankFragmentBinding = RankFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RankViewModel::class.java)

        rankAdapter = RankAdapter()
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = rankAdapter
        }

        viewModel.getRank(Gamer.newBuilder().setName(_name).setIp(IPadress().getIP()).build())

        viewModel.liveRankList.observe(this, Observer {
            rankAdapter.submitList(it)
        })
    }

}