package com.example.learninglanguages10;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SettingFragment extends Fragment {

    private boolean isFirstTime = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView =  inflater.inflate(R.layout.fragment_setting, container, false);

        String[] supportedLanguages = {"ru", "en"};
        String currentLanguage = Locale.getDefault().getLanguage();
        if (!Arrays.asList(supportedLanguages).contains(currentLanguage)) {
            currentLanguage = "en";
        }
        List<String> languageNames = new ArrayList<>();
        languageNames.add("Русский");
        languageNames.add("English");

        ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, languageNames);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerLanguageSelection = (Spinner) returnView.findViewById(R.id.spinnerLanguageSelection);
        spinnerLanguageSelection.setAdapter(languageAdapter);

        if (currentLanguage.equals("ru")) {
            spinnerLanguageSelection.setSelection(0);
        } else {
            spinnerLanguageSelection.setSelection(1);
        }

        spinnerLanguageSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!isFirstTime) {
                    String languageCode = supportedLanguages[position];
                    updateLocale(languageCode);
                } else {
                    isFirstTime = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return returnView;
    }

    private void updateLocale(String languageCode) {

        Locale newLocale = new Locale(languageCode);
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        Log.d("Language", Locale.getDefault().getLanguage());
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        getActivity().recreate();
    }
}