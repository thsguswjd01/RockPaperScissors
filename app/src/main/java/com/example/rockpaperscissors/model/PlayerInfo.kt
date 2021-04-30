package com.example.rockpaperscissors.model

import android.view.View
import androidx.recyclerview.widget.DiffUtil

data class PlayerInfo(
    val name: String,
    val ip: String,
    val isWinner: Boolean = false,
    val point: String = "",
    val select: String = "",
    var isHost: Int = View.GONE
) {
    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<PlayerInfo>(){
            override fun areItemsTheSame(oldItem: PlayerInfo, newItem: PlayerInfo): Boolean {
                return oldItem.ip == oldItem.ip
            }

            override fun areContentsTheSame(oldItem: PlayerInfo, newItem: PlayerInfo): Boolean {
                return oldItem == newItem
            }

        }
    }
}
