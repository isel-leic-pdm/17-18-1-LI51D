package pdm.isel.activities101

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            counter.text = savedInstanceState.getCharSequence("counterValue")

        incButton.setOnClickListener {
            counter.text = (counter.text.toString().toInt() + 1).toString()
        }
        decButton.setOnClickListener {
            counter.text = (counter.text.toString().toInt() - 1).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putCharSequence("counterValue", counter.text);
    }
}
