package pdm.isel.services101

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    override fun onCreate() {
        super.onCreate()
        Log.v("Services101", "MyIntentService.onCreate() in ${Thread.currentThread().id}")
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.v("Services101", "MyIntentService.worker work started in ${Thread.currentThread().id}")
        Thread.sleep(10000)
        Log.v("Services101", "MyIntentService.worker work ended in ${Thread.currentThread().id}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("Services101", "MyIntentService.onDestroy() in ${Thread.currentThread().id}")
    }
}
