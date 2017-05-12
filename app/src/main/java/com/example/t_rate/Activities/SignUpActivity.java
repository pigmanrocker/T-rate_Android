package com.example.t_rate.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.t_rate.Presenters.SignUpPresenter;
import com.example.t_rate.R;
import com.example.t_rate.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySignUpBinding B;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        B = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        presenter = new SignUpPresenter(this);

        B.buttonSignUp.setOnClickListener(this);
        B.buttonSignIn.setOnClickListener(this);
    }

    public void clearErrors(){
        B.emailErrorText.setVisibility(View.INVISIBLE);
        B.passwordInvalidText.setVisibility(View.INVISIBLE);
        B.passwordMatchErrorText.setVisibility(View.INVISIBLE);
    }

    public void emptyError(){
        B.emailErrorText.setVisibility(View.VISIBLE);
        B.emailErrorText.setText(R.string.empty_field);
    }

    public void invalidEmail(){
        B.emailErrorText.setVisibility(View.VISIBLE);
        B.emailErrorText.setText(R.string.invalid_email);
    }

    public void wrongEmail(){
        B.emailErrorText.setVisibility(View.VISIBLE);
        B.emailErrorText.setText(R.string.email_not_stenden);
    }

    public void invalidPassword(){
        B.passwordInvalidText.setVisibility(View.VISIBLE);
    }

    public void passwordMatchError(){
        B.passwordMatchErrorText.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v == B.buttonSignUp){
            presenter.signUp(B.email.getText().toString(), B.password1.getText().toString(), B.password2.getText().toString());
        } else if (v == B.buttonSignIn){
            presenter.goToSignIn();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
