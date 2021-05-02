package com.example.rockpaperscissors.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rockpaperscissors.grpc.GameStubFactory
import com.example.rockpaperscissors.manage.AppManage
import com.example.rockpaperscissors.manage.IPadress
import google.example.Gamer
import google.example.Welecom
import io.grpc.stub.StreamObserver

class MainViewModel : ViewModel() {

    var TOAST = MutableLiveData<String>()
    var loginStatus = MutableLiveData<Welecom.Status>()

    private lateinit var clientType: Welecom.ClientType

    private lateinit var clientStubFactory: GameStubFactory

    fun getClientType() = clientType

    fun connect(host: String, port: Int) {
        clientStubFactory = AppManage.instanceStubFactory()
        clientStubFactory.init(host, port)
    }

    fun grpcLogin(clientName: String, clientIP: String) {

        val request: Gamer = Gamer.newBuilder().setName(clientName).setIp(clientIP).build()
        var responseIterator: Iterator<Welecom?>
        clientStubFactory.getAsyncStub().login(
            request,
            object : StreamObserver<Welecom> {
                override fun onNext(response: Welecom) {
                    Log.d("hjhj", response.status.toString() + "\n" + response.ctype)
                    loginStatus.postValue(response.status)
                    clientType = response.ctype
                }

                override fun onError(t: Throwable) {
                    Log.e("hjhj", t.message.toString())
                    loginStatus.postValue(Welecom.Status.UNRECOGNIZED)
                }

                override fun onCompleted() {}
            }
        )
    }

}