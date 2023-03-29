package com.example.learninglanguages10;



import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.learninglanguages10.DB.AppDatabase;
import com.example.learninglanguages10.DB.Words;

import java.util.List;

public class TeachFragment extends Fragment {
    RadioGroup translationOrSpelling;
    Button start;
    Spinner level, language;
    String st = "";



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
        start = (Button) viewReturn.findViewById(R.id.start);
        level = (Spinner) viewReturn.findViewById(R.id.level);
        language = (Spinner) viewReturn.findViewById(R.id.language);
        translationOrSpelling = (RadioGroup) viewReturn.findViewById(R.id.translationOrSpelling);
        getLevel();
//
//        ArrayAdapter<String> adapterLevel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, levelAll);
//        adapterLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        translationOrSpelling.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        st = "Нечего не выбрано";
//                        Toast.makeText(getContext(), "Нечего не выбрано",
//                                Toast.LENGTH_SHORT).show();
                    case R.id.translation:
                        st = "translation";
                    case R.id.spelling:
                        st = "spelling";
                }
            }
        });
        printAllWords();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(st == "spelling")
                {
                    OnClickTeachFragmentListener listener = (OnClickTeachFragmentListener) getActivity();
                    listener.onClickTask();
                }
                else if(st == "spelling")
                {
                    OnClickTeachFragmentListener listener = (OnClickTeachFragmentListener) getActivity();
                    listener.onClickTask();
                }
                else
                {
                    Toast.makeText(getContext(), "Нечего не выбрано",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        return viewReturn;
    }

    public interface OnClickTeachFragmentListener
    {
        void onClickTeach();
        void onClickTask();
        void onClickAdd();
        void onClickSettings();
        void onClickExit();
    }

    public void getLevel(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Log.d("DB", "get level");
                List<Words> getLanguage = AppDatabase.getInstance(getContext()).wordsDao().getLevel();
                Log.d("DB", "Table dump");
                String[] language = new String[getLanguage.size()];
                for (int i = 0; i < getLanguage.size(); i++){
                    language[i] = (String.valueOf(getLanguage.get(i)));
                    Log.d("DB All level", "Word: " + language[i]);
                }

            }
        });
        thread.start();
        return ;
    }

    public void printAllWords(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                List<Words> allWordsInDB = AppDatabase.getInstance(getContext()).wordsDao().getAll();
                Log.d("Count allWordsInDB", String.valueOf(allWordsInDB.size()));
                for(int i = 0; i < allWordsInDB.size(); i++) {
                    Words word = allWordsInDB.get(i);
                    Log.d("DB All Words", "Word: " + word.toString(word));
                }

                //language = getLanguage;

            }
        });
        thread.start();
    }

    public List<Words> getLanguage(Words words){
        List<Words> language = null;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Log.d("DB", "add a new word to DB:" + words.toString(words));
                //language = AppDatabase.getInstance(getContext()).wordsDao().getLanguage();
                Log.d("DB", "Table dump");
            }
        });
        thread.start();
        return language;
    }


}