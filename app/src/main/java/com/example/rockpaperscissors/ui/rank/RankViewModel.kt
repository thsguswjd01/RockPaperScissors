package com.example.rockpaperscissors.ui.rank

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rockpaperscissors.manage.AppManage
import com.example.rockpaperscissors.model.RankInfo
import google.example.Gamer
import google.example.RankList
import io.grpc.stub.StreamObserver


class RankViewModel : ViewModel() {
    private val clientStubFactory = AppManage.instanceStubFactory()
    var liveRankList = MutableLiveData<ArrayList<RankInfo>>()
    private lateinit var _rankList: ArrayList<RankInfo>

    fun getRank(gamer: Gamer) {
        Log.d("hjhj", gamer.toString())
        clientStubFactory.getAsyncStub().rank(gamer, object : StreamObserver<RankList> {
            override fun onNext(value: RankList) {
                Log.d("hjhj", value.toString())
                value.rankerList.forEach {
                    val rankInfo = RankInfo(
                        it.name,
                        it.score,
                        it.ranking
                    )
                    _rankList.add(rankInfo)
                }

                liveRankList.postValue(_rankList)
            }

            override fun onError(t: Throwable?) {
                //try again
            }

            override fun onCompleted() {
            }

        })

    }

}