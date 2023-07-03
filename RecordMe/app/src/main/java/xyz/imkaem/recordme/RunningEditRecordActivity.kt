package xyz.imkaem.recordme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.imkaem.recordme.databinding.ActivityRunningEditRecordBinding

class RunningEditRecordActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityRunningEditRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityRunningEditRecordBinding.inflate(layoutInflater)
        val activityView = viewBinding.root
        setContentView(activityView)

        val recordName: String? = intent.getStringExtra("record-name")

        title = "Set running record for $recordName"
    }
}