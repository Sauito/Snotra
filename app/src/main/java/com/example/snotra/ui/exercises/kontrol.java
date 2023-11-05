package com.example.snotra.ui.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class kontrol extends AppCompatActivity {
    private ListView kontrolList;
    private String[] array;
    private  ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontrol);
        kontrolList = findViewById(R.id.kontrolList);
        array = getResources().getStringArray(R.array.kontrol_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        kontrolList.setAdapter(adapter);
    }
}