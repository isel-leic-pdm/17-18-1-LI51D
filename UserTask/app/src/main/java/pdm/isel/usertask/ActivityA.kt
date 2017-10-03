package pdm.isel.usertask

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.a_activity.*

class ActivityA : AppCompatActivity() {

    companion object {
        val STATE_KEY = "counterState"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("App", "ActivityA.onCreate()")

        setContentView(R.layout.a_activity)

        hashTextBox.text = hashCode().toString()

        if (savedInstanceState != null) {
            counterTextView.text = savedInstanceState[STATE_KEY].toString()
        }

        launchAButton.setOnClickListener {
            startActivity(Intent(this@ActivityA, ActivityA::class.java))
        }

        launchBButton.setOnClickListener {
            startActivity(Intent(this@ActivityA, ActivityB::class.java))
        }

        incButton.setOnClickListener {
            counterTextView.text = "${Integer.parseInt(counterTextView.text.toString()) + 1}"
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putCharSequence(STATE_KEY, counterTextView.text.toString())
    }
}
