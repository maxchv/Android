package ua.dp.itstep.shaptala.savingdatademo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStorageDemo extends AppCompatActivity {

    public static final String TEST_FILE = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_demo);
    }

    public void stroreText(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextToFileStorage);
        try {
            FileOutputStream file = openFileOutput(TEST_FILE, Context.MODE_PRIVATE);
            TextView mTextViewTotalSpace = (TextView) findViewById(R.id.textViewTotalSpace);
            File f = getFilesDir();

            TextView mTextViewPath = (TextView) findViewById(R.id.textViewPath);
            mTextViewPath.setText(f.getAbsolutePath());
            mTextViewTotalSpace.setText(String.valueOf(f.getTotalSpace()));
            TextView mTextViewFreeSpace = (TextView) findViewById(R.id.textViewFreeSpace);
            mTextViewFreeSpace.setText(String.valueOf(f.getFreeSpace()));
            file.write(editText.getText().toString().getBytes());
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
