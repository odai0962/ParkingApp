package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.parkingapp.databinding.ActivityForgetPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ForgetPassword extends AppCompatActivity {

ActivityForgetPasswordBinding binding;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth =FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Create You'r  Account");
        progressDialog.setMessage("please Wait");

       binding.ForgetPasswordButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email = binding.editEmailForget.getText().toString();
               progressDialog.dismiss();
               if(email.isEmpty()){
                   binding.editEmailForget.setError("Enter your Email");


               }else {

                   auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if (task.isSuccessful()){
                               progressDialog.dismiss();
                               Toast.makeText(ForgetPassword.this, "Please Check your Email", Toast.LENGTH_SHORT).show();

                               startActivity(new Intent(ForgetPassword.this,SignIn.class));
                           }else {
                               progressDialog.dismiss();
                               Toast.makeText(ForgetPassword.this, ""+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }

           }
       });


        binding.TextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgetPassword.this,SignIn.class));
            }
        });
    }
}