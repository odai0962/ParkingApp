package com.example.parkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {
    RelativeLayout relativeEditProfile;
    RelativeLayout relativeLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Find views by ID
        relativeEditProfile = view.findViewById(R.id.relativeEditProfile);
        relativeLogout = view.findViewById(R.id.relativeLogout);

        // Set click listener for Edit Profile
        relativeEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditProfile.class);
                startActivity(intent);
            }
        });

        // Set click listener for Logout
        relativeLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform logout
                FirebaseAuth.getInstance().signOut();
                // Navigate to SignIn activity
                Intent intent = new Intent(getContext(), SignIn.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear back stack
                startActivity(intent);
            }
        });

        return view;
    }
}
