package ua.dp.itstep.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyReceiver", "onReceive: " + intent.getAction());
        //if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            String message = "Обнаружено сообщение "
                    + intent.getAction();

            Toast.makeText(context, message,
                    Toast.LENGTH_LONG).show();
        //}
    }
}
