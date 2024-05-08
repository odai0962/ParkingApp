package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        Button signUpDoneButton = findViewById(R.id.signUpDoneButton);

        signUpDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(SignUp3.this); // Use SignUp3.this as the context
                dialog.setContentView(R.layout.dialog);

                Button closeButton = dialog.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Intent intent = new Intent(SignUp3.this, SignIn.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });
    }
}
