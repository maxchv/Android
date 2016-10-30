package ua.dp.itstep.shaptala.savingdatademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDemo(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.buttonSharedPreferances:
                intent = new Intent(this, SharePreferanceDemo.class);
                break;
            case R.id.buttonFiles:
                intent = new Intent(this, FileStorageDemo.class);
                break;
            case R.id.buttonDatabase:
                break;
            default:
                Toast.makeText(this, R.string.unknown_action, Toast.LENGTH_SHORT).show();
        }
        if(intent != null) {
            startActivity(intent);
        }
    }
}
