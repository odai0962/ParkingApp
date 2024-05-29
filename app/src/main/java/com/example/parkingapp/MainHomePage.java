package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainHomePage extends AppCompatActivity {
    private BottomNavigationView navigation;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        navigation = findViewById(R.id.navigation);
        frameLayout = findViewById(R.id.frameLayout);  // Ensure this matches the XML ID

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    loadFragment(new HomeFragment(), false);
                } else if (itemId == R.id.nav_archive) {
                    loadFragment(new ArchiveFragment(), false);
                } else {
                    loadFragment(new SettingsFragment(), false);
                }
                return true;
            }
        });

        Intent intent = getIntent();
        Boolean message = intent.getBooleanExtra("buttonYes", false);

        if (message) {
            reloadHomeFragment();
        } else {
            loadFragment(new HomeFragment(), true);
        }
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout, fragment);  // Ensure this matches the XML ID
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);  // Ensure this matches the XML ID
        }
        fragmentTransaction.commit();
    }

    private void reloadHomeFragment() {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        Boolean message = getIntent().getBooleanExtra("buttonYes", false);
        bundle.putBoolean("odaizagha", message);
        homeFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, homeFragment)
                .commit();
    }
}
