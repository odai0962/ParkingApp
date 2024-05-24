package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.parkingapp.databinding.ActivityAddNewCardBinding;

public class AddNewCard extends AppCompatActivity {

    private ActivityAddNewCardBinding addNewCardBinding;
    private AddCardContentClickHandler clickHandler;
    private AddCardContent addCardContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        addCardContent = new AddCardContent();
        addNewCardBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_card
        );

         AddCardModel cardModel = new ViewModelProvider(this).get(AddCardModel.class);

         clickHandler = new AddCardContentClickHandler(
                addCardContent,
                this,
                 cardModel
        );
        addNewCardBinding.setAddCardContent(addCardContent);
        addNewCardBinding.setClickHandler(clickHandler); // Corrected method name
    }
}
