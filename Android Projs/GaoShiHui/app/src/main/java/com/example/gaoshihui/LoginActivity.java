package com.example.gaoshihui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //declare
        Button buttonLogin, buttonSignIn;
        EditText editTextEmail, editTextPassword;
        TextView textViewForgottenPassword;

        editTextEmail = (EditText) findViewById(R.id.login_account);
        editTextPassword = (EditText) findViewById(R.id.login_password);

        buttonLogin=(Button)findViewById(R.id.login_button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        buttonSignIn=(Button)findViewById(R.id.login_button_sign_in);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file=new File("..\\Accounts\\");
            }
        });

    }
}
