package com.example.t_rate.Presenters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.t_rate.Activities.SignUpActivity;
import com.example.t_rate.Activities.SignedUpActivity;
import com.example.t_rate.CustomUtils.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by pigmanrocker on 5/9/17.
 */

public class SignUpPresenter {

    private SignUpActivity activity;
    private FirebaseAuth auth;

    public SignUpPresenter(SignUpActivity activity){
        this.activity = activity;
    }

    public void signUp(String email, String password, String passwordConfirm){
        activity.clearErrors();

        if (email.equals("") || password.equals("") || passwordConfirm.equals("")){
            activity.emptyError();
            return;
        }

        int placeOfAtSymbol = email.indexOf("@");
        if (placeOfAtSymbol < 1 || email.contains(" ")){
            activity.invalidEmail();
            return;
        }

        if (!email.substring(email.indexOf("@")).equals("@student.stenden.com")){
            activity.wrongEmail();
            return;
        }

        int numsInPassword = Utilities.getNumberDigits(password);
        if (password.toLowerCase().equals(password)
                || password.toUpperCase().equals(password)
                || password.length() < 8
                || password.length() > 20
                || numsInPassword < 1
                || password.matches("^[a-zA-Z0-9]*$")
                || password.contains(" ")){
            activity.invalidPassword();
            return;
        }

        if (!password.equals(passwordConfirm)){
            activity.passwordMatchError();
            return;
        }

        signFirebaseUp(email, password);
    }
    
    public void signFirebaseUp(String email, String password){
        // TODO: 5/10/17 implement Firebase SignUp

        auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    auth.getCurrentUser().sendEmailVerification();
                    auth.signOut();
                    Intent intent = new Intent(activity.getApplicationContext(), SignedUpActivity.class);
                    activity.startActivity(intent);
                } else {
                    Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void goToSignIn(){
        // TODO: 5/10/17 switch to login screen    
    }
}
