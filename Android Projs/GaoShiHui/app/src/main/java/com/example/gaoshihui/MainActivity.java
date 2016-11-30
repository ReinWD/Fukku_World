package com.example.gaoshihui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    public static AccountManager mManager = new AccountManager() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
        mManager.createFile(this.getApplicationContext());}catch (IOException e){
            System.out.println("文件已建好");
        }

        ImageButton mEnter;

        mEnter = (ImageButton) findViewById(R.id.main_enter);
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
    static {
        int accountNums = 0;
    }
}
