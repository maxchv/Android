package ua.dp.itstep.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listOS);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.os, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }
}
