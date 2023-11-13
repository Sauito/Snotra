package com.example.snotra.ui.diary;

import androidx.cardview.widget.CardView;

import com.example.snotra.ui.diary.models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);


}
