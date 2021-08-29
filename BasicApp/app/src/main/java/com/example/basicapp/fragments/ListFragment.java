package com.example.basicapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicapp.R;
import com.example.basicapp.adapter.UserAdapter;
import com.example.basicapp.models.User;
import com.example.basicapp.repositoy.UserRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton addButton = view.findViewById(R.id.addButton);

        ArrayList<User> users = UserRepository.getUserList();

        RecyclerView userRv = view.findViewById(R.id.userRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        userRv.setLayoutManager(linearLayoutManager);

        UserAdapter userAdapter = new UserAdapter(getActivity(),users);
        userRv.setAdapter(userAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_listFragment_to_inputFragment);
            }
        });
    }
}