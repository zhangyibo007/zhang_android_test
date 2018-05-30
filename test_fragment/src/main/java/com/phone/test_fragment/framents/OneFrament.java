package com.phone.test_fragment.framents;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phone.test_fragment.R;

/**
 * Created by zhang on 2018/5/29.
 */

public class OneFrament extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("TAG", "onAttach================");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("TAG", "onCreateView================");
        View view = inflater.inflate(R.layout.frament_one, null);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "onCreate================");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("TAG", "onActivityCreated================");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("TAG", "onStart================");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG", "onResume================");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG", "onPause================");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("TAG", "onStop================");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("TAG", "onDestroyView================");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy================");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("TAG", "onDetach================");
    }

}
