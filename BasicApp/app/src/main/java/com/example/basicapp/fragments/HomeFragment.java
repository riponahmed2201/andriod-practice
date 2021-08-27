package com.example.basicapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicapp.R;


public class HomeFragment extends Fragment {

    Button switchButton;
    TextView platformText, languageText;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switchButton = view.findViewById(R.id.switchButton);
        platformText = view.findViewById(R.id.platformText);
        languageText = view.findViewById(R.id.languageText);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                platformText.setVisibility(View.GONE);
                languageText.setVisibility(View.VISIBLE);
            }
        });
    }
}