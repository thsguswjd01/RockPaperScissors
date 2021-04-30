package com.example.rockpaperscissors.grpc

import android.util.Log
import google.example.RspApplicationGrpc.*
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.TimeUnit

class GameStubFactory() {

    private lateinit var channel: ManagedChannel
    private lateinit var blockingStub: RspApplicationBlockingStub
    private lateinit var asyncStub: RspApplicationStub
    private lateinit var futureStub: RspApplicationFutureStub

    fun init(host: String, port: Int){
        channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();
        blockingStub = newBlockingStub(channel)
        asyncStub = newStub(channel)
        futureStub = newFutureStub(channel)
    }

    @Throws(InterruptedException::class)
    fun shutdownChannel() {
        Log.d("hjhj","gRPC Channel shutdown...")
        channel.shutdown().awaitTermination(2, TimeUnit.SECONDS)
    }

    fun getBlockingStub(): RspApplicationBlockingStub = blockingStub

    fun getAsyncStub(): RspApplicationStub = asyncStub

    fun getFutureStub(): RspApplicationFutureStub = futureStub
}