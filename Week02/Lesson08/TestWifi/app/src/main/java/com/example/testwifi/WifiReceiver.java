package com.example.testwifi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver{

	final String TAG ="com.example.testwifi";

    Context ctx;

    @Override
    public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "onReceive: receive something");
        ctx = context;
		NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        
        if(info != null){
            if(info.isConnected()){
                //Do your work. 

                //To check the Network Name or other info:
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ssid = wifiInfo.getSSID();
                Log.d(TAG, "Connected to: " + ssid);
                Toast.makeText(context, "Connected to " + ssid, Toast.LENGTH_SHORT).show();
                //if(ssid.equals("step")) {
                	//postData(intent);
                //}                
                
                intent.putExtra(MainActivity.msg, "Connected to " + ssid);                
                
            } else {
            	Log.d(TAG, "Didn't connect");
            	intent.putExtra(MainActivity.msg, "Didn't connect");
            	Toast.makeText(context, "Didn't connect", Toast.LENGTH_LONG).show();
            }
        }
    }
    
    public void postData(Intent intent) {

    }
}