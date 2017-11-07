package pdm.isel.broadcastreceivers101

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.v("BroadcastReceivers101", "MyReceiver.onReceive() in ${Thread.currentThread().id}")
    }
}
