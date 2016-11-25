package com.example.gaoshihui;


import android.app.Activity;
import android.content.Context;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * Created by 张巍 on 2016/11/24.
 */

public  class AccountManager extends Activity {

    File mAccount,mPassword;
    public int userCounts = 1;
//    private final String PATH_ACCOUNT =  new MainActivity().PATH+"/app/libs/Account";
//    private final String PATH_PASSWORD = new MainActivity().PATH+"/app/libs/Password";
    private final String ACCOUNT="Account.txt";
    private final String PASSWORD="Password.txt";
    public HashMap<String, String> accountNum = new HashMap<>();

//    private File mAccount = new File(PATH_ACCOUNT,"Account.txt");
//    private File mPassword = new File(PATH_PASSWORD,"Password.txt");

    AccountManager() {
    }


    public void signIn(String account, String password,Context context) throws IOException {
        if( accountNum.get(account)==null){
            accountNum.put(account,String.valueOf(userCounts) );
            fileSaver(account, password,context);
            userCounts++;
        }else {

        }
    }


    public boolean logIn(String account, String password,Context context) throws NullPointerException, NotExistException, IOException {
        if (accountNum.get(account)==null)
            throw new NotExistException();
        int num = Integer.valueOf(accountNum.get(account));
        InputStreamReader a = new InputStreamReader(new FileInputStream(mPassword));
        BufferedReader b = new BufferedReader(a);
        for (int i = 0; i < num - 1; i++) {
            b.readLine();
        }
        return b.readLine().equals(password);
    }

    public void fileSaver(String account, String password,Context context) {

        try {
            createFile(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStreamWriter HarukiMurakami;
//        try {
//            mPassword.createNewFile();
//            mAccount.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            HarukiMurakami =new FileWriter(mAccount);
            HarukiMurakami.write(account + "\n");
            HarukiMurakami.close();

            HarukiMurakami = new FileWriter(mPassword);
            HarukiMurakami.write(password + "\n");
            HarukiMurakami.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createFile(Context context) throws IOException {
        String b =context.getFilesDir().getPath()+"libs/";
        new File(b).mkdirs() ;
        mAccount=new File(b,ACCOUNT);
        mAccount.createNewFile();
        mPassword=new File(b,PASSWORD);
        mPassword.createNewFile();
    }

    public class NotExistException extends Exception {
    }

}

