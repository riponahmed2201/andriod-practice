package com.example.basicapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.basicapp.models.User;


public class InputFragment extends Fragment {

    Button submitButton;
    TextView displayText;
    EditText nameEditText;
    RadioGroup vaccineRg;
    RadioButton selectedRadioButton;
    Spinner areaSpinner;

//    public static final String NAME_KEY = "name";
//    public static final String IS_VACCINATED_KEY = "isVaccinated";
//    public static final String AREA_KEY = "area";

    public static final String USER_KEY = "user";

    public String[] area = {"Badda", "Gulshan", "Rampura", "Banani"};
    private ArrayAdapter<String> areaAdapter;
    private String areaName;
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
        vaccineRg = view.findViewById(R.id.vaccineRG);
        areaSpinner = view.findViewById(R.id.areaSpinner);
        areaAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,area);
        areaSpinner.setAdapter(areaAdapter);
        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                areaName = area[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                areaName = area[0];
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRadioButton = view.findViewById(vaccineRg.getCheckedRadioButtonId());
                String name = nameEditText.getText().toString();
                String isVaccinated = "yes";
                if (selectedRadioButton != null){
                     isVaccinated = selectedRadioButton.getText().toString();
                }

//                if (name.isEmpty()){
//                    nameEditText.setError("enter your name.");
//                }
//                displayText.setText(name);

                User user = new User(name,isVaccinated,areaName);

                Bundle bundle = new Bundle();
                bundle.putSerializable(USER_KEY,user);

//                bundle.putString(NAME_KEY, name);
//                bundle.putString(IS_VACCINATED_KEY, isVaccinated);
//                bundle.putString(AREA_KEY, areaName);

                Navigation.findNavController(v).navigate(R.id.action_inputFragment_to_infoFragment, bundle);
            }
        });
    }
}