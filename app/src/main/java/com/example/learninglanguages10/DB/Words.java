package com.example.learninglanguages10.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "words")
public class Words {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "word")
    String word;

    @ColumnInfo(name = "translation")
    String translation;

    @ColumnInfo(name = "language")
    String language;

    @ColumnInfo(name = "level")
    String level;

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

    public static Words generateWord(String level, String word, String translation, String language)
    {
        Words words = new Words();
        words.word = word;
        words.translation = translation;
        words.language = language;
        words.level = level;
        return words;
    }
    public String toString(Words word){
        return "id=" + word.getId()+ "|" + "level=" + word.getLevel() + "|" + "word=" + word.getWord() + "|" + "lg=" + word.getLanguage() + "|" + "transl=" + word.getTranslation();
    }
}
