# Broadcast Receiver

## Dynamic Receivers

### Create a class e.g CustomBroadcastReceiver

```java

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            );

            if (noConnectivity) {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }

        }

    }

}

```

### In the activity you want to call the BroadcastReceiver

```java

public class MainActivity extends AppCompatActivity {

    // Declare the class.
    private CustomBroadcastReceiver customBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the class.
        customBroadcastReceiver = new CustomBroadcastReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Set the action you want to listen to. In this case, checking the internet connection.
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        // Register the filter (action).
        registerReceiver(customBroadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unregister the BroadcastReceiver, to save memory, etc.
        unregisterReceiver(customBroadcastReceiver);
    }

}

```

**Note:** This will only work when you are in the activity. If you want to listen to the action in all activities, implement the
following code in your application class. When extending from `Application`, the action will be listened to as long as the app 
is running.

```Java

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

```

Finally, put `android:name=".MyApplication"` in your AndroidManifest file, inside the `<application></application>` tag.