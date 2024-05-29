package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.parkingapp.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backArrowSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Create Your Account");
        progressDialog.setMessage("Please Wait");

        binding.signUpNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = binding.Fname.getText().toString();
                String lastName = binding.Lname.getText().toString();
                String email = binding.editEmail.getText().toString();
                String password = binding.editPassword.getText().toString();
                String confirmPassword = binding.editConfirmPassword.getText().toString();
                String studentID = binding.editStudentID.getText().toString();
                String phoneNumber = binding.editPhone.getText().toString();

                if (firstName.isEmpty()) {
                    binding.Fname.setError("Enter your First Name");
                } else if (lastName.isEmpty()) {
                    binding.Lname.setError("Enter your Last Name");
                } else if (email.isEmpty()) {
                    binding.editEmail.setError("Enter your Email");
                } else if (password.isEmpty()) {
                    binding.editPassword.setError("Enter your Password");
                } else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
                    binding.editConfirmPassword.setError("Password does not match");
                } else if (studentID.isEmpty()) {
                    binding.editStudentID.setError("Enter your Student ID");
                } else if (phoneNumber.isEmpty()) {
                    binding.editPhone.setError("Enter your Phone Number");
                } else {
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                SignupModel model = new SignupModel(firstName, lastName, email, password, confirmPassword, studentID, phoneNumber);

                                String id = task.getResult().getUser().getUid();
                                firestore.collection("users").document(id).set(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressDialog.dismiss();
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignUp.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(SignUp.this, SignIn.class));
                                            finish();
                                        } else {
                                            Toast.makeText(SignUp.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(SignUp.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        binding.nextLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, SignIn.class));
            }
        });
    }
}
