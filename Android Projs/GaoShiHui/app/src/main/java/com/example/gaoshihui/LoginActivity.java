package com.example.gaoshihui;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginActivity extends Activity {
    //declare
    Button mButtonLogin, mButtonSignIn;
    EditText mEditTextEmail, mEditTextPassword;
    TextView mTextViewForgottenPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEditTextEmail = (EditText) findViewById(R.id.login_account);
        mEditTextPassword = (EditText) findViewById(R.id.login_password);

        mButtonLogin = (Button) findViewById(R.id.login_button_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifNull()){
                    return;
                }else {
                    try {
                        if (new AccountManager().logIn(mEditTextEmail.toString(), mEditTextPassword.toString()))
                            LoginActivity.this.finish();
                        else ;

                    } catch (IOException e) {
                    } catch (AccountManager.NotExistException e) {
                    }
                }
            }
        });
        mButtonSignIn = (Button) findViewById(R.id.login_button_sign_in);
        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this,SignInActivity.class);
                startActivity(i);
            }
        });
    }

    private boolean ifNull() {
        String a=mEditTextEmail.getText().toString();
        String b=mEditTextPassword.getText().toString();

        if (a.equals("")||b.equals(""))
            return true;
        else return false;
    }

}
