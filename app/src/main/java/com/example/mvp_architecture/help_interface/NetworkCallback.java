package com.example.mvp_architecture.help_interface;

public interface NetworkCallback<T> {

    void onSuccess(T t);

    void onError();
}
