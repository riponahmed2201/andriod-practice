package com.example.basicapp.repositoy;

import com.example.basicapp.models.User;

import java.util.ArrayList;

public class UserRepository {
    private static final ArrayList<User> userList = new ArrayList<>();

    public static void savUser(User user){
        userList.add(user);
    }

    public static ArrayList<User> getUserList(){
        return userList;
    }
}
