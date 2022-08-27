package org.itstep.lesson07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import static org.itstep.lesson07.SimpleFragment.TEXT_PARAM;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String FRAGMENT_TAG = "FragmentTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
            Log.i(TAG, "fragment? " + (fragment == null ? "not exists" : "exists"));
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction().setReorderingAllowed(true);
//            Bundle bundle = new Bundle();
//            Fragment simpleFragment = new SimpleFragment();
//            simpleFragment.setArguments(bundle);
            if(fragment == null) {
//                bundle.putString(TEXT_PARAM, "Added first time");
                fragmentTransaction
//                        .add(R.id.simpleFragment, SimpleFragment.class, bundle, FRAGMENT_TAG);
//                        .add(R.id.simpleFragment, simpleFragment, FRAGMENT_TAG);
                        .add(R.id.simpleFragment, SimpleFragment.newInstance("Added first time"), FRAGMENT_TAG);
            } else {
//                bundle.putString(TEXT_PARAM, "Added not first time");
                fragmentTransaction
//                        .replace(R.id.simpleFragment, SimpleFragment.class, bundle, FRAGMENT_TAG);
//                        .replace(R.id.simpleFragment, simpleFragment, FRAGMENT_TAG);
                        .replace(R.id.simpleFragment, SimpleFragment.newInstance("Added not first time"), FRAGMENT_TAG);
            }
            fragmentTransaction.commit();
        });
    }
}