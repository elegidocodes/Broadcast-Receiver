package com.elegidocodes.broadcast.receiver;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CustomBroadcastReceiver customBroadcastReceiver;

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customBroadcastReceiver = new CustomBroadcastReceiver();
        IntentFilter filter = new IntentFilter(CustomBroadcastReceiver.CUSTOM_ACTION);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            registerReceiver(customBroadcastReceiver, filter, RECEIVER_EXPORTED);
        }else{
            registerReceiver(customBroadcastReceiver, filter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(customBroadcastReceiver);
    }

}