package com.phone.test_http;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        File.createTempFile("Download", "." + extension, tm)
//
        File tm= Environment.getExternalStorageDirectory();
        Log.e("TAG", "==========="+tm);
        String extension="txt";
        try {
            File mTmpFile = File.createTempFile("/Download/", "." + extension, tm);
            Log.e("TAG", "mTmpFile=============="+mTmpFile.getAbsolutePath());
        } catch (IOException e) {
            Log.e("TAG", "e=========="+e.toString());
            e.printStackTrace();
        }

        String names="Download"+ "2323223." + extension;
        File name=new File(tm,names);
        Log.e("TAG", "name==========="+name.getName());
        Log.e("TAG", "name==========="+names.equals(name.getName()));
    }
}
