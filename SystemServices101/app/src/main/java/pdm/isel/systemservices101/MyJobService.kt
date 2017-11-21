package pdm.isel.systemservices101

import android.app.job.JobParameters
import android.app.job.JobService

class MyJobService : JobService() {

    companion object {
        val JOB_ID = 123452
    }

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        return false
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean {
        return false
    }
}
