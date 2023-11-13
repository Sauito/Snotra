package com.example.snotra.ui.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.snotra.R;

public class NotesTakerActivity extends AppCompatActivity {
    EditText editText_title, editText_notes;
    ImageView imageView_save_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        editText_notes=findViewById(R.id.editText_notes);
        editText_title=findViewById(R.id.editText_title);
        imageView_save_note=findViewById(R.id.imageView_save_note);
    }
}