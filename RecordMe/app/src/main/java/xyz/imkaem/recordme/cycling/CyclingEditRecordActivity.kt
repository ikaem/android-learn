package xyz.imkaem.recordme.cycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import xyz.imkaem.recordme.databinding.ActivityCyclingEditRecordBinding

class CyclingEditRecordActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityCyclingEditRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityCyclingEditRecordBinding.inflate(layoutInflater)
        val activityView: View = viewBinding.root

        setContentView(activityView)

        val recordName: String? = intent.getStringExtra("record-name")
        title = "Set cycling record for $recordName"
    }
}