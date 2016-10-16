package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SecondListActivity extends AppCompatActivity {

    ListView mListViewSecond;
    String[] mobileOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_list);

        mListViewSecond = (ListView) findViewById(R.id.listViewSecond);
        mListViewSecond.setChoiceMode(ListView.CHOICE_MODE_NONE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mobile_os, android.R.layout.simple_list_item_1);
        mListViewSecond.setAdapter(adapter);

        mobileOS = getResources().getStringArray(R.array.mobile_os);
        mListViewSecond.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondListActivity.this, "You typed " + mobileOS[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
