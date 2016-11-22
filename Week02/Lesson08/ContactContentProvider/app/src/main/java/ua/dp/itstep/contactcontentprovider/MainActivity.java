package ua.dp.itstep.contactcontentprovider;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    // https://guides.codepath.com/android/Loading-Contacts-with-Content-Providers
    private String[] mProjection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.activity_main);

        mProjection = new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME
        };
        Cursor cursor = getContentResolver()
                .query(ContactsContract.Contacts.CONTENT_URI,
                        mProjection,
                        null,
                        null,
                        null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.contact_item, cursor,
                new String[]{ContactsContract.Contacts.DISPLAY_NAME}, new int[] {R.id.textView}, 0);
        mListView.setAdapter(adapter);
    }
}
