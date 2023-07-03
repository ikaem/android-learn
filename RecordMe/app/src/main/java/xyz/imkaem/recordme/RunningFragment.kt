package xyz.imkaem.recordme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import xyz.imkaem.recordme.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var viewBinding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

//        giving value to view bidning
        viewBinding = FragmentRunningBinding.inflate(inflater, container, false)
        val fragmentView: View = viewBinding.root

        return fragmentView


//        TODO this is default
//        return super.onCreateView(inflater, container, savedInstanceState)

//        here we want to attach fragment to activity, and not to the container - this is why "false"
//        return inflater.inflate(
//            R.layout.fragment_running,
//            container,
//            false,
//        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        viewBinding.constraintLayoutContainer5kmRunning.setOnClickListener {
            onLaunchRunningEditRecordActivity("5km")
        }
        viewBinding.constraintLayoutContainer10kmRunning.setOnClickListener {
            onLaunchRunningEditRecordActivity("10km")
        }
        viewBinding.constraintLayoutContainer15kmRunning.setOnClickListener {
            onLaunchRunningEditRecordActivity("15km")
        }
    }

    private fun onLaunchRunningEditRecordActivity(recordName: String) {
        val intent: Intent = Intent(context, RunningEditRecordActivity::class.java)
        intent.putExtra("record-name", recordName)
        startActivity(intent)
    }
}