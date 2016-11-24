package com.example.gaoshihui;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by 张巍 on 2016/11/24.
 */

public class AccountManager extends Activity {
    public int userCounts = 0;
    private final String PATH_ACCOUNT =null ;
    private final String PATH_PASSWORD =null ;
    public HashMap<String, Integer> accountNum;

    private File mAccount  = new File(PATH_ACCOUNT , "Account" );
    private File mPassword = new File(PATH_PASSWORD, "Password");

    public void signIn(String account, String password) throws IOException, AlreadyExistException {
        userCounts++;
        if (accountNum.get(account) != null) {
            accountNum.put(account, userCounts);
            fileSaver(account, password);

        } else {
            throw new AlreadyExistException();
        }
    }

    public boolean logIn(String account, String password) throws NotExistException, IOException {
        int num = accountNum.get(account);
        if (accountNum.get(account).equals(null))
            throw new NotExistException();
        FileReader me = new FileReader(mPassword);
        BufferedReader a = new BufferedReader(me);
        for (int i = 0; i < num - 1; i++) {
            a.readLine();
        }
        if (a.readLine().equals(password)) return true;
        else return false;
    }

    public void fileSaver(String account, String password) throws IOException {

        mAccount.createNewFile();
        mPassword.createNewFile();

        FileWriter HarukiMurakami = new FileWriter(mAccount);
        HarukiMurakami.write(account + "\n");
        HarukiMurakami.close();
        HarukiMurakami = new FileWriter(mPassword);
        HarukiMurakami.write(password + "\n");
        HarukiMurakami.close();
    }

    public class NotExistException extends Exception {
    }

    public class AlreadyExistException extends Exception {
    }
}

