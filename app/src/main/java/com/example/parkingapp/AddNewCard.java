package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.parkingapp.databinding.ActivityAddNewCardBinding;

public class AddNewCard extends AppCompatActivity {

    private ActivityAddNewCardBinding addNewCardBinding;
    private AddCardContentClickHandler clickHandler;
    private AddCardContent addCardContent;
    private ImageView backArrowADDNEWCARD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize DataBinding
        addNewCardBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_card);

        // Initialize the ViewModel
        AddCardModel cardModel = new ViewModelProvider(this).get(AddCardModel.class);

        // Initialize your data object and click handler
        addCardContent = new AddCardContent();
        clickHandler = new AddCardContentClickHandler(addCardContent, this, cardModel);

        // Bind data and handlers to the layout
        addNewCardBinding.setAddCardContent(addCardContent);
        addNewCardBinding.setClickHandler(clickHandler);

        // Setup the back arrow button click listener
        backArrowADDNEWCARD = findViewById(R.id.backArrowADDNEWCARD);
        backArrowADDNEWCARD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPaymentMethod();
            }
        });
    }

    private void navigateToPaymentMethod() {
        Intent intent = new Intent(AddNewCard.this, PaymentMethod.class);
        startActivity(intent);
    }
}
