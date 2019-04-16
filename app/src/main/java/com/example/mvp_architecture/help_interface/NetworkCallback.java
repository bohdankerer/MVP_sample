package com.example.mvp_architecture.help_interface;

public interface NetworkCallback<T> {

    void onSuccecfull(T t);

    void onError();
}
