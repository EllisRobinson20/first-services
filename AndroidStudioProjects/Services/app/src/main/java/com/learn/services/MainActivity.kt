package com.learn.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mService : MyFirstService? = null
    var isBound : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, MyFirstService::class.java)
        bindService(intent,myConnection,Context.BIND_AUTO_CREATE)
    }
    private val myConnection = object : ServiceConnection {

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyFirstService.MyBinder
            mService = binder.getService()
            isBound = true
        }

    }
    fun startService(view:View) {
        val txt_received = editText.text.toString().toInt()
        val Count = mService?.getResult(txt_received)
        text_main.text = "$Count"
    }
    fun startIntentService(view:View) {
        var intent = Intent(this, MyIntentService::class.java)
        startService(intent)
    }

}