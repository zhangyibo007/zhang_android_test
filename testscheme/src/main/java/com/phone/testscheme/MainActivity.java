package com.phone.testscheme;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PackageManager packageManager = getPackageManager();

        Intent intent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("zymobi://3g2win:9999/macthDetail?macthId=222&time=10001"));

        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);

        boolean isValid = !activities.isEmpty();
        Toast.makeText(this,isValid+"",Toast.LENGTH_LONG).show();

//        if
//                (isValid) {
//
//            startActivity(intent);
//
//        }
    }
}
