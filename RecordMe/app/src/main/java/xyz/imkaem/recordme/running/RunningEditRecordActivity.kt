package xyz.imkaem.recordme.running

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import xyz.imkaem.recordme.databinding.ActivityRunningEditRecordBinding

class RunningEditRecordActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityRunningEditRecordBinding
    private val runningPreferences: SharedPreferences by lazy {
        getSharedPreferences("running", Context.MODE_PRIVATE)
    }
    private val recordName: String? by lazy {
        intent.getStringExtra("record-name")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        viewBinding = ActivityRunningEditRecordBinding.inflate(layoutInflater)
        val activityView = viewBinding.root
        setContentView(activityView)
        title = "Set running record for $recordName"

//        val recordName: String? = intent.getStringExtra("record-name")


        viewBinding.buttonSave.setOnClickListener {
            saveRecord()
//            here we want to finish activitiy - we actually call finish
            finish()
        }

        viewBinding.buttonDelete.setOnClickListener {
            clearRecord()
//            finish()
        }

//        sets up displaying current records in inputs
        displayRecord()




//        share prefs
//        this is for settings
//        val applicationPreference: SharedPreferences =
//            PreferenceManager.getDefaultSharedPreferences(this)
//
//        applicationPreference.edit {
//            putString("some preference", "Preference value")
//        }
//
////        this is now activity wide preferences
//        val activityPreference: SharedPreferences = getPreferences(Context.MODE_PRIVATE)
//
//        activityPreference.edit {
//            putInt("int preference", 3)
//        }
//
////        this is sharedPreferences that we name file for
//        val fileSharedPreferences: SharedPreferences = getSharedPreferences("app-wide", Context.MODE_PRIVATE)
//
//        fileSharedPreferences.edit {
//            putString("file-name-preferences", "sae")
//        }
    }

    private fun clearRecord() {
        runningPreferences.edit {
            remove("record-time-$recordName")
            remove("record-date-$recordName")
        }
    }

    private fun displayRecord() {
//        here we get specific record
//        val runningPreferences: SharedPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)
        viewBinding.textInputEditTextTime.setText(runningPreferences.getString("record-time-$recordName", null))
        viewBinding.textInputEditTextDate.setText(runningPreferences.getString("record-date-$recordName", null))


    }

    override fun onResume() {
        super.onResume()

//        val sharedPreferences: SharedPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)



//
//        not sure if this should be called here
        viewBinding.textInputEditTextTime.setText("")
    }

    private fun saveRecord() {
        val recordTime: String = viewBinding.textInputEditTextTime.text.toString()
        val recordDate: String = viewBinding.textInputEditTextDate.text.toString()

//        val runningPreferences: SharedPreferences =
//            getSharedPreferences("running", Context.MODE_PRIVATE)
// this is long way of doing it
        val editor: SharedPreferences.Editor = runningPreferences.edit()
        editor.putString("record-time-$recordName", recordTime)
        editor.putString("record-date-$recordName", recordDate)
        editor.apply()
//        editor.commit() is also possibly, but apply is faster


//        this is shorthand
//        runningPreferences.edit {
//            putString("record-time-$recordDistance", recordTime)
//            putString("record-date-$recordDistance", recordDate)
//        }
//        here we also want to go back to running fragment
    }
}