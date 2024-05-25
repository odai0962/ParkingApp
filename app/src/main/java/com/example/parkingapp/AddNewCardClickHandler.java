package com.example.parkingapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewCardClickHandler {
    private final Context context;

    public AddNewCardClickHandler(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view) {
        Intent intent = new Intent(context, AddNewCard.class);
        context.startActivity(intent);

    }
}
