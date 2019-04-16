package com.example.mvp_architecture;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.VievHolder>{

    Activity mActivity;

    List<User> users = new LinkedList<>();

    UserListAdapter(Activity activity) {
        mActivity = activity;
    }

    public void setUsers (List<User> users) {
        this.users = users;
    }


    @NonNull
    @Override
    public VievHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = mActivity.getLayoutInflater().inflate(R.layout.user_card, parent, false);
        return new VievHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VievHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class VievHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView sename;
        TextView age;
        TextView weight;

        public VievHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            sename = itemView.findViewById(R.id.sename);
            age = itemView.findViewById(R.id.age);
            weight = itemView.findViewById(R.id.weight);
        }

        public void bind (User u) {
            name.setText(u.getName());
            sename.setText(u.getSurname());
            age.setText(u.getName());
            weight.setText(u.getSurname());
        }
    }
}
