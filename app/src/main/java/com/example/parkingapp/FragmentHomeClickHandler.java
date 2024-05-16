package com.example.parkingapp;
import android.content.Context;
import android.view.View;
import android.content.Intent;
public class FragmentHomeClickHandler {
    Context context;

    public FragmentHomeClickHandler(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view){
        Intent intent = new Intent(view.getContext(), AddNewCar.class);
        context.startActivity(intent);
    }
}
