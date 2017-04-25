package com.example.t_rate.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.t_rate.Presenters.HomePresenter;
import com.example.t_rate.R;

public class HomeActivity extends AppCompatActivity {

    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new HomePresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }
}
