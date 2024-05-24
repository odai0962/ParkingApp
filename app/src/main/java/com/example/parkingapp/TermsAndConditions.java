package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class TermsAndConditions extends AppCompatActivity {

    private CheckBox checkBox;
    private Button buttonLetsPark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        checkBox = findViewById(R.id.checkedBox);
        buttonLetsPark = findViewById(R.id.ButtonLetsPark);

        // Initially disable the button
        buttonLetsPark.setEnabled(false);

        // Add a listener to the checkbox to enable/disable the button accordingly
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                buttonLetsPark.setEnabled(isChecked);
            }
        });

        // Add a listener to the button to handle its click event
        buttonLetsPark.setOnClickListener(v -> {
            Intent intent = new Intent(TermsAndConditions.this, PaymentMethod.class);
            startActivity(intent);
        });
    }
}
