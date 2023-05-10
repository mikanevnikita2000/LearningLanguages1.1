package com.example.learninglanguages10;



import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.learninglanguages10.DB.AppDatabase;
import com.example.learninglanguages10.DB.Words;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TeachFragment extends Fragment  {
    RadioGroup translationOrSpelling;
    Button start;
    Spinner level, language;
    String st = "";
    List<String> listLevel = new ArrayList<>();
    List<String> listLanguage = new ArrayList<>();



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
        level = (Spinner) viewReturn.findViewById(R.id.language);
        language = (Spinner) viewReturn.findViewById(R.id.level);
        translationOrSpelling = (RadioGroup) viewReturn.findViewById(R.id.translationOrSpelling);
        getLevel();
        getLanguage();
        Log.d("listLevel", "" + listLevel  );
        Log.d("listLanguage", "" + listLanguage  );

        ArrayAdapter<String> adapterLevel = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listLevel);
        adapterLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level.setAdapter(adapterLevel);

        ArrayAdapter<String> adapterLanguage = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listLanguage);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(adapterLanguage);
        level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("level", "setOnItemSelectedListener");
                MainActivity.setLevel(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("language", "setOnItemSelectedListener");
                MainActivity.setLanguage(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        translationOrSpelling.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.translation:
                        MainActivity.setTaskSelection("translation");
                        st = "translation";
                        return;

                    case R.id.spelling:
                        MainActivity.setTaskSelection("spelling");
                        st = "spelling";
                        return;
                }
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listLanguage.clear();
                listLevel.clear();;

                if(st.equals("translation"))
                {
                    OnClickTeachFragmentListener listener = (OnClickTeachFragmentListener) getActivity();
                    listener.onClickTask();
                }
                else if(st.equals("spelling"))
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
                List<Words> getLevel = AppDatabase.getInstance(getContext()).wordsDao().getLevel();
                for (int i = 0; i < getLevel.size(); i++){
                    Words level = getLevel.get(i);
                    listLevel.add(level.getLevel());
                    Log.d("DB All level", "Word: " + level.getLevel());
                }
                return;
            }
        });
        thread.start();
        while (listLevel.size() == 0)
        {
            Log.d("List level", "" + listLevel);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    public void getLanguage(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                List<Words> getLanguage = AppDatabase.getInstance(getContext()).wordsDao().getLanguage();
                for (int i = 0; i < getLanguage.size(); i++){
                    Words language = getLanguage.get(i);
                    listLanguage.add(language.getLanguage());
                    Log.d("DB All language", "Word: " + language.getLanguage());
                }
                return;
            }
        });
        thread.start();
        while (listLanguage.size() == 0)
        {
            Log.d("List level", "" + listLanguage);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return;
    }


}



//                String selectedLevel = listLevel.get(position);
//                MainActivity.setLevel(selectedLevel);