package xyz.imkaem.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("karlo", "onCreate() called")

        val timer: CountDownTimer = object: CountDownTimer(2000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                println("Ticking")
            }

            override fun onFinish() {
                Log.d("karlo", "onFinish() called")
                finish()
            }
        }

//        timer.start()
    }

    override fun onDestroy() {
        Log.d("karlo", "onDestroy() called")
        super.onDestroy()
    }
}