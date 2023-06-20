package xyz.imkaem.thehungryjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listViewStarters;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        listViewStarters = findViewById(R.id.list_view_starters);
    }
}