package com.example.basicapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InputFragment extends Fragment {

    Button submitButton;
    TextView displayText;
    EditText nameEditText;
    public static final String NAME_KEY = "name";

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submitButton = view.findViewById(R.id.submitButton);
        nameEditText = view.findViewById(R.id.nameEditText);
        displayText = view.findViewById(R.id.displayText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
//                if (name.isEmpty()){
//                    nameEditText.setError("enter your name.");
//                }
//                displayText.setText(name);
                Bundle bundle = new Bundle();
                bundle.putString(NAME_KEY,name);

                Navigation.findNavController(view).navigate(R.id.action_inputFragment_to_infoFragment,bundle);
            }
        });
    }
}