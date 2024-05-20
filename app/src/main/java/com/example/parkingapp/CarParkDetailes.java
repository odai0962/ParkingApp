package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CarParkDetailes extends AppCompatActivity {
       TextView carModel , carColor,carId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_detailes);

        // Retrieve the data from the intent
        Intent intent = getIntent();
        int contactId = intent.getIntExtra("CONTACT_ID", 0);
        String contactColor = intent.getStringExtra("CONTACT_COLOR");
        String contactType = intent.getStringExtra("CONTACT_TYPE");
        Log.d("CarParkDetailes", "CONTACT_ID: " + contactId);
        Log.d("CarParkDetailes", "CONTACT_COLOR: " + contactColor);
        Log.d("CarParkDetailes", "CONTACT_TYPE: " + contactType);

        // Rest of your code


        carModel= findViewById(R.id.carModel);
        carModel.setText(""+contactType);
        carColor= findViewById(R.id.carColorText);
        carColor.setText(contactColor);
        carId =findViewById(R.id.caridText);
        carId.setText(String.valueOf(contactId));



    }

}