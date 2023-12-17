package com.elegidocodes.broadcast.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //private CustomBroadcastReceiver customBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //customBroadcastReceiver = new CustomBroadcastReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //registerReceiver(customBroadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregisterReceiver(customBroadcastReceiver);
    }

}