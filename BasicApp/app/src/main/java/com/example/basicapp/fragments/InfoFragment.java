package com.example.basicapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicapp.R;
import com.example.basicapp.models.User;


public class InfoFragment extends Fragment {

    TextView nameText;
    TextView isVaccinatedText;
    TextView areaText;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameText = view.findViewById(R.id.nameText);
        isVaccinatedText = view.findViewById(R.id.isVaccinatedText);
        areaText = view.findViewById(R.id.areaText);
        User user = (User) getArguments().getSerializable(InputFragment.USER_KEY);

        if (user != null){
            nameText.setText(user.getName());
            isVaccinatedText.setText(user.getIsVaccinated());
            areaText.setText(user.getAreaName());
        }
//        String name = getArguments().getString(InputFragment.NAME_KEY);
//        String isVaccinated = getArguments().getString(InputFragment.IS_VACCINATED_KEY);
//        String areaName = getArguments().getString(InputFragment.AREA_KEY);


//        if (name !=null){
//            nameText.setText(name);
//        }
//        if (isVaccinated !=null){
//            isVaccinatedText.setText(isVaccinated);
//        }
//        if (areaName !=null){
//            areaText.setText(areaName);
//        }
    }
}