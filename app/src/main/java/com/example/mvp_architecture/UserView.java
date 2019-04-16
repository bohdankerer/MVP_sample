package com.example.mvp_architecture;

import java.util.List;

public interface UserView {

    void showLoading();

    void hideLoading();

    void showUsers(List<User> getUsers);

    void showError();
}
