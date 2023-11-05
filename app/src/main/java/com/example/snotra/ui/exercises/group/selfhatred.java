package com.example.snotra.ui.exercises.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class selfhatred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView selfhatredList;
        String[] array;
        ArrayAdapter<String> adapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfhatred);
        selfhatredList = findViewById(R.id.selfhatredList);
        array = getResources().getStringArray(R.array.selfhatred_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        selfhatredList.setAdapter (adapter);
    }
}
