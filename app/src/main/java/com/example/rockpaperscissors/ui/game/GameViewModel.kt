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


class GameViewModel: ViewModel() {
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
                    Log.d("hjhj", "$response")
                    responseMessageStatus.postValue(response.messageType)
                    playerList = response.playerList
                    timeoutStatus.postValue(response.timeoutInfo)
                    timeoutCount = response.timeoutCount
                    hostStatus = response.hostPlayer
                    resultStatus = response.result

                }

                override fun onError(t: Throwable) {
                    Log.d("hjhj","Bidirectional Streaming responseObserver.onError() 호출됨"+t.localizedMessage)
                    Log.d("hjhj", t.cause.toString())
                    Log.d("hjhj", t.stackTrace.joinToString("\n"))
                }

                override fun onCompleted() {
                    Log.d("hjhj","Bidirectional Streaming 서버 응답 completed")
                }
            }
        requestObserver = clientStubFactory.getAsyncStub().game(responseObserver)

    }

    fun reqToServer(messageType: GRequest.MessageType, player: GRequest.Player, select: GRequest.Select){
        try {
            requestObserver.onNext(GRequest.newBuilder()
                .setMessageType(messageType)
                .setPlayer(player)
                .setSelect(select).build())
        }catch (e: Exception){
            requestObserver.onError(e)
        }
    }

    fun disConnect(){
        requestObserver.onCompleted()
        AppManage.instanceStubFactory().shutdownChannel()
    }

}