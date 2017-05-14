package com.example.t_rate.Presenters;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.t_rate.Activities.HomeActivity;
import com.example.t_rate.Activities.LoginActivity;
import com.example.t_rate.Activities.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by pigmanrocker on 5/14/17.
 */

public class LoginPresenter {

    private FirebaseAuth auth;

    private LoginActivity activity;

    public LoginPresenter(LoginActivity activity){
        this.activity = activity;

        auth = FirebaseAuth.getInstance();
    }

    public void goToSignUp(){
        Intent intent = new Intent(activity.getBaseContext(), SignUpActivity.class);
        activity.startActivity(intent);
    }

    public void goToHome(){
        Intent intent = new Intent(activity.getBaseContext(), HomeActivity.class);
        activity.startActivity(intent);
    }

    public void signIn(String email, String password){
        if (email.equals("") || password.equals("")){
            activity.emptyError();
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    goToHome();
                } else {
                    activity.comboError();
                }
            }
        });
    }
}
