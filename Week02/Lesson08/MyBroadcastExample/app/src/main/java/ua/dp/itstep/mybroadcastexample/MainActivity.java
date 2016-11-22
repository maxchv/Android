package ua.dp.itstep.mybroadcastexample;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static final String MY_RECEIVER = "ua.dp.itstep.mybroadcastexample.test";
    Switch mSwitch;
    private BroadcastReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwitch = (Switch) findViewById(R.id.switchReiver);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    register();
                    Intent intent = new Intent(MY_RECEIVER);
                    sendBroadcast(intent);
                } else {
                    unregister();
                }
            }
        });
    }

    private void unregister() {
        unregisterReceiver(myReceiver);
    }

    private void register() {
        IntentFilter intentFilter = new IntentFilter(MY_RECEIVER);
        registerReceiver(myReceiver, intentFilter);
    }
}
