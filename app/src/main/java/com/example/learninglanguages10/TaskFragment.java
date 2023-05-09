package com.example.learninglanguages10;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.learninglanguages10.DB.AppDatabase;
import com.example.learninglanguages10.DB.Words;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskFragment extends Fragment {

    TextView task, correctnessAnswer;
    RadioGroup answerGroup;
    RadioButton answer1, answer2, answer3;
    Button followingExample;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.fragment_task, container, false);
        String taskTranslationOrSpelling = MainActivity.taskSelection;
        Log.d("Translation Or Spelling", "taskTranslationOrSpelling = " + taskTranslationOrSpelling );

        correctnessAnswer = (TextView) returnView.findViewById(R.id.correctnessAnswer);
        followingExample = (Button) returnView.findViewById(R.id.followingExample);
        int index = determiningCorrectAnswer(returnView);


        answerGroup = (RadioGroup) returnView.findViewById(R.id.answerGroup);
        answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkAnswer(checkedId, index);
            }
        });

        followingExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = determiningCorrectAnswer(returnView);
                //checkAnswer(returnView, index);
            }
        });


        return returnView;
    }


    public int determiningCorrectAnswer(View returnView)
    {
        List<String> listWordAndTranslation = new ArrayList<>();
        int index = (int) Math.random()*((3-0)+1);
        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        switch (index)
        {
            case 1:
                answer1.setText(listWordAndTranslation.get(1));
                if(MainActivity.taskSelection == "translation")
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    listWordAndTranslation = queryCorrectAnswer();
                    task.setText("Переведите слово: " + listWordAndTranslation.get(0));
                    List<String> listWordBeforeAnswer = queryIncorrectAnswers(listWordAndTranslation.get(0));
                    answer2.setText(listWordBeforeAnswer.get(0));
                    answer3.setText(listWordBeforeAnswer.get(1));

                }
                if(MainActivity.taskSelection == "spelling")
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    listWordAndTranslation = queryCorrectAnswer();
                    task.setText("Напишите правильно слово " + listWordAndTranslation.get(1));
                    String word = listWordAndTranslation.get(0);

                    int letterNumber2 = (int) Math.random()*word.length();
                    int letterNumber3 = (int) Math.random()*word.length();
                    int letterNumberBeforeAnswer2 = (int) Math.random()*27;
                    int letterNumberBeforeAnswer3 = (int) Math.random()*27;



                }
            case 2:
                answer2.setText(listWordAndTranslation.get(1));
            case 3:
                answer3.setText(listWordAndTranslation.get(1));

        }
        return index;
    }

    public void checkAnswer(int checkedId, int index)
    {
        switch (checkedId) {
            case R.id.answer1:
                if (1 == index) {
                    correctnessAnswer.setText("Правильно");
                } else {
                    correctnessAnswer.setText("Неправильно");
                }
            case R.id.answer2:
                if (2 == index) {
                    correctnessAnswer.setText("Правильно");
                } else {
                    correctnessAnswer.setText("Неправильно");
                }
            case R.id.answer3:
                if (3 == index) {
                    correctnessAnswer.setText("Правильно");
                } else {
                    correctnessAnswer.setText("Неправильно");
                }
        }
    }


    public List<String> queryCorrectAnswer()
    {
        List<Words> correctAnswer = AppDatabase.getInstance(getContext()).wordsDao().getCorrectAnswer(MainActivity.level, MainActivity.language);
        int i = (int) Math.random()*correctAnswer.size();
        Words wordAndTranslation = correctAnswer.get(i);
        List<String> listWordAndTranslation = new ArrayList<>();
        listWordAndTranslation.add(wordAndTranslation.getWord());
        listWordAndTranslation.add(wordAndTranslation.getTranslation());
        Log.i("Spelling", "Word and translation " + listWordAndTranslation.get(0) + " And " + listWordAndTranslation.get(1));

        return listWordAndTranslation;
    }

    public List<String> queryIncorrectAnswers(String wordCorrect)
    {
        List<Words> correctAnswer = AppDatabase.getInstance(getContext()).wordsDao().getIncorrectAnswers(MainActivity.language, wordCorrect);
        List<String> listWordBeforeAnswer = new ArrayList<>();
        int id = 0;
        int idRecurring = 0;
        for (int i = 0; i<2; i++)
        {

            id = (int) Math.random()*correctAnswer.size();
            if(id != idRecurring)
            {
                listWordBeforeAnswer.add(String.valueOf(correctAnswer.get(id)));
                idRecurring = id;
            }

        }

        return listWordBeforeAnswer;
    }
}