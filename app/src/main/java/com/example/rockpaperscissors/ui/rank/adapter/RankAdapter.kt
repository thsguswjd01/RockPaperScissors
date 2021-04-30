package com.example.rockpaperscissors.ui.rank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.databinding.ItemRankBinding
import com.example.rockpaperscissors.model.RankInfo

class RankAdapter: ListAdapter<RankInfo, RankAdapter.DataViewHolder>(RankInfo.diffCallback) {
    class DataViewHolder(private val binding: ItemRankBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RankInfo) {
            binding.rank = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankAdapter.DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemRankBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_rank, parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RankAdapter.DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<RankInfo>?) {
        super.submitList(list)
    }
}