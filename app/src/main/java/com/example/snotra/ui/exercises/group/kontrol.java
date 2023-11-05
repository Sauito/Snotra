package com.example.snotra.ui.exercises.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class kontrol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView kontrolList;
        String[] array;
        ArrayAdapter<String> adapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontrol);
        kontrolList = findViewById(R.id.kontrolList);
        array = getResources().getStringArray(R.array.kontrol_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        kontrolList.setAdapter(adapter);
    }
}