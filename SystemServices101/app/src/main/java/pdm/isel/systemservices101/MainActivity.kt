package pdm.isel.systemservices101

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.app.job.JobInfo
import android.content.ComponentName
import android.app.job.JobScheduler



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pi = PendingIntent.getService(this, 1001, Intent(this, MyIntentService::class.java), 0)
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 5*60*1000, pi)
        Log.v("SystemServices101", "onCreate ends")


        val builder = JobInfo.Builder(MyJobService.JOB_ID,
                ComponentName(this, MyJobService::class.java))

        // TODO: Specify execution conditions

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(builder.build())
    }
}