package com.example.mvp_architecture.api;

import com.example.mvp_architecture.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("/v2/5cae492a3400005c00ab6cb2")
    Call<List<User>> getUsers();

}
