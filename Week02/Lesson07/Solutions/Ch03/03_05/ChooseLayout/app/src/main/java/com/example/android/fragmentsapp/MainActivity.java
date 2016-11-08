package com.example.android.fragmentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean mTablet;
    private ViewGroup fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentContainer = (ViewGroup) findViewById(R.id.detail_fragment_container);
        mTablet = (fragmentContainer != null);

        TextView tvOut = (TextView) findViewById(R.id.textOut);
        tvOut.setText("Fragments side-by-side? " + mTablet);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDetailFragment();
            }
        });

    }

    private void viewDetailFragment() {

        if (mTablet) {
            FragmentManager fragmentManager =
                    getSupportFragmentManager();
            DetailActivityFragment fragment = new DetailActivityFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.detail_fragment_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        }

    }


}
