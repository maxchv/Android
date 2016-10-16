package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MultiChoiceListActivity extends AppCompatActivity {

    String[] mobileOS;
    ListView mListViewMultiChoice;
    Button mButtonGetMultiChoice;
    TextView mTextViewSetChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_choice_list);

        mobileOS = getResources().getStringArray(R.array.mobile_os);
        mButtonGetMultiChoice = (Button) findViewById(R.id.button_get_multi_choice);
        mTextViewSetChoice = (TextView) findViewById(R.id.textViewMultiChoice);
        mListViewMultiChoice = (ListView) findViewById(R.id.listViewMultiChoice);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mobile_os, android.R.layout.simple_list_item_multiple_choice);
        mListViewMultiChoice.setAdapter(adapter);
        mListViewMultiChoice.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        mButtonGetMultiChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray arrPos =  mListViewMultiChoice.getCheckedItemPositions();
                String res = "";
                for(int i=0; i<arrPos.size(); i++){
                    int pos = arrPos.keyAt(i);
                    if(arrPos.get(pos)) {
                        res += mobileOS[pos] + ", ";
                    }
                }
                mTextViewSetChoice.setText(res);
            }
        });
    }
}
