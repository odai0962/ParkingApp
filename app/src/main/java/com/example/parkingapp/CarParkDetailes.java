package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class CarParkDetailes extends AppCompatActivity {
    TextView carModel, carColor, carId;
    RelativeLayout toTimePiker, fromTimePiker;
    TextView fromTime, toTime, parkingSetData, ParkingNumData;
    Button NextButtonDetailes;
    ImageView backArrowCarParkDetailes;
    String timeDifference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_detailes);

        // Retrieve the data from the intent
        Intent intent = getIntent();
        int contactId = intent.getIntExtra("CONTACT_ID", 0);
        String contactColor = intent.getStringExtra("CONTACT_COLOR");
        String contactType = intent.getStringExtra("CONTACT_TYPE");
        String parkingSection = intent.getStringExtra("parkingSectionA");
        String selectedLeftItem = intent.getStringExtra("SELECTED_LEFT_ITEM");
        String selectedRightItem = intent.getStringExtra("SELECTED_RIGHT_ITEM");

        carModel = findViewById(R.id.carModel);
        carModel.setText(contactType);
        carColor = findViewById(R.id.carColorText);
        carColor.setText(contactColor);
        carId = findViewById(R.id.caridText);
        carId.setText(String.valueOf(contactId));

        parkingSetData = findViewById(R.id.parkingSetData);
        ParkingNumData = findViewById(R.id.ParkingNumData);

        parkingSetData.setText(parkingSection);
        if (selectedRightItem != null) {
            ParkingNumData.setText(selectedRightItem);
        } else if (selectedLeftItem != null) {
            ParkingNumData.setText(selectedLeftItem);
        }

        // Time picker
        fromTime = findViewById(R.id.fromTime);
        toTime = findViewById(R.id.toTime);

        toTimePiker = findViewById(R.id.ToTimePiker);
        fromTimePiker = findViewById(R.id.fromTimePiker);

        // Set the initial time to the current time
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);
        String currentTime = String.format(Locale.getDefault(), "%02d:%02d", currentHour, currentMinute);

        fromTime.setText(currentTime);

        // Add one hour to the current time for the toTime
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        int newHour = calendar.get(Calendar.HOUR_OF_DAY);
        int newMinute = calendar.get(Calendar.MINUTE);
        String newTime = String.format(Locale.getDefault(), "%02d:%02d", newHour, newMinute);

        toTime.setText(newTime);

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
        NextButtonDetailes = findViewById(R.id.NextButtonDetailes);

        NextButtonDetailes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(CarParkDetailes.this, TermsAndConditions.class);
                intent1.putExtra("timeDifference",timeDifference);
                if (selectedRightItem != null) {
                  intent1.putExtra("selectedItem",selectedRightItem);
                } else if (selectedLeftItem != null) {
                    intent1.putExtra("selectedItem",selectedLeftItem);
                }
                startActivity(intent1);
            }
        });
        backArrowCarParkDetailes = findViewById(R.id.backArrowCarParkDetailes);
        backArrowCarParkDetailes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(CarParkDetailes.this, ParkingLot.class);
                startActivity(intent1);
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
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minutes);
                if (selectedTime.equals(toTime.getText().toString())) {
                    Toast.makeText(CarParkDetailes.this, "From time cannot be equal to To time", Toast.LENGTH_SHORT).show();
                } else {
                    fromTime.setText(selectedTime);
                    calculateTimeDifference();
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
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minutes);
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
                calculateTimeDifference();
            }
        }, currentHour, currentMinute, true);
        pickerDialog.show();
        Log.d("CarParkDetailes", "ToTimeDialog shown");
    }

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

    private void calculateTimeDifference() {
        String[] fromTimeArray = fromTime.getText().toString().split(":");
        String[] toTimeArray = toTime.getText().toString().split(":");

        int fromHour = Integer.parseInt(fromTimeArray[0]);
        int fromMinute = Integer.parseInt(fromTimeArray[1]);
        int toHour = Integer.parseInt(toTimeArray[0]);
        int toMinute = Integer.parseInt(toTimeArray[1]);

        int fromTotalMinutes = fromHour * 60 + fromMinute;
        int toTotalMinutes = toHour * 60 + toMinute;

        int differenceInMinutes = toTotalMinutes - fromTotalMinutes;
        int diffHours = differenceInMinutes / 60;
        int diffMinutes = differenceInMinutes % 60;

        timeDifference = String.format(Locale.getDefault(), "%02d:%02d", diffHours, diffMinutes);
        Log.d("CarParkDetailes", "Time Difference: " + timeDifference);
    }
}
