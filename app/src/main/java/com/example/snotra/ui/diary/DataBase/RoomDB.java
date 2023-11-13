package com.example.snotra.ui.diary.DataBase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.snotra.ui.diary.FragmentDiary;
import com.example.snotra.ui.diary.Models.Notes;

@Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase{
    private static RoomDB database;
    private static String DATABASE_NAME="Data_Note";
    public synchronized static RoomDB getInstance(FragmentDiary context){
        if (database==null)
        {
            database = Room.databaseBuilder(context.getContext(),RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    public abstract MainDAO mainDAO();
}
