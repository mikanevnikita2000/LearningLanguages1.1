package com.example.learninglanguages10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.learninglanguages10.DB.AppDatabase;
import com.example.learninglanguages10.DB.Words;

import java.util.ArrayList;
import java.util.List;

public class TeachFragment extends Fragment {
    Switch translation;
    Switch spelling;
    Button start;
    Spinner level, language;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewReturn = inflater.inflate(R.layout.fragment_teach, container, false);
        translation = (Switch) viewReturn.findViewById(R.id.translation);
        spelling = (Switch) viewReturn.findViewById(R.id.spelling);
        start = (Button) viewReturn.findViewById(R.id.start);
        level = (Spinner) viewReturn.findViewById(R.id.level);
        language = (Spinner) viewReturn.findViewById(R.id.language);
        boolean SelectedTranslation = translation.isChecked();
        boolean SelectedSpelling = translation.isChecked();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(SelectedTranslation && SelectedSpelling)
                {
                    Log.d("Switch selected or not", "2 selected at once");
                }
                else if(SelectedSpelling)
                {

                }
                else if(SelectedTranslation)
                {

                }
                else
                {
                    Log.d("Switch selected or not", "did not select an action");
                }
            }
        });


        return viewReturn;
    }

    public List<Words> getLevel(){
        List<Words> language = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Log.d("DB", "get level");
                List<Words> getLanguage = AppDatabase.getInstance(getContext()).wordsDao().getLevel();
                Log.d("DB", "Table dump");
                //language = getLanguage;

            }
        });
        thread.start();
        return language;
    }

    public List<Words> getLanguage(Words words){
        List<Words> language = null;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Log.d("DB", "add a new word to DB:" + words.getLevel() + "|" + words.getWord() + "|" + words.getLanguage() + "|" + words.getTranslation());
                //language = AppDatabase.getInstance(getContext()).wordsDao().getLanguage();
                Log.d("DB", "Table dump");
            }
        });
        thread.start();
        return language;
    }
}