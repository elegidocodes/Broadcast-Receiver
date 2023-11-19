package com.elegidocodes.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    static final String CUSTOM_ACTION = "com.elegidocodes.broadcast.receiver.CUSTOM_ACTION";

    static final String EXTRA_TEXT = "com.elegidocodes.broadcast.receiver.EXTRA_TEXT";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(CUSTOM_ACTION.equals(intent.getAction())){
            String receivedText = intent.getStringExtra(EXTRA_TEXT);
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
        }

    }

}
