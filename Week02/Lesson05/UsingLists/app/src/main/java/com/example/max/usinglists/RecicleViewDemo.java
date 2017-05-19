package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecicleViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicle_view_demo);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<User> users = new ArrayList<>();
        for(int i=0; i<200; i++) {
            users.add(new User("Max" + i, "Dnepropetrovsk"));
            users.add(new User("Anna" + i, "Dnepropetrovsk"));
        }

        UsertItemAdapter usertItemAdapter = new UsertItemAdapter(users, this);
        recyclerView.setAdapter(usertItemAdapter);
    }
}
