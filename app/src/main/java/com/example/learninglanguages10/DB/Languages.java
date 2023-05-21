package com.example.learninglanguages10.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "languages")
public class Languages {
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "language")
    String language;

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public static Languages generateLanguage(String language)
    {
        Languages languages = new Languages();
        languages.language = language;
        return languages;
    }
}
