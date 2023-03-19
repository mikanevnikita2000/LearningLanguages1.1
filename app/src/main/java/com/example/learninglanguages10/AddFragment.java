package com.example.learninglanguages10;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.learninglanguages10.DB.AppDB;
import com.example.learninglanguages10.DB.Words;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {

    EditText levelAdd, wordAdd, translationAdd, languageAdd;
    Button buttonAdd;
    List<Words> list = new ArrayList<>();
    private AppDB database;




    public AddFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewReturn = inflater.inflate(R.layout.fragment_add, container, false);
        initDB();
        levelAdd = (EditText) viewReturn.findViewById(R.id.levelAdd);
        wordAdd = (EditText) viewReturn.findViewById(R.id.word);
        translationAdd = (EditText) viewReturn.findViewById(R.id.translationAdd);
        languageAdd = (EditText) viewReturn.findViewById(R.id.language);
        buttonAdd = (Button) viewReturn.findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Words words = new Words();
                words.level = levelAdd.getText().toString();
                words.word = wordAdd.getText().toString();
                words.translation = translationAdd.getText().toString();
                words.language = languageAdd.getText().toString();
                addItem(words);
                updateItem(words);
            }
        });
        return viewReturn;
    }

    private void initDB() {
        database = Room.databaseBuilder(getContext(),
                        AppDB.class, "words")
                .fallbackToDestructiveMigration()
                .build();
    }

    public void addItem(Words words){
        list.add(words);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                database.wordsDao().insert(words);
            }
        });
        thread.start();
    }

    private void updateItem(Words words){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                database.wordsDao().update(words);
            }
        });
        thread.start();
    }
}