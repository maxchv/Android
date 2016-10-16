package com.example.max.usinglists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButtonInflateLayout;
    Button mButtonFirstList;
    Button mButtonSecondList;
    Button mButtonSingleChoiceList;
    Button mButtonMultiChoiceList;
    Button mButtonCustomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonInflateLayout = (Button) findViewById(R.id.button_inflat_layout);
        mButtonInflateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InflateLayoutActivity.class);
                startActivity(intent);
            }
        });

        mButtonFirstList = (Button) findViewById(R.id.button_first_list);
        mButtonFirstList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstListActivity.class);
                startActivity(intent);
            }
        });

        mButtonSecondList = (Button) findViewById(R.id.button_second_list);
        mButtonSecondList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondListActivity.class);
                startActivity(intent);
            }
        });

        mButtonSingleChoiceList = (Button) findViewById(R.id.button_single_choice_list);
        mButtonSingleChoiceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SingleChoiceListActivity.class);
                startActivity(intent);
            }
        });

        mButtonMultiChoiceList = (Button) findViewById(R.id.button_multi_choice_list);
        mButtonMultiChoiceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MultiChoiceListActivity.class);
                startActivity(intent);
            }
        });

        mButtonCustomList = (Button) findViewById(R.id.button_custom_list);
        mButtonCustomList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomListActivity.class);
                startActivity(intent);
            }
        });
    }

}
