package xyz.imkaem.recordme.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xyz.imkaem.recordme.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {

    private lateinit var viewBinding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//        TODO this is default
//        return super.onCreateView(inflater, container, savedInstanceState)

//        return inflater.inflate(
//            R.layout.fragment_cycling,
//            container,
//            false,
//        )

        viewBinding = FragmentCyclingBinding.inflate(inflater, container, false)
        val fragmentView: View = viewBinding.root

        return fragmentView
    }

    //    here we want to setup listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        viewBinding.constraintLayoutContainer5kmCycling.setOnClickListener {
            onLaunchCyclingEditRecordActivity("5km")
        }
        viewBinding.constraintLayoutContainer10kmCycling.setOnClickListener {
            onLaunchCyclingEditRecordActivity("5km")

        }
        viewBinding.constraintLayoutContainer15kmCycling.setOnClickListener {
            onLaunchCyclingEditRecordActivity("5km")

        }
    }

    private fun onLaunchCyclingEditRecordActivity(recordName: String) {
//        we can get context from the fragment class itself
        val intent: Intent = Intent(context, CyclingEditRecordActivity::class.java)
        intent.putExtra("record-name", recordName)

        startActivity(intent)

    }
}