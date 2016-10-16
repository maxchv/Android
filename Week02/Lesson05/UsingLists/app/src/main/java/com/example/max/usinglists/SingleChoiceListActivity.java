package com.example.max.usinglists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleChoiceListActivity extends AppCompatActivity {

    String[] mobileOS;
    ListView mListViewSingleChoice;
    Button mButtonGetChoice;
    TextView mTextViewSetChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choice_list);

        mobileOS = getResources().getStringArray(R.array.mobile_os);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mobile_os,
                android.R.layout.simple_list_item_single_choice);

        mListViewSingleChoice = (ListView) findViewById(R.id.listViewSingleChoice);
        mListViewSingleChoice.setAdapter(adapter);

        mListViewSingleChoice.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        mListViewSingleChoice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SingleChoiceListActivity.this, "Your choice " + mobileOS[position], Toast.LENGTH_SHORT).show();
            }
        });

        mButtonGetChoice = (Button) findViewById(R.id.button_get_single_choice);
        mTextViewSetChoice = (TextView) findViewById(R.id.textViewSingleChoice);

        mButtonGetChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = mobileOS[mListViewSingleChoice.getCheckedItemPosition()];
                mTextViewSetChoice.setText(choice);
            }
        });

    }
}
