package com.elegidocodes.broadcast.receiver;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

public class MyApplication extends Application {

    private CustomBroadcastReceiver customBroadcastReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        customBroadcastReceiver = new CustomBroadcastReceiver();
        registerConnectivityReceiver();
    }

    public void registerConnectivityReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(customBroadcastReceiver, filter);
    }

    public void unregisterConnectivityReceiver() {
        unregisterReceiver(customBroadcastReceiver);
    }

}
