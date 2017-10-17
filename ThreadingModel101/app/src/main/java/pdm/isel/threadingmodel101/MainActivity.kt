package pdm.isel.threadingmodel101

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    fun doHeavyWork() {
        try { Thread.sleep(10000) }
        catch (e: InterruptedException) { }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val work = object : AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) = doHeavyWork()
            override fun onPostExecute(result: Unit?) {
                val text = "Dormi bem, obrigado"
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
            }
        }

        work.execute()
    }
}
