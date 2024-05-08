package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainHomePage extends AppCompatActivity {
    private BottomNavigationView navigation;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page); // Assuming your layout file is named activity_main_home_page.xml

        navigation = findViewById(R.id.navigation);
        frameLayout = findViewById(R.id.frameLayout);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.nav_home){
                  loadFragment(new HomeFragment(),false);
                } else if (itemId == R.id.nav_archive) {
                 loadFragment(new ArchiveFragment(),false);
                }else {
               loadFragment( new SettingsFragment(),false);
                }
                return true;
            }
        });
        loadFragment(new HomeFragment(),true);
    }
    private  void  loadFragment(Fragment fragment , boolean isAppIniatized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        if(isAppIniatized){
            fragmentTransaction.add(R.id.frameLayout,fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }

        fragmentTransaction.commit();
    }
}
