package xyz.imkaem.registerme

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {

    private lateinit var registrationSummary: RegistrationSummary;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        retrieveRegistrationSummary()
        displayRegistrationSummary()
        setButtonListeners()
    }

    private fun setButtonListeners() {
        button_to_email.setOnClickListener {
            val content: String = "${registrationSummary.title} ${registrationSummary.lastName}"

            val intent: Intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${registrationSummary.email}")
                putExtra(Intent.EXTRA_SUBJECT, content)
            }

            startActivity(intent)
        }

        button_to_sms.setOnClickListener {
            val content: String = "${registrationSummary.title} ${registrationSummary.lastName}"

            val intent: Intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${registrationSummary.phoneNumber}")
                putExtra(Intent.EXTRA_STREAM, content)
            }

            startActivity(intent)
        }
    }


    private fun retrieveRegistrationSummary() {

        registrationSummary = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("registration-summary") as RegistrationSummary
        } else {
            intent.getSerializableExtra("registration-summary", RegistrationSummary::class.java)!!
        }
    }


    private fun displayRegistrationSummary() {
        text_view_first_name.text = registrationSummary.firstName
        text_view_last_name.text = registrationSummary.lastName
        text_view_email.text = registrationSummary.email
        text_view_password.text = registrationSummary.password
        text_view_email.text = registrationSummary.email
        text_view_title.text = registrationSummary.title
    }
}