package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ListView mListViewCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        mListViewCustom = (ListView) findViewById(R.id.listViewCustom);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Max", "Dnepropetrovsk"));
        users.add(new User("Anna", "Dnepropetrovsk"));
        UsersAdapterListView adapter = new UsersAdapterListView(this, users);

        mListViewCustom.setAdapter(adapter);
    }
}
