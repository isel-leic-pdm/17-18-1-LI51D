package pdm.isel.services101

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("Services101", "MainActivity.onCreate() in ${Thread.currentThread().id}")

        // val msg = Intent(this, MyStartedService::class.java)
        val msg = Intent(this, MyIntentService::class.java)
        val startButton = findViewById(R.id.startButton) as Button
        startButton.setOnClickListener {
            startService(msg)
        }
    }
}
