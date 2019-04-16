package com.example.mvp_architecture.help_interface;

import com.example.mvp_architecture.User;
import com.example.mvp_architecture.help_interface.NetworkCallback;

import java.util.List;

public interface UserRepository {

    void makeRequst(NetworkCallback<List<User>> callback);

}
