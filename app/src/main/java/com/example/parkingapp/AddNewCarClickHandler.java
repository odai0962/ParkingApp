package com.example.parkingapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNewCarClickHandler {
    AddCarContacts contacts;
    Context context;
    AddCarModel carModel;
    public AddNewCarClickHandler(AddCarContacts contacts, Context context,AddCarModel carModel) {
        this.contacts = contacts;
        this.context = context;
        this.carModel = carModel;

    }
    public void onSubmitBTNClicked(View view){
        if (contacts.getType() == null || contacts.getID() == -1 || contacts.getColor() == null){
            Toast.makeText(context, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainHomePage.class);

            intent.putExtra("CarType", contacts.getType());
            AddCarContacts c = new AddCarContacts(
                    contacts.getType(),
                    contacts.getColor()
            );
            carModel.addNewContact(c);
            context.startActivity(intent);
        }
    }

}
