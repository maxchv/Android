package ua.dp.itstep.usingframes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private boolean mTablet;
    private TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup fragmentContainer = (ViewGroup) findViewById(R.id.fragment_details);
        mTablet = (fragmentContainer != null);

        tvOut = (TextView) findViewById(R.id.tvOut);
        tvOut.setText("Fragments side-by-side? " + mTablet);

        tvOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTablet) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.fragment_details, DetailActivityFragment.newInstance("Test Fragments"))
                            .commit();
                } else {
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
