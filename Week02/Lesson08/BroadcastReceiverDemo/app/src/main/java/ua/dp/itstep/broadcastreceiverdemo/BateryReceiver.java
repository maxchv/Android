package ua.dp.itstep.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class BateryReceiver extends BroadcastReceiver {

    public static final String TAG = "BatteryReceiver";

    public BateryReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
        Log.i(TAG, "onReceive: level " + level + " scale " + scale);
    }

}
