package com.example.android.firstfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickHandler(View view) {

        Bundle arguments = new Bundle();
        arguments.putString(SimpleFragment.MESSAGE_KEY, "Passed as an argument");

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
