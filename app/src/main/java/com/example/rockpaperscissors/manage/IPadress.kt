package com.example.rockpaperscissors.manage

import java.net.Inet4Address
import java.net.NetworkInterface

class IPadress {
    fun getIP(): String {
        var ip = ""
        var breakLoop =false
        val en = NetworkInterface.getNetworkInterfaces()
        try{
            while(en.hasMoreElements()) {
                val intf = en.nextElement()
                val enumIpAddr = intf.inetAddresses
                while(enumIpAddr.hasMoreElements()) {
                    val inetAddress = enumIpAddr.nextElement()
                    if(!inetAddress.isLoopbackAddress&& inetAddress is Inet4Address) {
                        ip = inetAddress.hostAddress.toString()
                        breakLoop =true
                        break
                    }
                }
                if(breakLoop) {
                    break
                }
            }
        }catch(e: Exception) {
            return "네트워크연결 필요"
        }
        return ip
    }
}