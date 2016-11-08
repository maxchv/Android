package com.example.android.preferencefragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onSettingsClick(MenuItem item) {

        Intent intent = new Intent(this, MyPreferencesActivity.class);
        startActivity(intent);

    }

    public void onTestPrefClick(MenuItem item) {

        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        String userName = preferences.getString("username", "not defined");

        Toast.makeText(MainActivity.this, "User name: " + userName,
                Toast.LENGTH_SHORT).show();

    }
}
