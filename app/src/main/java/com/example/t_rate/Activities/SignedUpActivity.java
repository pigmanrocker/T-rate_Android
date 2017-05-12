package com.example.t_rate.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.t_rate.R;
import com.example.t_rate.databinding.ActivitySignedUpBinding;

public class SignedUpActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySignedUpBinding B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_up);

        getSupportActionBar().hide();

        B = DataBindingUtil.setContentView(this, R.layout.activity_signed_up);

        B.profileButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == B.profileButton){
            // TODO: 5/11/17 send them to profile
        }
    }
}
