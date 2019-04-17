package com.example.mvp_architecture;

import com.example.mvp_architecture.api.UserApi;
import com.example.mvp_architecture.help_interface.NetworkCallback;
import com.example.mvp_architecture.help_interface.UserRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoruImpl implements UserRepository {

    private UserApi api;

    public UserRepositoruImpl(UserApi api) {
        this.api = api;
    }

    @Override
    public void loadUsers(final NetworkCallback<List<User>> callback) {
        api.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
