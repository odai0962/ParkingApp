package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CarParkDetailes extends AppCompatActivity {
    TextView carModel, carColor, carId;
    RelativeLayout toTimePiker, fromTimePiker;
    TextView fromTime, toTime;

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

        carModel = findViewById(R.id.carModel);
        carModel.setText(contactType);
        carColor = findViewById(R.id.carColorText);
        carColor.setText(contactColor);
        carId = findViewById(R.id.caridText);
        carId.setText(String.valueOf(contactId));

        // Time picker
        fromTime = findViewById(R.id.fromTime);
        toTime = findViewById(R.id.toTime);

        toTimePiker = findViewById(R.id.ToTimePiker);
        fromTimePiker = findViewById(R.id.fromTimePiker);

        // Set the initial time to the current time
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);
        String currentTime = String.format("%02d:%02d", currentHour, currentMinute);

        fromTime.setText(currentTime);
        toTime.setText(currentTime);

        fromTimePiker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CarParkDetailes.this, "from", Toast.LENGTH_SHORT).show();
                openFromTimeDialog();
            }
        });

        toTimePiker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CarParkDetailes.this, "to", Toast.LENGTH_SHORT).show();
                openToTimeDialog();
            }
        });
    }

    private void openFromTimeDialog() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog pickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
                String selectedTime = String.format("%02d:%02d", hour, minutes);
                if (selectedTime.equals(toTime.getText().toString())) {
                    Toast.makeText(CarParkDetailes.this, "From time cannot be equal to To time", Toast.LENGTH_SHORT).show();
                } else {
                    fromTime.setText(selectedTime);
                }
            }
        }, currentHour, currentMinute, true);
        pickerDialog.show();
        Log.d("CarParkDetailes", "FromTimeDialog shown");
    }

    private void openToTimeDialog() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog pickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
                String selectedTime = String.format("%02d:%02d", hour, minutes);
                if (selectedTime.equals(fromTime.getText().toString())) {
                    Toast.makeText(CarParkDetailes.this, "To time cannot be equal to From time", Toast.LENGTH_SHORT).show();
                    // Reset the ToTime to prevent selection of equal times
                    timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
                    timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
                    toTime.setTextColor(getResources().getColor(android.R.color.holo_red_light)); // Change text color to red
                    return;
                } else if (isToTimeLessThanFromTime(hour, minutes)) {
                    Toast.makeText(CarParkDetailes.this, "To time cannot be less than From time", Toast.LENGTH_SHORT).show();
                    // Reset the ToTime to prevent selection of less than times
                    timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
                    timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
                    toTime.setTextColor(getResources().getColor(android.R.color.holo_red_light)); // Change text color to red
                    return;
                }
                toTime.setText(selectedTime);
                toTime.setTextColor(getResources().getColor(android.R.color.black)); // Reset text color
            }
        }, currentHour, currentMinute, true);
        pickerDialog.show();
        Log.d("CarParkDetailes", "ToTimeDialog shown");
    }



    // Helper method to check if ToTime is less than FromTime
    private boolean isToTimeLessThanFromTime(int selectedHour, int selectedMinute) {
        String[] fromTimeArray = fromTime.getText().toString().split(":");
        int fromHour = Integer.parseInt(fromTimeArray[0]);
        int fromMinute = Integer.parseInt(fromTimeArray[1]);

        if (selectedHour < fromHour) {
            return true;
        } else if (selectedHour == fromHour && selectedMinute < fromMinute) {
            return true;
        }
        return false;
    }
}
