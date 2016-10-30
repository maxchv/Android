package ua.dp.itstep.shaptala.savingdatademo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePreferanceDemo extends AppCompatActivity {

    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONE = "phone";
    EditText mEditTextEmail;
    EditText mEditTextName;
    EditText mEditTextPhone;

    TextView mTextViewStoredName;
    TextView mTextViewStoredEmail;
    TextView mTextViewStoredPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferance_demo);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextPhone = (EditText) findViewById(R.id.editTextPhone);

        mTextViewStoredName = (TextView) findViewById(R.id.textViewStoredName);
        mTextViewStoredEmail = (TextView) findViewById(R.id.textViewStoredEmail);
        mTextViewStoredPhone = (TextView) findViewById(R.id.textViewStoredPhone);

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String name = preferences.getString(KEY_NAME, "");
        String email = preferences.getString(KEY_EMAIL, "");
        String phone = preferences.getString(KEY_PHONE, "");

        mTextViewStoredName.setText(name);
        mTextViewStoredPhone.setText(phone);
        mTextViewStoredEmail.setText(email);
    }

    public void storeDataSharedPreferances(View v) {
        String name = mEditTextName.getText().toString();
        String email = mEditTextEmail.getText().toString();
        String phone = mEditTextPhone.getText().toString();

        mTextViewStoredName.setText(name);
        mTextViewStoredPhone.setText(phone);
        mTextViewStoredEmail.setText(email);

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences preferences = getSharedPreferences(getString(R.string.preference_file_key),
        //                                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHONE, phone);
        editor.commit();
    }

    public void tryStartActivity(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.textViewStoredEmail:
                String email = mTextViewStoredEmail.getText().toString();
                if(!email.isEmpty()) {
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"+email));
                    //intent.putExtra(Intent.EXTRA_EMAIL, email);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "Body");
                }
                break;
            case R.id.textViewStoredPhone:
                String phone = mTextViewStoredPhone.getText().toString();
                if(!phone.isEmpty()) {
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phone));
                }
                break;
        }
        if(intent != null) {
            //startActivity(Intent.createChooser(intent, "Send email..."));
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Not started", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
