package com.example.snotra.ui.diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.snotra.R;
import com.example.snotra.databinding.FragmentDiaryBinding;
import com.example.snotra.ui.diary.Adapter.NotesListAdapter;
import com.example.snotra.ui.diary.DataBase.RoomDB;
import com.example.snotra.ui.diary.Models.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentDiary extends Fragment implements PopupMenu.OnMenuItemClickListener{

    private FragmentDiaryBinding binding;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    NotesListAdapter notesListAdapter;
    RoomDB database;
    List<Notes> notes = new ArrayList<>();
    SearchView diary_search_view;
    Notes selectedNote;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DiaryViewModel diaryViewModel =
                new ViewModelProvider(this).get(DiaryViewModel.class);

        binding = FragmentDiaryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView =root.findViewById(R.id.recycler_diary);
        add_button=root.findViewById(R.id.button_add_diary);
        diary_search_view=root.findViewById(R.id.diary_search_view);
        database=RoomDB.getInstance(this);
        notes = database.mainDAO().getAll();
        updateRecycler(notes);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotesTakerActivity.class);
                startActivityForResult(intent,101);

            }
        });

        diary_search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
        return root;
    }

    private void filter(String newText) {
        List<Notes> filteredlist = new ArrayList<>();
        for (Notes singleNote:notes){
            if(singleNote.getTitle().toLowerCase().contains(newText.toLowerCase())
                ||singleNote.getNotes().toLowerCase().contains(newText.toLowerCase()))
            {
                filteredlist.add(singleNote);
            }
        }
        notesListAdapter.filterList(filteredlist);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                Notes new_notes= (Notes) data.getSerializableExtra("note");
                database.mainDAO().insert(new_notes);
                notes.clear();
                notes.addAll(database.mainDAO().getAll());
                notesListAdapter.notifyDataSetChanged();
            }

        }
        if(requestCode==102)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                Notes new_notes= (Notes) data.getSerializableExtra("note");
                database.mainDAO().update(new_notes.getID(), new_notes.getTitle(), new_notes.getNotes());
                notes.clear();
                notes.addAll(database.mainDAO().getAll());
                notesListAdapter.notifyDataSetChanged();
            }
        }
    }

    private void updateRecycler(List<Notes> notes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        notesListAdapter = new NotesListAdapter(getActivity(),notes, notesClickListener);
        recyclerView.setAdapter(notesListAdapter);

    }

    private final NotesClickListener notesClickListener = new NotesClickListener() {
        @Override
        public void onClick(Notes notes) {
            Intent intent = new Intent(getActivity(),NotesTakerActivity.class);
            intent.putExtra("old_note",notes);
            startActivityForResult(intent,102);

        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {
            selectedNote=new Notes();
            selectedNote=notes;
            showPopUp (cardView);

        }
    };

    private void showPopUp(CardView cardView) {

        PopupMenu popupMenu= new PopupMenu(getContext(),cardView);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_diary_menu);
        popupMenu.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId()==R.id.pinnedNote)
        {
                if(selectedNote.isPinned())
                {
                    database.mainDAO().pin(selectedNote.getID(),false);
                }
                else
                {
                    database.mainDAO().pin(selectedNote.getID(),true);
                }
            notes.clear();
            notes.addAll(database.mainDAO().getAll());
            notesListAdapter.notifyDataSetChanged();
        }
        else if (item.getItemId()==R.id.deleteNote)
        {
            database.mainDAO().delete(selectedNote);
            notes.remove(selectedNote);
            notesListAdapter.notifyDataSetChanged();
        }
        return false;
    }
}