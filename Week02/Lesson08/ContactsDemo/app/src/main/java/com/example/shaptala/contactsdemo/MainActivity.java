package com.example.shaptala.contactsdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.content.ContentResolverCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.activity_main);


        ContentResolver contentResolver = getContentResolver();
        String[] projection = new String[] {
                //ContactsContract.Contacts._ID,
                //ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone._ID,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI
               // ContactsContract.Contacts.PHOTO_URI
        };
        Cursor c = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                //ContactsContract.Contacts.CONTENT_URI,
                projection, null, null, null);


        String[] from = new String[] {
                //ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.Contacts.PHOTO_URI
        };
        int[] to = {
                R.id.textViewName,
                R.id.textViewPhone,
                R.id.imageViewPhoto
        };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.contact_item, c, from, to, 0);

        listView.setAdapter(adapter);
    }
}
