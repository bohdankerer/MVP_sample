package com.example.mvp_architecture.help_interface;

import com.example.mvp_architecture.User;

import java.util.List;

public interface UserView {

    void showLoading();

    void hideLoading();

    void showUsers(List<User> getUsers);

    void showError();
}
