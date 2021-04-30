package com.example.rockpaperscissors.model

import androidx.recyclerview.widget.DiffUtil

data class RankInfo (
    val name: String,
    val score: Int,
    val ranking: Int
){
    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<RankInfo>(){
            override fun areItemsTheSame(oldItem: RankInfo, newItem: RankInfo): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: RankInfo, newItem: RankInfo): Boolean {
                return oldItem ==  newItem
            }

        }
    }
}