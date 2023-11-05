package com.example.snotra;

import android.os.Bundle;


import com.example.snotra.ui.exercises.fear;
import com.example.snotra.ui.exercises.kontrol;
import com.example.snotra.ui.exercises.lostness;
import com.example.snotra.ui.exercises.selfharming;
import com.example.snotra.ui.exercises.selfhatred;
import com.example.snotra.ui.exercises.wrath;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.View;
import android.content.Intent;

import com.example.snotra.databinding.ActivityMainBinding;

public class ActivityMain extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_exercises,
                R.id.navigation_diary,
                R.id.navigation_articles)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
    public void wrath (View view){
        Intent intent = new Intent(this, wrath.class);
                startActivity(intent);
    }
    public void fear (View view){
        Intent intent = new Intent(this, fear.class);
        startActivity(intent);
    }
    public void kontrol (View view) {
        Intent intent = new Intent(this, kontrol.class);
        startActivity(intent);
    }
    public void lostness (View view) {
        Intent intent = new Intent(this, lostness.class);
        startActivity(intent);
    }
    public void selfharming (View view) {
        Intent intent = new Intent(this, selfharming.class);
        startActivity(intent);
    }
    public void selfhatred (View view) {
        Intent intent = new Intent(this, selfhatred.class);
        startActivity(intent);
    }
}