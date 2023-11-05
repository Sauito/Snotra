package com.example.snotra.ui.exercises.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class lostness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView lostnessList;
        String[] array;
        ArrayAdapter<String> adapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostness);
        lostnessList = findViewById(R.id.lostnessList);
        array = getResources().getStringArray(R.array.lostness_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        lostnessList.setAdapter (adapter);
    }
}
