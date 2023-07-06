package xyz.imkaem.lifecycleapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import xyz.imkaem.lifecycleapp.databinding.ActivityMainBinding
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBiding: ActivityMainBinding
    private var isFirstLoad: Boolean = true

    var seconds = 0;
    private lateinit var refreshTimer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        prevent going back - oir intercepting it
        val callback = onBackPressedDispatcher.addCallback {

            Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG).show()
            showDialog()

        }

        viewBiding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBiding.root
        setContentView(view)

        viewBiding.buttonToAnotherActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent: Intent = Intent(this@MainActivity, AnotherActivity::class.java)
                startActivity(intent)
            }

        })

        viewBiding.buttonExitActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                finish()

                showDialog()
            }
        })

//        save text to text
        viewBiding.buttonSaveMessage.setOnClickListener {
            saveMessage()
        }

//        we can set it here because we will set updated ones in onRestart
        viewBiding.textViewRefreshStatus.text = "Hello - status is 'onCreate'"

//        setContentView(R.layout.activity_main)

        Log.d("karlo", "onCreate() called")

//        TODO this is some timer
//        val timer: CountDownTimer = object : CountDownTimer(2000, 100) {
//            override fun onTick(millisUntilFinished: Long) {
//                println("Ticking")
//            }
//
//            override fun onFinish() {
//                Log.d("karlo", "onFinish() called")
//                finish()
//            }
//        }

//        timer.start()

//        this is another timer
//        var seconds = 0;
//        fixedRateTimer(period = 1000L) {
////            we need this to be allowed to touch UI
//            runOnUiThread {
//                seconds++
//                viewBiding.textViewLengthStatus.text = "More text: $seconds"
//            }
//        }

//        THIS IS IN onCreate
        val textViewSavedMessage: String = savedInstanceState?.getString("savedTextViewMessage") ?: ""
        viewBiding.textViewMessage.text = textViewSavedMessage
    }

    private fun saveMessage() {
        val userMessage = viewBiding.editTextMessage.text.toString()
        viewBiding.textViewMessage.text = userMessage
    }

    override fun onStart() {
        super.onStart()
        Log.d("karlo", "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("karlo", "onResume() called")
//  this is better - do it in onresume
//        val data: String = when (isFirstLoad) {
//            true -> "This was initial data"
//            false -> "This was data set when app resumed"
//        }
////        TODO this is where we want to refresh
//        viewBiding.textViewRefreshStatus.text = data
//        isFirstLoad = false

//        refreshTimer = fixedRateTimer(period = 1000L) {
////            we need this to be allowed to touch UI
//            runOnUiThread {
//                seconds++
//                viewBiding.textViewLengthStatus.text = "More text: $seconds"
//            }
//        }
    }

    override fun onRestart() {
        super.onRestart()

        // not that common - better to do it in onResume
        viewBiding.textViewRefreshStatus.text = "Hello - status is 'onRestart'"
    }

    override fun onPause() {
        super.onPause()

        Log.d("karlo", "onPause() called")

//        refreshTimer.cancel()
    }

    override fun onStop() {
        super.onStop()
        Log.d("karlo", "onStop() called")
    }

//    override fun onDestroy() {
//        Log.d("karlo", "onDestroy() called")
//        val message: String = viewBiding.editTextMessage.text.toString()
//
//        val file: File = File(filesDir, "message.txt")
//        file.writeText(message)
//
//        super.onDestroy()
//    }

//    override fun onBackPressed() {
////        this makes app not leave the app, if removed
////        super.onBackPressed()
//    }

    fun showDialog() {
        AlertDialog.Builder(this).setTitle("Some Dialog").setMessage("Some message")
            .setView(R.layout.dialog_warning)
            .setPositiveButton(
                "Yes"
            ) { dialog, which -> finish() }
            .setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "No clicked", Toast.LENGTH_LONG).show()
                    dialog?.dismiss()
                }
            })
            .setNeutralButton("Help", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Help clicked", Toast.LENGTH_LONG).show()
                    dialog?.dismiss()
                }

            })
            .show()

    }

    //    onsaveinstancestate
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

//
        val savedTextViewMessage: String = viewBiding.textViewMessage.text.toString()
        outState.putString("savedTextViewMessage", savedTextViewMessage)

    }
}