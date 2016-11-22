package com.example.testwifi;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//http://viralpatel.net/blogs/android-internet-connection-status-network-change/

public class MainActivity extends Activity {
	final String tag="com.example.testwifi";
	final static String msg = "com.example.testwifi.connected"; 
	
	String login;
	String password;
	WifiReceiver wifiReciver;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d(tag, "Start activity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * Start listening to WiFi connection i.e. WiFiReciver
     */
    public void onClickStart(View view) {    	
    	Log.d(tag, "onClickStart");
        final IntentFilter filters = new IntentFilter();
        filters.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filters.addAction("android.net.wifi.STATE_CHANGE");
        filters.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filters.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        
        wifiReciver = new WifiReceiver();
        
        registerReceiver(wifiReciver, filters);
    	EditText etLogin = (EditText) findViewById(R.id.etLogin);
    	EditText etPassword = (EditText) findViewById(R.id.etPassword);
    	
    	login = etLogin.getText().toString();
    	password = etPassword.getText().toString();
    }
    
    /**
     * Stop listening to WiFi connection i.e. WiFiReciver
     */
    public void onClickStop(View view) {    	
    	Log.d(tag, "onClickStop");
    	if (wifiReciver != null) {
    		unregisterReceiver(wifiReciver);
    	}
    }
    
    /**
     * Status WiFi connection
     */
    public void onClickStatus(View view) {    	
    	Log.d(tag, "onClickStatus");
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	if (wifiReciver != null) {
    		unregisterReceiver(wifiReciver);
    	}
    	super.onPause();
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	if (wifiReciver != null) {
    		unregisterReceiver(wifiReciver);
    	}
    	super.onDestroy();
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	
    	super.onResume();
    }
}
