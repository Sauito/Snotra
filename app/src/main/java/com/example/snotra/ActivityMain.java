package com.example.snotra;

import android.os.Bundle;

import com.example.snotra.ui.first_aid.first_aid;
import com.example.snotra.ui.settings.settings;
import com.example.snotra.ui.articles.articles1;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
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
               Intent intent = new Intent(this, FirstAid.class);
               startActivity(intent);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

}