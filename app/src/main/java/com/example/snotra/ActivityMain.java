package com.example.snotra;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.snotra.databinding.ActivityMainBinding;
import com.example.snotra.ui.articles.articles1;


import com.example.snotra.ui.exercises.group.fear;
import com.example.snotra.ui.exercises.group.kontrol;
import com.example.snotra.ui.exercises.group.lostness;
import com.example.snotra.ui.exercises.group.selfharming;
import com.example.snotra.ui.exercises.group.selfhatred;
import com.example.snotra.ui.exercises.group.wrath;
import com.example.snotra.ui.first_aid.FirstAidActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class ActivityMain extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
public void articles1 (View view){
    Intent intent = new Intent(this, articles1.class);
startActivity(intent);
}

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.top_menu, menu);
            return true;
        }

        @Override
    public boolean onOptionsItemSelected(MenuItem item)
        {
            int itemId = item.getItemId();
            if (itemId == R.id.item_settings) {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            }
            else if (itemId == R.id.item_first_aid) {
               Intent intent = new Intent(this, FirstAidActivity.class);
               startActivity(intent);
                return true;
            }
            return super.onOptionsItemSelected(item);
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