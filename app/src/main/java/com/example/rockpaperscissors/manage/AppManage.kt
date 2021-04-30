package com.example.rockpaperscissors.manage

import android.app.Application
import android.content.Context
import com.example.rockpaperscissors.grpc.GameStubFactory

class AppManage: Application() {

    init {
        INSTANCE = this
    }

    companion object{
        private var INSTANCE: AppManage? = null
        private var gameStubFactory: GameStubFactory? = null

        fun instanceContext() : Context {
            return INSTANCE!!.applicationContext
        }

        fun instanceStubFactory() : GameStubFactory{
            if(gameStubFactory == null){
                gameStubFactory = GameStubFactory()
            }
            return gameStubFactory as GameStubFactory
        }
    }
}