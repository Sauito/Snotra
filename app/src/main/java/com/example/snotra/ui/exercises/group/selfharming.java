package com.example.snotra.ui.exercises.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class selfharming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView selfharmingList;
        String[] array;
        ArrayAdapter<String> adapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfharming);
        selfharmingList = findViewById(R.id.selfharmingList);
        array = getResources().getStringArray(R.array.selfharming_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        selfharmingList.setAdapter (adapter);
    }
}
