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
import java.util.concurrent.TimeUnit;

public class TaskFragment extends Fragment {

    TextView task, correctnessAnswer;
    RadioGroup answerGroup;
    RadioButton answer1, answer2, answer3;
    Button followingExample;
    public int index = 0;

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
        index = determiningCorrectAnswer(returnView);

        correctnessAnswer.setText("" + getResources().getString(R.string.falseAnswer));

        answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkAnswer(checkedId, index);
            }
        });

        followingExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctnessAnswer.setText("" + getResources().getString(R.string.falseAnswer));
                index = determiningCorrectAnswer(returnView);
            }
        });


        return returnView;
    }


    public int determiningCorrectAnswer(View returnView)
    {
        answerGroup = (RadioGroup) returnView.findViewById(R.id.answerGroup);
        answer1 = (RadioButton) returnView.findViewById(R.id.answer1);
        answer2 = (RadioButton) returnView.findViewById(R.id.answer2);
        answer3 = (RadioButton) returnView.findViewById(R.id.answer3);
        List<String> listWordAndTranslation = queryCorrectAnswer();
        int randomIndex = new Random().nextInt(4 - 1) + 1;
        Character[] alphabet = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        switch (randomIndex)
        {
            case 1:
                answer1.setText("" + listWordAndTranslation.get(0));
                if(MainActivity.taskSelection.equals("translation"))
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    task.setText("" + getResources().getString(R.string.questionTranslation) + " " + listWordAndTranslation.get(1));
                    List<String> listWordBeforeAnswer = queryIncorrectAnswers(listWordAndTranslation.get(0));
                    answer2.setText("" + listWordBeforeAnswer.get(0));
                    answer3.setText("" + listWordBeforeAnswer.get(1));

                }
                if(MainActivity.taskSelection.equals("spelling"))
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    //listWordAndTranslation = queryCorrectAnswer();
                    task.setText("" + getResources().getString(R.string.questionSpelling) + " " + listWordAndTranslation.get(1));
                    String word = listWordAndTranslation.get(0);

                    int letterNumber2 = new Random().nextInt(word.length() - 0) + 0;
                    int letterNumber3 = new Random().nextInt(word.length() - 0) + 0;
                    int letterNumberBeforeAnswer2 = new Random().nextInt(27 - 0) + 0;
                    int letterNumberBeforeAnswer3 = new Random().nextInt(27 - 0) + 0;

                    String wordAnswer2 = word.replace(word.charAt(letterNumber2), alphabet[letterNumberBeforeAnswer2]);
                    String wordAnswer3 = word.replace(word.charAt(letterNumber3), alphabet[letterNumberBeforeAnswer3]);

                    answer2.setText("" + wordAnswer2);
                    answer3.setText("" + wordAnswer3);


                }
                break;
            case 2:
                answer2.setText("" + listWordAndTranslation.get(0));
                if(MainActivity.taskSelection.equals("translation"))
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    task.setText("" + getResources().getString(R.string.questionTranslation) + " "  + listWordAndTranslation.get(1));
                    List<String> listWordBeforeAnswer = queryIncorrectAnswers(listWordAndTranslation.get(0));
                    answer1.setText("" + listWordBeforeAnswer.get(0));
                    answer3.setText("" + listWordBeforeAnswer.get(1));

                }
                if(MainActivity.taskSelection.equals("spelling"))
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    task.setText("" + getResources().getString(R.string.questionSpelling) + " " + listWordAndTranslation.get(1));
                    String word = listWordAndTranslation.get(0);

                    int letterNumber1 = new Random().nextInt(word.length() - 0) + 0;
                    int letterNumber3 = new Random().nextInt(word.length() - 0) + 0;
                    int letterNumberBeforeAnswer1 = new Random().nextInt(27 - 0) + 0;
                    int letterNumberBeforeAnswer3 = new Random().nextInt(27 - 0) + 0;

                    String wordAnswer1 = word.replace(word.charAt(letterNumber1), alphabet[letterNumberBeforeAnswer1]);
                    String wordAnswer3 = word.replace(word.charAt(letterNumber3), alphabet[letterNumberBeforeAnswer3]);

                    answer1.setText("" + wordAnswer1);
                    answer3.setText("" + wordAnswer3);


                }
                break;
            case 3:
                answer3.setText("" + listWordAndTranslation.get(0));
                if(MainActivity.taskSelection.equals("translation"))
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    task.setText("" + getResources().getString(R.string.questionTranslation) + " " + listWordAndTranslation.get(1));
                    List<String> listWordBeforeAnswer = queryIncorrectAnswers(listWordAndTranslation.get(0));
                    answer1.setText("" + listWordBeforeAnswer.get(0));
                    answer2.setText("" + listWordBeforeAnswer.get(1));

                }
                if(MainActivity.taskSelection.equals("spelling"))
                {
                    task = (TextView) returnView.findViewById(R.id.task);
                    task.setText("" + getResources().getString(R.string.questionSpelling)  + " " + listWordAndTranslation.get(1));
                    String word = listWordAndTranslation.get(0);

                    int letterNumber1 = new Random().nextInt(word.length() - 0) + 0;
                    int letterNumber2 = new Random().nextInt(word.length() - 0) + 0;
                    int letterNumberBeforeAnswer1 = new Random().nextInt(27 - 0) + 0;
                    int letterNumberBeforeAnswer2 = new Random().nextInt(27 - 0) + 0;

                    String wordAnswer1 = word.replace(word.charAt(letterNumber1), alphabet[letterNumberBeforeAnswer1]);
                    String wordAnswer2 = word.replace(word.charAt(letterNumber2), alphabet[letterNumberBeforeAnswer2]);

                    answer1.setText("" + wordAnswer1);
                    answer2.setText("" + wordAnswer2);


                }
                break;
        }
        return randomIndex;
    }

    public void checkAnswer(int checkedId, int index)
    {
        switch (checkedId) {
            case R.id.answer1:
                if (1 == index) {
                    correctnessAnswer.setText("" + getResources().getString(R.string.trueAnswer));
                } else {
                    correctnessAnswer.setText("" + getResources().getString(R.string.falseAnswer));
                }
                break;
            case R.id.answer2:
                if (2 == index) {
                    correctnessAnswer.setText("" + getResources().getString(R.string.trueAnswer));
                } else {
                    correctnessAnswer.setText("" + getResources().getString(R.string.falseAnswer));
                }
                break;
            case R.id.answer3:
                if (3 == index) {
                    correctnessAnswer.setText("" + getResources().getString(R.string.trueAnswer));
                } else {
                    correctnessAnswer.setText("" + getResources().getString(R.string.falseAnswer));
                }
                break;
        }
    }


    public List<String> queryCorrectAnswer()
    {
        List<String> listWordAndTranslation = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                List<Words> correctAnswer = AppDatabase.getInstance(getContext()).wordsDao().getCorrectAnswer(MainActivity.level, MainActivity.language);
                int i = new Random().nextInt(correctAnswer.size() - 0) + 0;
                Words wordAndTranslation = correctAnswer.get(i);
                listWordAndTranslation.add(wordAndTranslation.getWord());
                listWordAndTranslation.add(wordAndTranslation.getTranslation());
                Log.i("Spelling", "Word and translation " + listWordAndTranslation.get(0) + " And " + listWordAndTranslation.get(1));
                return;
            }
        });
        thread.start();
        while (listWordAndTranslation.size() == 0)
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return listWordAndTranslation;
    }

    public List<String> queryIncorrectAnswers(String wordCorrect)
    {
        List<String> listWordBeforeAnswer = new ArrayList<>();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                List<Words> correctAnswer = AppDatabase.getInstance(getContext()).wordsDao().getIncorrectAnswers(MainActivity.language, wordCorrect);
                int id = 0;
                int idRecurring = 0;
                Words wordAndTranslation;

                while (listWordBeforeAnswer.size() < 2)
                {
                    id = new Random().nextInt(correctAnswer.size() - 1) + 1;
                    if(id != idRecurring)
                    {
                        wordAndTranslation = correctAnswer.get(id);
                        listWordBeforeAnswer.add(wordAndTranslation.getWord());
                        idRecurring = id;
                    }
                }
                return;
            }
        });
        thread.start();
        while (listWordBeforeAnswer.size() < 2)
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return listWordBeforeAnswer;
    }
}