package pdm.isel.systemservices101

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.v("SystemServices101", "onHandleIntent()")
    }
}
