package com.example.mvp_architecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mvp_architecture.api.UserApi;
import com.example.mvp_architecture.help_interface.UserPresent;
import com.example.mvp_architecture.help_interface.UserRepository;
import com.example.mvp_architecture.help_interface.UserView;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements UserView {

    private UserPresent present;
    RecyclerView mRecyclerView;
    UserListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject();
        mRecyclerView = findViewById(R.id.rv);
        initRecycler();
        present.onLoadUserClicked();
    }

    @Override
    public void showLoading() {
        Log.d("TAG", "SHOW LOADING");
    }

    @Override
    public void hideLoading() {
        Log.d("TAG", "HIDE LOADING");
    }

    @Override
    public void showUsers(List<User> getUsers) {
        mAdapter.setUsers(getUsers);
        mAdapter.notifyDataSetChanged();
    }

    private void initRecycler() {
        mAdapter = new UserListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showError() {
        Log.d("TAG", "ERROR");
    }

    private void inject() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("http://g4qqy.mocklab.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserApi mApi = mRetrofit.create(UserApi.class);
        UserRepository repository = new UserRepositoruImpl(mApi);
        present = new UserPresentImpl(repository, this);
    }
}
