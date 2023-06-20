package xyz.imkaem.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button buttonCalculate;
    private TextView resultText;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextAge;
    private EditText editTextHeightMeters;
    private EditText editTextHeightCentimeters;
    private EditText editTextWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this is important
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();

//        String message = "Some message of string type";
//
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//        findViewById(R.id.text_view_result);

//        resultText.setText("Hello");
    }


    private void findViews() {
//        this assigns views to variables
//      TextView resultText = findViewById(R.id.text_view_result);
        resultText = findViewById(R.id.text_view_result);
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextHeightMeters = findViewById(R.id.edit_text_height_meters);
        editTextHeightCentimeters = findViewById(R.id.edit_text_height_centimeters);
        editTextWeight = findViewById(R.id.edit_text_weight);
        buttonCalculate = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
                double result = calculateBMI();
                displayResult(result);
            }
        });
    }

    private double calculateBMI() {
        // Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
        String ageText = editTextAge.getText().toString();
        String heightMetersText = editTextHeightMeters.getText().toString();
        String heightCentimetersText = editTextHeightCentimeters.getText().toString();
        String weightText = editTextWeight.getText().toString();
//        resultText.setText(String.format("Age: %s, height in feet: %s, inches: %s, weight: %s", ageText, heightMetersText, heightCentimetersText, weightText));

        int age = Integer.parseInt(ageText);
        int heightMeters = Integer.parseInt(heightMetersText);
        int heightCentimeters = Integer.parseInt(heightCentimetersText);
        int weight = Integer.parseInt(weightText);

        double centimetersInMeters = heightCentimeters / 100;
        double metersTotal = heightMeters + centimetersInMeters;

        double result = weight / metersTotal * metersTotal;
        return result;
    }

    private void displayResult(double result) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String formattedResult = decimalFormatter.format(result);

        String message = "";
        String gender = "";

        if (result < 18.5) {
            message = "You are a bit thin";
        } else if (result > 25) {
            message = "You are a bit overweight";
        } else {
            message = "You are healthy";
        }

        if(radioButtonFemale.isChecked()) {
            gender = "female";
        } else {
            gender = "male";
        }

        resultText.setText(String.format("BMI: %s: %s for a %s", formattedResult, message, gender));
    }
}