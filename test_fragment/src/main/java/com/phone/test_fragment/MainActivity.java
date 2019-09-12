package com.phone.test_fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.phone.test_fragment.framents.OneFrament;
import com.phone.test_fragment.framents.TwoFragment;

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
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.myfragment,new OneFrament(),"oneFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * 显示twoFragment
     * @param v
     */
    public void showSecondFragment(View v){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.myfragment,new TwoFragment(),"secondFragment");
        fragmentTransaction.addToBackStack("secondFragment");
        fragmentTransaction.commit();
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Log.e("TAG", "keycode=============="+keyCode);
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Log.e("TAG", "监听返回键===============");
        getFragmentManager().popBackStack("secondFragment",11);
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(1000);
                    int backStackEntryCount = getFragmentManager().getBackStackEntryCount();
                    Log.e("TAG", "backStackentryCount============"+backStackEntryCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

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
