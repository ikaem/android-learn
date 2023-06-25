package xyz.imkaem.bucketer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonToThings;
    Button buttonToPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // selecting views
        buttonToThings = findViewById(R.id.button_to_things);
        buttonToPlaces = findViewById(R.id.button_to_places);

        // attach navigation listeners
        buttonToThings.setOnClickListener(new View.OnClickListener() {
            // will need to build intent here

            @Override
            public void onClick(View view) {
            Intent toThingsIntent = new Intent(MainActivity.this, ThingsActivity.class);

            startActivity(toThingsIntent);

            }
        });

        buttonToPlaces.setOnClickListener(new View.OnClickListener() {
            // will need to build intent here

            @Override
            public void onClick(View view) {

                Intent toThingsIntent = new Intent(MainActivity.this, PlacesActivity.class);

                startActivity(toThingsIntent);

            }
        });
    }
}