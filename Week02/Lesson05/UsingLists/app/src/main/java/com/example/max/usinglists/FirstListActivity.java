package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstListActivity extends AppCompatActivity {

    ListView mListView;
    ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list);

        names.add("Linux");

        mListView = (ListView) findViewById(R.id.listViewFirst);
        mListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FirstListActivity.this, "Position " + position + "\n name " + names.get(position) , Toast.LENGTH_SHORT).show();
                names.add("Windows");
                adapter.notifyDataSetChanged();
            }
        });
    }
}
