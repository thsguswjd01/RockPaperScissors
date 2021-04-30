package com.example.rockpaperscissors.ui.game.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.databinding.ItemPlayersBinding
import com.example.rockpaperscissors.model.PlayerInfo

class PlayerAdapter: ListAdapter<PlayerInfo, PlayerAdapter.DataViewHolder>(PlayerInfo.diffCallback) {
    class DataViewHolder(private val binding: ItemPlayersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlayerInfo) {
            binding.player = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ItemPlayersBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_players, parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<PlayerInfo>?) {
        super.submitList(list)
    }
}