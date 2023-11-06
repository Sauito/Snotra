package com.example.snotra.ui.exercises.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class fear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView fearlist;
        String[] array;
        ArrayAdapter<String> adapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fear);
        fearlist = findViewById(R.id.fearList);
        array = getResources().getStringArray(R.array.fear_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        fearlist.setAdapter (adapter);
    }
}