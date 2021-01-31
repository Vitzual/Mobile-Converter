package com.example.grahams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Set variables for radio group and radio buttons
    RadioGroup radioGroup;
    RadioButton radioButton;

    // Set variable for the edit text field
    EditText numberToCalculate;
    TextView calculatedNumber;

    // On create, create the on click listener for the calculate button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatedNumber = findViewById(R.id.calculatedNumber);
        numberToCalculate = findViewById(R.id.numberInput);
        radioGroup = findViewById(R.id.radioGroup);
        Button buttonCalculate = findViewById(R.id.button_apply);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                int number = Integer.parseInt(numberToCalculate.getText().toString());

                radioButton = findViewById(radioId);

                // Find which radio button is selected
                String total;
                if (radioButton.getText().toString().equals("Micrograms")) {
                    total = (number * 1000000) + " " + radioButton.getText().toString();
                }
                else if (radioButton.getText().toString().equals("Milligrams")) {
                    total = (number * 1000) + " " + radioButton.getText().toString();
                }
                else if (radioButton.getText().toString().equals("Kilograms")) {
                    total = (number * 0.001) + " " + radioButton.getText().toString();
                }
                else {
                    total = "Error converting";
                }

                calculatedNumber.setText(total);
            }
        });
    }

    // Get the selected radio button
    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast toast = Toast.makeText(this, "Selected " + radioButton.getText(), Toast.LENGTH_SHORT);
        toast.show();
    }
}