package com.example.mvp_architecture;

import java.util.List;

public interface UserRepository {

    void makeRequst(NetworkCallback<List<User>> callback);

}
