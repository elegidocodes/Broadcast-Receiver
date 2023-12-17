package com.elegidocodes.broadcast.second_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(sendBroadcast());
    }

    private View.OnClickListener sendBroadcast() {
        return view -> {
            Intent intent = new Intent("com.elegidocodes.broadcast.receiver.CUSTOM_ACTION");
            intent.putExtra("com.elegidocodes.broadcast.receiver.EXTRA_TEXT", "Broadcast received");
            sendBroadcast(intent);
        };
    }

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String textReceived = intent.getStringExtra("com.elegidocodes.broadcast.receiver.EXTRA_TEXT");
            Toast.makeText(context, textReceived, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.elegidocodes.broadcast.receiver.CUSTOM_ACTION");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            registerReceiver(broadcastReceiver, filter, RECEIVER_EXPORTED);
        }else{
            registerReceiver(broadcastReceiver, filter);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}