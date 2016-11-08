package com.example.android.dialogs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements DataEntryDialog.DataEntryListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab == null) throw new AssertionError();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {

        Person p = new Person("Mickey", "Mouse", 35);

        DataEntryDialog dialog = DataEntryDialog.newInstance(p);
        dialog.show(getSupportFragmentManager(), "DIALOG_FRAGMENT");
    }

    @Override
    public void onDataEntryComplete(Person person) {
        Toast.makeText(MainActivity.this, "You entered " + person.getFirstName() +
                " " + person.getLastName(), Toast.LENGTH_SHORT).show();
    }
}
