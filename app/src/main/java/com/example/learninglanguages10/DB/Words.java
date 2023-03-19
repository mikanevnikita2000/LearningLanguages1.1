package com.example.learninglanguages10.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "words")
public class Words {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "word")
    public String word;

    @ColumnInfo(name = "translation")
    public String translation;

    @ColumnInfo(name = "language")
    public String language;

    @ColumnInfo(name = "level")
    public String level;

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

//    public static Words generateWord(String level, String word, String translation, String language)
//    {
//        Words words = new Words();
//        words.word = word;
//        words.translation = translation;
//        words.language = language;
//        words.level = level;
//        return words;
//    }
}
