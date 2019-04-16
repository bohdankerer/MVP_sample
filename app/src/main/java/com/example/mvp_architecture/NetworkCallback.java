package com.example.mvp_architecture;

public interface NetworkCallback<T> {

    void onSuccecfull(T t);

    void onError();
}
