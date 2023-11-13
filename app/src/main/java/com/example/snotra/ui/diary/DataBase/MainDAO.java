package com.example.snotra.ui.diary.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.snotra.ui.diary.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {
    @Insert (onConflict = REPLACE)
    void insert (Notes notes);
    @Query("SELECT * FROM name_of_table ORDER BY id DESC")
    List<Notes> getAll();
    @Query("UPDATE name_of_table SET title= :title, notes= :notes WHERE ID= :id")
    void update (int id, String title, String notes);
    @Delete
    void delete (Notes notes);
}
