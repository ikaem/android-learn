package xyz.imkaem.recordme.running

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
//        this is not called if back with device back button happens
//        setupDisplayRecords()
    }

    override fun onResume() {
        super.onResume()
//        this is called even when device app back buztton is pressed
        setupDisplayRecords()
    }

    private fun setupDisplayRecords() {
//        we could do this to access getSharedPrefs on context - which is activity that the fragment attached itself to
//        val sharedPreferences: SharedPreferences? =
//            context?.getSharedPreferences("running", Context.MODE_PRIVATE)

//        required context will guive us non null context
        val sharedPreferences: SharedPreferences =
            requireContext().getSharedPreferences("running", Context.MODE_PRIVATE)

        val record5kmTime: String? = sharedPreferences.getString("record-time-5km", null)
        val record5kmDate: String? = sharedPreferences.getString("record-date-5km", null)

        val record10kmTime: String? = sharedPreferences.getString("record-time-10km", null)
        val record10kmDate: String? = sharedPreferences.getString("record-date-10km", null)

        val record15kmTime: String? = sharedPreferences.getString("record-time-15km", null)
        val record15kmDate: String? = sharedPreferences.getString("record-date-15km", null)

        viewBinding.textViewResult5kmRunning.text = record5kmTime
        viewBinding.textViewDate5kmRunning.text = record5kmDate

        viewBinding.textViewResult10kmRunning.text = record10kmTime
        viewBinding.textViewDate10kmRunning.text = record10kmDate

        viewBinding.textViewResult15kmRunning.text = record15kmTime
        viewBinding.textViewDate15kmRunning.text = record15kmDate
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