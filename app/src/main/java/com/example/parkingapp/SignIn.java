package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.parkingapp.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignIn extends AppCompatActivity {
    Button signinButton; // Declare the button variable

    ActivitySignInBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


                binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore =FirebaseFirestore.getInstance();
        auth =FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Create You'r  Account");
        progressDialog.setMessage("please Wait");

        binding.dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });




          binding.backArrowSignIn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(SignIn.this, MainActivity.class);
                  startActivity(intent);
              }
          });
        binding.signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.ETSI.getText().toString();
                String password = binding.ETP.getText().toString();

                if (email.isEmpty()){
                    binding.ETSI.setError("Enter your Student ID ");
                } else if (password.isEmpty()) {
                    binding.ETP.setError("Enter your Password");
                }else {

                    progressDialog.show();
                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                progressDialog.dismiss();
                                startActivity(new Intent(SignIn.this,MainHomePage.class));
                                finish();

                            }else {

                                progressDialog.dismiss();
                                Toast.makeText(SignIn.this, ""+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });





        binding.ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, ForgetPassword.class));
            }
        });




    }
}
