package com.example.snotra.ui.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class fear extends AppCompatActivity {
    private ListView fearlist;
    private String[] array;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fear);
        fearlist = findViewById(R.id.fearList);
        array = getResources().getStringArray(R.array.fear_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        fearlist.setAdapter (adapter);
    }
}