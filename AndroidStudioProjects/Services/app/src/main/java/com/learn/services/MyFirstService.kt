package com.learn.services

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log

class MyFirstService : Service() {
    var Tag:String = "MyFirstService"
    private var serviceLooper: Looper? = null
    private var serviceHandler: Handler? = null

    override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag, "onBind")
        return null
    }

    override fun onCreate() {
        Log.i(Tag, "onCreate")
        super.onCreate()
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).
        start()
        serviceLooper = mainLooper
        serviceHandler = ServiceHandler(mainLooper)


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(Tag, "onStartCommand")
        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1=startId
            serviceHandler?.sendMessage(msg)
        }
        return START_STICKY //super.onStartCommand(intent, flags, startId)
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
