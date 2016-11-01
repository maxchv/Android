package ua.dp.itstep.filesdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqlHelperDemo helper = new SqlHelperDemo(this);

        SQLiteDatabase writer = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("data", "some data");
        writer.insert("db", null, values);

        SQLiteDatabase reader = helper.getReadableDatabase();
        Cursor c = reader.query("db", new String[] {"id", "data"}, null, null, null, null, null );
        mTextView = (TextView) findViewById(R.id.textView);
        //c.moveToFirst();
        while(c.moveToNext()) {
            String data = c.getString(1);
            mTextView.setText(data);
        }
    }
}
