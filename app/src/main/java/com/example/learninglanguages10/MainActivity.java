package com.example.learninglanguages10;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements StartFragment.OnClickStartFragmentListener, TeachFragment.OnClickTeachFragmentListener{

    StartFragment startFragment;
    final static String TAG_START= "TAG_START";
    final static String TAG_ADD= "TAG_ADD";
    final static String TAG_TEACH= "TAG_TEACH";
    final static String TAG_TASK= "TAG_TASK";
    public static String taskSelection = "";
    public static String translation = "";
    public static String level = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startFragment = new StartFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_list, startFragment, TAG_START)
                .commit();
    }

    @Override
    public void onClickTeach() {
        Log.i(TAG, "");
        TeachFragment teachFragment = new TeachFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_list, teachFragment, TAG_TEACH)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClickTask() {
        Log.i(" TaskFragment", " Переходим в TaskFragment");
        TaskFragment taskFragment = new TaskFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_list, taskFragment, TAG_TASK)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClickAdd() {
        AddFragment addFragment = new AddFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_list, addFragment, TAG_ADD)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClickSettings() {

    }

    public static void setTaskSelection(String task)
    {
        taskSelection = task;
    }

    public static void setLevel(String setlevel)
    {
        level = setlevel;
        Log.d("Выбран элемент:", ""+level);
    }

    public static void setTranslation(String settranslation)
    {
        translation = settranslation;
        Log.d("Выбран элемент:", ""+translation);
    }

    @Override
    public void onClickExit() {
        finish();
    }
}