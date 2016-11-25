package com.example.gaoshihui;


import android.app.Activity;
import android.support.v4.app.NavUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * Created by 张巍 on 2016/11/24.
 */

public class AccountManager extends Activity {
    File mAccount,mPassword;
    public int userCounts = 1;
//    private final String PATH_ACCOUNT =  new MainActivity().PATH+"/app/libs/Account";
//    private final String PATH_PASSWORD = new MainActivity().PATH+"/app/libs/Password";
    private final String ACCOUNT="Account.txt";
    private final String PASSWORD="Password.txt";
    public HashMap<String, Integer> accountNum = new HashMap<>();

//    private File mAccount = new File(PATH_ACCOUNT,"Account.txt");
//    private File mPassword = new File(PATH_PASSWORD,"Password.txt");

    AccountManager() {
    }


    public void signIn(String account, String password) throws IOException {
        try {
            accountNum.get(account).toString();
        } catch (NullPointerException e) {
            accountNum.put(account, userCounts);
            fileSaver(account, password);
            userCounts++;
        }
    }


    public boolean logIn(String account, String password) throws NullPointerException, NotExistException, IOException {
        int num = accountNum.get(account);
        if (accountNum.get(account).equals(null))
            throw new NotExistException();
        InputStream me =this.openFileInput(PASSWORD);
        InputStreamReader a = new InputStreamReader(me);
        BufferedReader b = new BufferedReader(a);
        for (int i = 0; i < num - 1; i++) {
            b.readLine();
        }
        if (b.readLine().equals(password)) return true;
        else return false;
    }

    public void fileSaver(String account, String password) {

        try {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fileOutPut=null;
        OutputStreamWriter HarukiMurakami;
//        try {
//            mPassword.createNewFile();
//            mAccount.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            try {
                fileOutPut = this.openFileOutput(ACCOUNT, this.MODE_PRIVATE);
            }catch (Exception e){

            }
            HarukiMurakami =new OutputStreamWriter(fileOutPut);
            HarukiMurakami.write(account + "\n");
            HarukiMurakami.close();

            fileOutPut =this.openFileOutput(PASSWORD,this.MODE_PRIVATE);
            HarukiMurakami = new OutputStreamWriter(fileOutPut);
            HarukiMurakami.write(password + "\n");
            HarukiMurakami.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createFile() throws IOException {
        String a =getFilesDir().getPath();
        mAccount=new File(a,"Account.txt");
        mAccount.createNewFile();
        mPassword=new File(a,"Password.txt");
        mPassword.createNewFile();
    }

    public class NotExistException extends Exception {
    }

}

