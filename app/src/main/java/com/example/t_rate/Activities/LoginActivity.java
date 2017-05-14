package com.example.t_rate.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.t_rate.Presenters.LoginPresenter;
import com.example.t_rate.R;
import com.example.t_rate.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityLoginBinding B;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        B = DataBindingUtil.setContentView(this , R.layout.activity_login);

        B.buttonSignIn.setOnClickListener(this);
        B.buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == B.buttonSignIn){
            presenter.signIn(B.email.getText().toString(), B.password.getText().toString());
        } else if (v == B.buttonSignUp){
            presenter.goToSignUp();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    public void clearError() {
        B.errorText.setVisibility(View.INVISIBLE);
    }

    public void emptyError(){
        clearError();
        B.errorText.setText(R.string.empty_field);
    }

    public void comboError(){
        clearError();
        B.errorText.setText(R.string.combo_wrong);
    }
}
