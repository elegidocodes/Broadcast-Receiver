# Broadcast Receiver

## Implicit

### Create a class e.g CustomBroadcastReceiver

```java

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            // This message will be displayed when the device boot is finished
            Toast.makeText(context, "Boot completed.", Toast.LENGTH_SHORT).show();
        }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            
            // This message will be displayed when the device internet connection is changed
            // It will not work for apps targeting N and higher
            Toast.makeText(context, "Connectivity changed.", Toast.LENGTH_SHORT).show();
        }

    }

}

```

### In the AndroidManifest file

Put the following xml code before the `<application></application>` tag.

```xml

<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

```

And the following one after the `<activity></activity>` tag.

```xml

<receiver android:name=".CustomBroadcastReceiver" android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED" />
        <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
    </intent-filter>
</receiver>

```

**Note:** `android.net.conn.CONNECTIVITY_CHANGE`  is deprecated for apps targeting N and higher.