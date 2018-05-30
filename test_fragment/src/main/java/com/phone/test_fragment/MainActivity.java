package com.phone.test_fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "onCreate:::::::::::::::::::");
    }

    /**
     * 显示oneFragment
     * @param v
     */
    public void showFristFragment(View v){

    }

    /**
     * 显示twoFragment
     * @param v
     */
    public void showSecondFragment(View v){

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart:::::::::::::::::::");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume:::::::::::::::::::");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause:::::::::::::::::::");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop:::::::::::::::::::");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy:::::::::::::::::::");
    }
    
}
