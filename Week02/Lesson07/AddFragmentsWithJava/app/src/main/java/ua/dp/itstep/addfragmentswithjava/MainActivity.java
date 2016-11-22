package ua.dp.itstep.addfragmentswithjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public static final String FRAGMENT_TAG = "fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {
        SimpleFragment fragment;
        fragment = new SimpleFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .commit();
    }

    public void removeHandler(View view) {
        SimpleFragment fragment =
                (SimpleFragment) getSupportFragmentManager()
                //.findFragmentById(R.id.fragment_container);
                .findFragmentByTag(FRAGMENT_TAG);
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }
}
