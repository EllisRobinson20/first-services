package com.learn.services

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.IBinder
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.learn.services.action.FOO"
private const val ACTION_BAZ = "com.learn.services.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.learn.services.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.learn.services.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("MyFirstService", "onHandleIntent")
        try {
            Thread.sleep(10000)
        } catch (e:InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Log.i("MyFirstService", "onStartCommand")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("MyFirstService", "onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("MyFirstService", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyFirstService", "onDestroy")
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}
