package xyz.imkaem.shameless

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
/*    private var textInputContactName: TextInputEditText? = null;
    private var textInputContactNumber: TextInputEditText? = null
    private var textInputMyName: TextInputEditText? = null
    private var textInputStartDate: TextInputEditText? = null

    private var checkboxIncludeJunior: CheckBox? = null
    private var checkboxStartImmediately: CheckBox? = null

    private var spinnerJobTitle: Spinner? = null*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setInputViews()

//        val buttonPreview: Button = findViewById(R.id.button_preview)
//        TODO this is old
//        buttonPreview.setOnClickListener {
//        this is kotlinx sythetic
        button_preview.setOnClickListener {
//            Toast.makeText(this, "This might wrok", Toast.LENGTH_LONG).show();
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Developer", "PM", "Something else")

        // we create adapter for spinner
        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerValues)

        spinner_job_title.adapter = spinnerAdapter;
    }

    private fun setInputViews() {
//        this is old
/*        textInputContactName =
            findViewById(R.id.text_input_edit_text_contact_name)
        textInputContactNumber =
            findViewById(R.id.text_input_edit_text_contact_number)
        textInputMyName =
            findViewById(R.id.text_input_edit_text_my_display_name)
        textInputStartDate =
            findViewById(R.id.text_input_edit_text_start_date)

        checkboxIncludeJunior = findViewById(R.id.checkbox_include_junior)
        checkboxStartImmediately = findViewById(R.id.checkbox_start_immediately)

        spinnerJobTitle = findViewById(R.id.spinner_job_title)*/

//        and extensions are deprecated
    }

    private fun onPreviewClicked() {
//        val logMessage: String =
//            String.format("Currently, contactName view is: %s", textInputContactName)

//        Log.d("contactNameTag", logMessage)

/*        val contactName = textInputContactName?.text
        val myName = textInputMyName?.text
        val contactNumber = textInputContactNumber?.text
        val startDate = textInputStartDate?.text

        val shouldIncludeJunior = checkboxIncludeJunior?.isChecked
        val canStartImmediately = checkboxStartImmediately?.isChecked*/

//        val jobTitle = spinnerJobTitle?.selectedItem

        val contactName = text_input_edit_text_contact_name.text.toString()
        val myName = text_input_edit_text_my_display_name.text.toString()
        val contactNumber = text_input_edit_text_contact_number.text.toString()
        val startDate = text_input_edit_text_start_date.text.toString()

        val shouldIncludeJunior = checkbox_include_junior.isChecked
        val canStartImmediately = checkbox_start_immediately.isChecked

//        we have to do this to make sure selcted item is string - because it could be anything
        val jobTitle = spinner_job_title.selectedItem?.toString()


        val message: String = String.format(
            "To %s: My name is %s, and this is my phone number: %s. I Am available to start from %s",
//            textInputContactName!!.text,
//            textInputMyName!!.text,
//            textInputContactNumber!!.text,
//            textInputStartDate!!.text
            text_input_edit_text_contact_name.text,
            text_input_edit_text_my_display_name.text,
            text_input_edit_text_contact_number.text,
            text_input_edit_text_start_date.text,
        )

        val anotherMessage: String = "This is templates: $contactName, and another variable: $shouldIncludeJunior"

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

//        create intent

//        lets make new message object
        val messageValue: Message = Message(
            contactName,
            contactNumber,
            myName,
            jobTitle ?: "fallback",
            startDate,
            shouldIncludeJunior,
            canStartImmediately,
        )


        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
//        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("message", messageValue)

        startActivity(previewActivityIntent)
    }
}