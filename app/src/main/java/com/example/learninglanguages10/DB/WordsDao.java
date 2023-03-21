package com.example.learninglanguages10.DB;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface WordsDao {
    @Query("SELECT * FROM words")
    List<Words> getAll();

    @Query("SELECT language FROM words")
    List<String> getLanguage();

    @Query("SELECT level FROM words")
    List<String> getLevel();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Words words);

    @Update
    void update(Words words);
}
