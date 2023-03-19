package com.example.learninglanguages10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StartFragment extends Fragment {

    Button teach, add, settings, exit;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewReturn = inflater.inflate(R.layout.fragment_start, container, false);

        teach = (Button) viewReturn.findViewById(R.id.teach);
        add = (Button) viewReturn.findViewById(R.id.add);
        settings = (Button) viewReturn.findViewById(R.id.settings);
        exit = (Button) viewReturn.findViewById(R.id.exit);

        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickStartFragmentListener listener = (OnClickStartFragmentListener) getActivity();
                listener.onClickTeach();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickStartFragmentListener listener = (OnClickStartFragmentListener) getActivity();
                listener.onClickAdd();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickStartFragmentListener listener = (OnClickStartFragmentListener) getActivity();
                listener.onClickSettings();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickStartFragmentListener listener = (OnClickStartFragmentListener) getActivity();
                listener.onClickExit();
            }
        });

        return viewReturn;
    }

    public interface OnClickStartFragmentListener {
        void onClickTeach();
        void onClickAdd();
        void onClickSettings();
        void onClickExit();
    }
}