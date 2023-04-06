package com.example.learninglanguages10;

import static com.example.learninglanguages10.DB.Words.generateWord;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.learninglanguages10.DB.AppDatabase;
import com.example.learninglanguages10.DB.Words;


public class AddFragment extends Fragment {

    EditText levelAdd, wordAdd, translationAdd, languageAdd;
    Button buttonAdd;




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

        levelAdd = (EditText) viewReturn.findViewById(R.id.levelAdd);
        wordAdd = (EditText) viewReturn.findViewById(R.id.word);
        translationAdd = (EditText) viewReturn.findViewById(R.id.translationAdd);
        languageAdd = (EditText) viewReturn.findViewById(R.id.level);
        buttonAdd = (Button) viewReturn.findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Words words = generateWord(levelAdd.getText().toString(), wordAdd.getText().toString(), translationAdd.getText().toString(), languageAdd.getText().toString());
                Log.d("Words", "create a new word:" + words.getLevel() + "|" + words.getWord() + "|" + words.getLanguage() + "|" + words.getTranslation());
                addItem(words);
                //updateItem(words);
            }
        });
        return viewReturn;
    }



    public void addItem(Words words){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Log.d("DB", "add a new word to DB:" + words.getLevel() + "|" + words.getWord() + "|" + words.getLanguage() + "|" + words.getTranslation());
                AppDatabase.getInstance(getContext()).wordsDao().insert(words);
                Log.d("DB", "Table dump");
            }
        });
        thread.start();
    }

    private void updateItem(Words words){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                AppDatabase.getInstance(getContext()).wordsDao().update(words);
            }
        });
        thread.start();
    }
}