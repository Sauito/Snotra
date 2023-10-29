package com.example.snotra.ui.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snotra.R;

public class wrath extends AppCompatActivity {
private ListView wrathlist;
private String[] array;
private ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrath);
        wrathlist = findViewById(R.id.wrathList);
        array = getResources().getStringArray(R.array.wrath_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        wrathlist.setAdapter (adapter);
    }
}