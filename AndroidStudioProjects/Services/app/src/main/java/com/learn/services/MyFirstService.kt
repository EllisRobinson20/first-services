package com.learn.services

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log

class MyFirstService : Service() {
    var Tag:String = "MyFirstService"
    private val myBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag, "onBind")
        return myBinder
    }
    fun getResult(Counter:Int): Int {
        return Counter * 10
    }

    inner class MyBinder: Binder() {
        fun getService() : MyFirstService {
            return this@MyFirstService
        }
    }



    override fun onDestroy() {
        Log.i(Tag, "onDestroy")
        super.onDestroy()
    }
    private inner class ServiceHandler(looper:Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            try{
                Thread.sleep(10000)
            } catch(e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }
}
