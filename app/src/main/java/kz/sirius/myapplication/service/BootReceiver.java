package kz.sirius.myapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BootReceiver extends BroadcastReceiver {

    public static String TAG = "BootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "BootReceived");

        SharedPreferences sharedPref = context.getSharedPreferences(
                "Pref", Context.MODE_PRIVATE);

        if (sharedPref.getStringSet("RebootTime", new HashSet<String>()).isEmpty()) {
            Set<String> bootTime = new HashSet<>();
            bootTime.add(getCurrentTime());
            sharedPref.edit().putStringSet("RebootTime", bootTime).apply();
        } else {
            Set<String> bootTime = sharedPref.getStringSet("RebootTime", new HashSet<String>());
            bootTime.add(getCurrentTime());
            sharedPref.edit().putStringSet("RebootTime", bootTime).apply();
        }

    }

    private String getCurrentTime() {
        return "LoadTime: " + String.valueOf(System.currentTimeMillis());
    }
}
