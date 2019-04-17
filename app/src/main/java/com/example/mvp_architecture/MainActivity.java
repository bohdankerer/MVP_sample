package com.example.mvp_architecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;

import com.example.mvp_architecture.api.UserApi;
import com.example.mvp_architecture.help_interface.NetworkCallback;
import com.example.mvp_architecture.help_interface.UserPresent;
import com.example.mvp_architecture.help_interface.UserRepository;
import com.example.mvp_architecture.help_interface.UserView;

import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements UserView {

    private UserPresent present;
    private RecyclerView mRecyclerView;
    private UserListAdapter mAdapter;
    private CheckBox ageCheckbox;
    private CheckBox nameCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        inject();
        initRecycler();
        present.onLoadUserClicked(ageCheckbox.isChecked(), nameCheckbox.isChecked());
        nameCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                present.onLoadUserClicked(false, false);
            }
        });
        ageCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                present.onLoadUserClicked(false, false);
            }
        });
    }

    private void initViews() {
        ageCheckbox = findViewById(R.id.ageCheckbox);
        nameCheckbox = findViewById(R.id.nameCheckbox);
        mRecyclerView = findViewById(R.id.rv);
    }

    private void startProgress(){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
// запускаем длительную операцию
        progressBar.setVisibility(ProgressBar.INVISIBLE);
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
