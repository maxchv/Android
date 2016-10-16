package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InflateLayoutActivity extends AppCompatActivity {

    Button mButtonAdd;
    LayoutInflater ltInflater;
    EditText mEditTextItem;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflate_layout);

        layout = (LinearLayout) findViewById(R.id.layoutBase);

        ltInflater = getLayoutInflater();
        View v = ltInflater.inflate(R.layout.item, layout, true);
        //layout.addView(v);
        ViewGroup.LayoutParams params = v.getLayoutParams();

        Log.i("layout_app_log", "class name: " + v.getClass().getName());

        mEditTextItem = (EditText) findViewById(R.id.editTextItem);
        mButtonAdd = (Button) findViewById(R.id.button_add);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) ltInflater.inflate(R.layout.item, null, false);
                tv.setText(mEditTextItem.getText());
                layout.addView(tv);
            }
        });
    }
}
