package xyz.imkaem.shameless

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var messageValue: Message;
    private lateinit var messageText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayMessage()
        setupButton()
    }


    private fun displayMessage() {
//        val contactName: String? = intent.getStringExtra("Contact Name", )
//        val shouldIncludeJunior: Boolean = intent.getBooleanExtra("Contact Name", false )
        messageValue = intent.getSerializableExtra("message") as Message
        messageText = """
                Hi, ${messageValue.contactName},             
                My name is ${messageValue.myName}, and I am ${if (messageValue.shouldIncludeJunior) "a Junior" else "an"} ${messageValue.jobTitle}.     
            """.trimIndent();

        //        extensions work here
        text_view_message.text = messageText
    }

    private fun setupButton() {

        println("Something")


        button_send_message.setOnClickListener {
//        create intent
//        // apply will modify this instance
            val intent: Intent = Intent(Intent.ACTION_SENDTO).apply {
//            these are instance properties - instance of this current Intent - and we can access it with .apply
                data = Uri.parse("smsto: ${messageValue.number}")
                putExtra("sms_body", messageText)
//            putExtra(Intent.EXTRA_STREAM, attachment)
            }

            startActivity(intent)

        }

    }
}