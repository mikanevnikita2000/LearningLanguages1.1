package com.example.learninglanguages10;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements StartFragment.OnClickStartFragmentListener{

    StartFragment startFragment;
    final static String TAG_START= "TAG_START";
    final static String TAG_ADD= "TAG_ADD";
    final static String TAG_TEACH= "TAG_TEACH";


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

    @Override
    public void onClickExit() {
        finish();
    }
}