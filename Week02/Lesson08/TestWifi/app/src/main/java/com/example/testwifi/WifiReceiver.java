package com.example.testwifi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver{

	final String tag="com.example.testwifi";
    @Override
    public void onReceive(Context context, Intent intent) {    	
        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        
        if(info!=null){
            if(info.isConnected()){
                //Do your work. 

                //To check the Network Name or other info:
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ssid = wifiInfo.getSSID();
                Log.d(tag, "Connected to: " + ssid);
                Toast.makeText(context, "Connected to " + ssid, Toast.LENGTH_SHORT).show();
                //if(ssid.equals("step")) {
                	postData(intent);
                //}                
                
                intent.putExtra(MainActivity.msg, "Connected to " + ssid);                
                
            } else {
            	Log.d(tag, "Didn't connect");
            	intent.putExtra(MainActivity.msg, "Didn't connect");
            	Toast.makeText(context, "Didn't connect", Toast.LENGTH_LONG).show();
            }
        }
    }
    
    public void postData(Intent intent) {
    	final String USER_AGENT = "Mozilla/5.0";
    	String url = "http://logbook.itstep.org/new/index.php";
		URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		//add reuqest header
		try {
			con.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "auth[pass]=52db0a&auth[login]=shaptala&fast_reg=on";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = null;
		try {
			wr = new DataOutputStream(con.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wr.writeBytes(urlParameters);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		int responseCode = 0;
		try {
			responseCode = con.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(tag,"\nSending 'POST' request to URL : " + url);
		Log.d(tag,"Post parameters : " + urlParameters);
		Log.d(tag,"Response Code : " + responseCode);
 
		BufferedReader in = null;
		try {
			in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		//print result
		Log.d(tag, response.toString());
    } 
    
    private void onResume() {
		// TODO Auto-generated method stub

	}
    
    private void onPause() {
		// TODO Auto-generated method stub

	}
}