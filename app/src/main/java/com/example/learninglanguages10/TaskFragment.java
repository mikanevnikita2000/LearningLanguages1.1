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
        task = (TextView) returnView.findViewById(R.id.task);
        correctnessAnswer = (TextView) returnView.findViewById(R.id.correctnessAnswer);
        followingExample = (Button) returnView.findViewById(R.id.followingExample);
        int index = determiningCorrectAnswer();
        checkAnswer(returnView, index);
        followingExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = determiningCorrectAnswer();
                checkAnswer(returnView, index);
            }
        });


        return returnView;
    }


    public int determiningCorrectAnswer()
    {
        int index = (int) Math.random()*((3-0)+1);
        switch (index)
        {
            case 1:

            case 2:

            case 3:

        }
        return index;
    }

    public void checkAnswer(View returnView, int index)
    {
        answerGroup = (RadioGroup) returnView.findViewById(R.id.answerGroup);


        answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.answer1:
                        if(1 == index) {
                            correctnessAnswer.setText("Правильно");
                        }else {
                            correctnessAnswer.setText("Неправильно");
                        }
                    case R.id.answer2:
                        if(2 == index) {
                            correctnessAnswer.setText("Правильно");
                        }else {
                            correctnessAnswer.setText("Неправильно");
                        }
                    case R.id.answer3:
                        if(3 == index) {
                            correctnessAnswer.setText("Правильно");
                        }else {
                            correctnessAnswer.setText("Неправильно");
                        }
                }
            }
        });
    }

    public String queryAll()
    {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                List<Words> allWordsInDB = AppDatabase.getInstance(getContext()).wordsDao().getAll();
                Log.d("Count allWordsInDB", String.valueOf(allWordsInDB.size()));

//                for(int i = 0; i < allWordsInDB.size(); i++) {
//                    Words word = allWordsInDB.get(i);
//                    Log.d("DB All Words", "Word: " + word.toString(word));
//                }
            }
        });
        thread.start();
        return "";
    }
}