package com.example.mvp_architecture;

import com.example.mvp_architecture.help_interface.NetworkCallback;
import com.example.mvp_architecture.help_interface.UserPresent;
import com.example.mvp_architecture.help_interface.UserRepository;
import com.example.mvp_architecture.help_interface.UserView;

import java.util.List;

public class UserPresentImpl implements UserPresent {

    private UserRepository repository;
    private UserView view;

    public UserPresentImpl(UserRepository repository, UserView view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void onLoadUserClicked() {
        view.showLoading();

        repository.makeRequst(new NetworkCallback<List<User>>() {
            @Override
            public void onSuccecfull(List<User> users) {
                view.showUsers(users);
                view.hideLoading();
            }

            @Override
            public void onError() {
                view.showError();
                view.hideLoading();
            }
        });

    }
}
