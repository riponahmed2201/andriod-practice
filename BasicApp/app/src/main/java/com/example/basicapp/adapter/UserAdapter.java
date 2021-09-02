package com.example.basicapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicapp.R;
import com.example.basicapp.fragments.InputFragment;
import com.example.basicapp.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private Context context;
    private ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.user_row,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);

//        holder.areaNameText.setText(user.getAreaName());
        holder.userNameText.setText(user.getName());
//        holder.isVaccinatedText.setText(user.getIsVaccinated());
        holder.icon.setImageResource(user.getIsVaccinated().equals("yes") ? R.drawable.check : R.drawable.multiply);

        holder.userItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(InputFragment.USER_KEY,user);
                Navigation.findNavController(view).navigate(R.id.action_listFragment_to_infoFragment,bundle);
            }
        });
//        holder.areaNameText.setText(users.get(position).getAreaName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{

        TextView userNameText;
//        TextView isVaccinatedText;
        TextView areaNameText;
        LinearLayout userItem;
        ImageView icon;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameText = itemView.findViewById(R.id.nameText);
//            isVaccinatedText = itemView.findViewById(R.id.isVaccinatedText);
            userNameText = itemView.findViewById(R.id.areaText);
            userItem = itemView.findViewById(R.id.userLayout);
            icon = itemView.findViewById(R.id.isVaccinatedIcon);
        }
    }
}
