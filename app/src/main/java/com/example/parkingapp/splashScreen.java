package com.example.parkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class splashScreen extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2000; // Splash screen duration in milliseconds

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if the user is already logged in
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null) {
                    // If user is logged in, navigate to MainHomePage
                    startActivity(new Intent(splashScreen.this, MainHomePage.class));
                } else {
                    // If user is not logged in, navigate to SignIn activity
                    startActivity(new Intent(splashScreen.this, SignIn.class));
                }
                // Close splash screen activity
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}
