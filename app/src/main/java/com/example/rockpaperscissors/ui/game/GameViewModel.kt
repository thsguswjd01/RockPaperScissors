package com.example.rockpaperscissors.ui.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rockpaperscissors.manage.AppManage
import com.example.rockpaperscissors.manage.IPadress
import google.example.GRequest
import google.example.GResponse
import google.example.Gamer
import io.grpc.stub.StreamObserver
import java.lang.Exception


class GameViewModel : ViewModel() {
    private val clientStubFactory = AppManage.instanceStubFactory()
    private lateinit var requestObserver: StreamObserver<GRequest>

    var responseMessageStatus = MutableLiveData<GResponse.MessageType>()
    lateinit var playerList: List<GResponse.Player>
    var timeoutStatus = MutableLiveData<GResponse.Timeout>()
    var timeoutCount = 0
    lateinit var hostStatus: Gamer
    lateinit var resultStatus: GResponse.Result

    fun connectGame() {
        // 서버에 보낼 콜백 객체
        val responseObserver: StreamObserver<GResponse> = object : StreamObserver<GResponse> {
            override fun onNext(response: GResponse) {
                Log.d("responseObserver_hj", "$response")
                responseMessageStatus.postValue(response.messageType)
                playerList = response.playerList
                timeoutStatus.postValue(response.timeoutInfo)
                timeoutCount = response.timeoutCount
                hostStatus = response.hostPlayer
                resultStatus = GResponse.Result.newBuilder().build()
                resultStatus =  response.result
            }

            override fun onError(t: Throwable) {
            }

            override fun onCompleted() {}
        }
        requestObserver = clientStubFactory.getAsyncStub().game(responseObserver)

    }

    fun reqToServer(
        messageType: GRequest.MessageType,
        player: GRequest.Player,
        select: GRequest.Select
    ) {
        Log.d("hjhj", "req hj: $messageType$player$select")
        try {
            requestObserver.onNext(
                GRequest.newBuilder()
                    .setMessageType(messageType)
                    .setPlayer(player)
                    .setSelect(select).build()
            )
        } catch (e: Exception) {
            requestObserver.onError(e)
        }
    }

    fun disConnect() {
        requestObserver.onCompleted()
    }

}