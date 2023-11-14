package com.example.snotra.ui.diary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snotra.R;
import com.example.snotra.ui.diary.NotesClickListener;
import com.example.snotra.ui.diary.Models.Notes;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{
    Context context;
    List<Notes> list;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    NotesClickListener listener;
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.diaryTextView_title.setText(list.get(position).getTitle());
        holder.diaryTextView_title.setSelected(true);
        holder.diaryTextView_notes.setText(list.get(position).getNotes());
        holder.diaryTextView_date.setText(list.get(position).getDate());
        holder.diaryTextView_date.setSelected(true);

        if(list.get(position).isPinned())
        {
            holder.diaryImageView_pin.setImageResource(R.drawable.star_icon);
        }
        else
        {
            holder.diaryImageView_pin.setImageResource(0);
        }
        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });
        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(list.get(holder.getAdapterPosition()),holder.notes_container);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList (List<Notes> filtered)
    {
        list=filtered;
        notifyDataSetChanged();
    }
}

class NotesViewHolder extends RecyclerView.ViewHolder{
CardView notes_container;
TextView diaryTextView_title;
ImageView diaryImageView_pin;
TextView diaryTextView_notes;
TextView diaryTextView_date;
    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notes_container = itemView.findViewById(R.id.notes_container);
        diaryTextView_title = itemView.findViewById(R.id.diaryTextView_title);
        diaryImageView_pin = itemView.findViewById(R.id.diaryImageView_pin);
        diaryTextView_notes = itemView.findViewById(R.id.diaryTextView_notes);
        diaryTextView_date = itemView.findViewById(R.id.diaryTextView_date);

    }
}