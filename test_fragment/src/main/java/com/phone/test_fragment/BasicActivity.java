package com.phone.test_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
    }


    public void staticFragment(View view){
        startActivity(new Intent(this,StaticActivity.class));
    }

    public void dymicFragment(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void createFile(View view){
        String font="输出流是用来写入数据的！";

        File file = new File(Environment.getExternalStorageDirectory(),"/appcan/");
        if(!file.exists()){
            Log.e("TAG", "不存在==========="+file.getAbsolutePath());
            file.mkdirs();
        }
        File mTmpFile = new File(file.getAbsolutePath() + System.currentTimeMillis()+".txt");

        Log.e("TAG", "==========="+mTmpFile.getAbsolutePath());
        OutputStream outStream = null;
        try {
            outStream=new FileOutputStream(mTmpFile);
            outStream.write(font.getBytes());
            outStream.close();
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public void createTempFile(View view){
        Log.e("TAG", "48px=============="+px2sp(this,48));
        Log.e("TAG", "32px=============="+px2sp(this,32));

        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String dowloadpath=rootPath+"/appcan/";
        File newfile = new File(dowloadpath+System.currentTimeMillis()+".txt");

        Log.e("TAG", "new file "+newfile.exists());
//        File newfile=new File(rootPath,"/zhangsan/hello.txt");
//        Log.e("TAG", "newFile=========="+newfile);
        try {
            File zhangsan = File.createTempFile("zhangsan", ".txt", new File(rootPath));
            Log.e("TAG", "=========="+zhangsan.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
