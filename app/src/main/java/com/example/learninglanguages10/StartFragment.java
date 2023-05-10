package com.example.learninglanguages10;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
        View viewReturn = inflater.inflate(R.layout.fragment_start, container, false);

        teach = (Button) viewReturn.findViewById(R.id.teach);
        add = (Button) viewReturn.findViewById(R.id.add);
        settings = (Button) viewReturn.findViewById(R.id.settings);
        exit = (Button) viewReturn.findViewById(R.id.exit);

        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Немного подождите",
                        LENGTH_SHORT).show();
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
        void onClickTask();
        void onClickAdd();
        void onClickSettings();
        void onClickExit();
    }
}