package xyz.imkaem.thehungryjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView cardStarters;
    CardView cardMains;
    CardView cardDesserts;
    TextView textViewSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        assign view variables
        cardStarters = findViewById(R.id.card_view_starters);
        cardMains = findViewById(R.id.card_view_main_courses);
        cardDesserts = findViewById(R.id.card_view_desserts);
        textViewSendEmail = findViewById(R.id.text_view_send_email);

        cardStarters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
                startActivity(startersActivityIntent);

            }
        });

        cardMains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // now we create the intent - pass it context, and where to go
                Intent mainsActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);

                startActivity(mainsActivityIntent);

                // and then we need to call to start activity
            }
        });

        cardDesserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // now we create the intent - pass it context, and where to go
                Intent mainsActivityIntent = new Intent(MainActivity.this, DessertsActivity.class);

                startActivity(mainsActivityIntent);

                // and then we need to call to start activity
            }
        });

        textViewSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // now we need to create implicit intent
                Intent sendEmailIntent = new Intent(
                        Intent.ACTION_SENDTO
                );
                // with this, only email apps should be handling this intent
                sendEmailIntent.setData(Uri.parse("mailto:theinfo@hungryjava.com"));

                startActivity(sendEmailIntent);
            }
        });
    }
}