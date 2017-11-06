package pdm.isel.services101

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Created by palbp on 06/11/2017.
 */
class MyStartedService : Service() {

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        Log.v("Services101", "MyStartedService.onCreate() in ${Thread.currentThread().id}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("Services101", "MyStartedService.onDestroy() in ${Thread.currentThread().id}")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val result = super.onStartCommand(intent, flags, startId)
        Log.v("Services101", "MyStartedService.onStartCommand() in ${Thread.currentThread().id}")

        val work = Runnable {
            Log.v("Services101", "MyStartedService.worker work started in ${Thread.currentThread().id}")
            Thread.sleep(10000)
            Log.v("Services101", "MyStartedService.worker work ended in ${Thread.currentThread().id}")
            stopSelf(startId)
        }
        Thread(work).start()
        return result
    }
}