package org.itstep.twopanelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener, BlankFragment.OnDeleteListener {

    private boolean isTwoPane = false;
    private List<String> list = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        listView = findViewById(R.id.listViewItems);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        isTwoPane = findViewById(R.id.detailViewFragment) != null;
    }

    private void initList() {
        for (int i = 0; i < 30; i++) {
            list.add(UUID.randomUUID().toString());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (isTwoPane) {
            removeFragmentIfExists();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.detailViewFragment, BlankFragment.newInstance(list.get(position)), "tag")
                    .commit();
        }
    }

    private void removeFragmentIfExists() {
        Fragment f = getSupportFragmentManager().findFragmentByTag("tag");
        if (f != null) {
            getSupportFragmentManager().beginTransaction().remove(f).commit();
        }
    }

    @Override
    public void onDelete(String item) {
        Toast.makeText(this, "You should remove item " + item, Toast.LENGTH_SHORT).show();
        list.remove(item);
        adapter.notifyDataSetChanged();
        removeFragmentIfExists();
    }
}
