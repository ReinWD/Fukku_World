package com.example.gaoshihui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import static com.example.gaoshihui.MainActivity.mManager;

public class LoginActivity extends AppCompatActivity {
    //declare
    Button mButtonLogin, mButtonSignIn;
    EditText mEditTextEmail, mEditTextPassword;
    TextView mTextViewForgottenPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSharedPreferences("s" ,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Context context=this.getApplicationContext();


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
                        if (mManager.logIn(mEditTextEmail.getText().toString(), mEditTextPassword.getText().toString(),context))
                            LoginActivity.this.finish();
                        else ;

                    } catch (IOException e) {
                    } catch (AccountManager.NotExistException e) {
                    }catch (NullPointerException e){}
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

    public boolean ifNull() {
        String a=mEditTextEmail.getText().toString();
        String b=mEditTextPassword.getText().toString();

        return a.equals("") || b.equals("");
    }

}
