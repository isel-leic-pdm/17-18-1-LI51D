package pdm.isel.usertask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.b_activity.*

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_activity)

        hashTextBox.text = hashCode().toString()

        backButton.setOnClickListener {
            finish()
        }
    }
}
