package com.phone.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Uri data = intent.getData();  //
        String action = intent.getAction();
        String scheme = intent.getScheme();
        Set<String> categories = intent.getCategories();
        Log.e("TAG", "data==========="+data);
        Log.e("TAG", "action==========="+action);
        Log.e("TAG", "categories==========="+categories);
        Log.e("TAG", "DataString==========="+intent.getDataString());
        Log.e("TAG", "==============================");
        Log.e("TAG", "scheme==========="+scheme);
        Log.e("TAG", "id ==========="+data.getQueryParameterNames());
        Log.e("TAG", "host==========="+data.getHost());
        Log.e("TAG", "path==========="+data.getPath());
        Log.e("TAG", "port==========="+data.getPort());



    }
}
