package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.parkingapp.databinding.ActivityAddNewCarBinding;

public class AddNewCar extends AppCompatActivity {
    private ActivityAddNewCarBinding binding;
    private  AddNewCarClickHandler handler;
    private AddCarContacts addCarContacts;
     ImageView backArrowAddNewCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);

        addCarContacts = new AddCarContacts();
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_car
        );

        AddCarModel carModel =new ViewModelProvider(this).get(AddCarModel.class);


        handler =new AddNewCarClickHandler(
                addCarContacts,
                this,
                carModel

        );
        binding.setContact(addCarContacts);
        binding.setClickHandler(handler);
        backArrowAddNewCar = findViewById(R.id.backArrowAddNewCar);
        backArrowAddNewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AddNewCar.this,MainHomePage.class);
                startActivity(intent);
                finish();
            }
        });


    }




}