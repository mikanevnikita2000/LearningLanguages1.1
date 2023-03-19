package com.example.learninglanguages10.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import android.util.Log;

@Database(entities = {Words.class}, version = 1)
public abstract class AppDB extends RoomDatabase{

    public abstract WordsDao wordsDao();
}
