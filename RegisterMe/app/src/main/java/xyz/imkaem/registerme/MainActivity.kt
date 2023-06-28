package xyz.imkaem.registerme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateTitleSpinner()
        setButtonListener()
    }

    private fun populateTitleSpinner() {
        val values: Array<String> = arrayOf(
            "Ms",
            "Mr",
            "Something else entirely"
        )

        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, values)

        spinner_job_title.adapter = spinnerAdapter

    }

    private fun setButtonListener() {
        val firstName: Editable? = text_input_edit_text_first_name.text
        val lastName: Editable? = text_input_edit_text_last_name.text
        val email: Editable? = text_input_edit_text_email.text
        val password: Editable? = text_input_edit_text_password.text
        val phoneNumber: Editable? = text_input_edit_text_phone_number.text



        button_to_summary.setOnClickListener {
            val jobTitleSelection = spinner_job_title.selectedItem
            val value = jobTitleSelection.toString()
            val registrationSummary: RegistrationSummary = RegistrationSummary(
                firstName?.toString(),
                lastName?.toString(),
                email?.toString(),
                password?.toString(),
                phoneNumber?.toString(),
                jobTitleSelection?.toString()
            )

            val toSummaryIntent: Intent = Intent(this, SummaryActivity::class.java)
//            now add extra to it - needs to be serialized
            toSummaryIntent.putExtra("registration-summary", registrationSummary)

            startActivity(toSummaryIntent)







        }


    }
}