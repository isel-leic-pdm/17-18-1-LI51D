package pdm.isel.systemservices101

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.app.job.JobInfo
import android.content.ComponentName
import android.app.job.JobScheduler
import android.support.v7.app.NotificationCompat


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // demoAlarmManager()
        // demoJobScheduler()
        demoNotificationManager()
    }

    private fun demoNotificationManager() {
        val mBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("My notification")
                .setContentText("Hello World!")

        val notificationMgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationMgr.notify(11111, mBuilder.build())
    }

    private fun demoJobScheduler() {
        val builder = JobInfo.Builder(MyJobService.JOB_ID,
                ComponentName(this, MyJobService::class.java))

        // TODO: Specify execution conditions

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(builder.build())
    }

    private fun demoAlarmManager() {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pi = PendingIntent.getService(this, 1001, Intent(this, MyIntentService::class.java), 0)
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 5 * 60 * 1000, pi)
        Log.v("SystemServices101", "onCreate ends")
    }
}