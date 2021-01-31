package com.example.grahams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Set variables for radio group and radio buttons
    RadioGroup radioGroup;
    RadioButton radioButton;

    // Set variable for the edit text field
    EditText numberToCalculate;

    // On create, create the on click listener for the calculate button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberToCalculate = findViewById(R.id.numberInput);
        radioGroup = findViewById(R.id.radioGroup);
        Button buttonCalculate = findViewById(R.id.button_apply);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                int number = Integer.parseInt(numberToCalculate.getText().toString());
                radioButton = findViewById(radioId);
            }
        });
    }

    // Get the selected radio button
    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        int number = Integer.parseInt(numberToCalculate.getText().toString());
        radioButton = findViewById(radioId);

        // Find which radio button is selected
        if (radioButton.getText() == "Milligrams") {

        }

        // Display to screen
        Toast toast = Toast.makeText(this, "Test", Toast.LENGTH_SHORT);
        toast.show();
    }
}