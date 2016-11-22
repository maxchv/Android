package ua.dp.itstep.fragmentscallback;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements DetailFragment.FragmentListener {

    private static final String TAG = "MainActivity";
    private boolean mTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewGroup fragmentGroup = (ViewGroup) findViewById(R.id.fragment_main);
        mTablet = (fragmentGroup != null);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click
                if(mTablet) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_main, DetailFragment.newInstance())
                            .commit();
                } else {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentFinished(Person person) {
        Log.i(TAG, "onFragmentFinished:  " + person);

        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commit();
    }
}
