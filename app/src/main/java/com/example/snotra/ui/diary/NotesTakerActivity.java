package com.example.snotra.ui.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.snotra.R;
import com.example.snotra.ui.diary.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {
    EditText editText_title, editText_notes;
    ImageView imageView_save_note;
    Notes notes;
    boolean isOldNote=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        editText_notes=findViewById(R.id.editText_notes);
        editText_title=findViewById(R.id.editText_title);
        imageView_save_note=findViewById(R.id.imageView_save_note);
        notes = new Notes();
        try{
        notes = (Notes) getIntent().getSerializableExtra("old_note");
        editText_title.setText(notes.getTitle());
        editText_notes.setText(notes.getNotes());
        isOldNote=true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        imageView_save_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText_title.getText().toString();
                String desc=editText_notes.getText().toString();

                if(desc.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this,"Введите текст",Toast.LENGTH_LONG).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
                Date date = new Date();
                if (!isOldNote){
                    notes = new Notes();
                }
                notes.setTitle(title);
                notes.setNotes(desc);
                notes.setDate(formatter.format(date));

                Intent intent = new Intent();
                intent.putExtra("note",notes);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });
    }
}