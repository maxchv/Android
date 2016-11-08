package com.example.android.measurewithjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mOut;
    private boolean mUseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOut = (TextView) findViewById(R.id.text_out);

    }

    public void onMeasureBtnClick(View view) {
        ScreenUtility su = new ScreenUtility(this);
        mOut.setText(String.format("Width: %s, Height: %s",
                su.getDpWidth(), su.getDpHeight()));

        if (su.getDpWidth() >= 820) {
            mUseFragment = true;
        } else {
            mUseFragment = false;
        }

        Toast.makeText(MainActivity.this,
                "Using fragment? " + mUseFragment, Toast.LENGTH_SHORT).show();

    }
}
