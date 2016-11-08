package com.example.hsport.catalog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ProductListFragment.ListFragmentListener {

    private static final int MENU_ITEM_LOGOUT = 1001;
    public static final String PRODUCT_ID = "PRODUCT_ID";

    private static final int DETAIL_REQUEST = 1111;
    public static final String RETURN_MESSAGE = "RETURN_MESSAGE";
    private static final String TAG = "MainActivity";

    private CoordinatorLayout coordinatorLayout;

    private List<Product> mProductList = DataProvider.productList;

    private boolean mIsTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout fragmentContainer =
                (FrameLayout) findViewById(R.id.detail_fragment_container);
        mIsTablet = (fragmentContainer != null);

        Log.i(TAG, "onCreate: mTablet=" + mIsTablet);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(0, MENU_ITEM_LOGOUT, 1001, R.string.logout);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Snackbar.make(coordinatorLayout,
                        "You selected settings", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_cart:
                Snackbar.make(coordinatorLayout,
                        "You selected the Shopping Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case MENU_ITEM_LOGOUT:
                Snackbar.make(coordinatorLayout,
                        "You selected Logout", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DETAIL_REQUEST) {
            if (resultCode == RESULT_OK) {
                String message = data.getStringExtra(RETURN_MESSAGE);
                Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                        .setAction("Go to cart", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,
                                        "Going to cart", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        }
    }

    @Override
    public void onListItemClick(Uri uri) {

        int position = Integer.valueOf(uri.getLastPathSegment());
        Product product = mProductList.get(position);

        if (mIsTablet) {
            ProductDetailFragment fragment =
                    ProductDetailFragment.newInstance(product.getProductId());
            FragmentManager manager = getSupportFragmentManager();

            manager.beginTransaction()
                    .replace(R.id.detail_fragment_container, fragment)
                    .commit();

        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(PRODUCT_ID, product.getProductId());
            startActivityForResult(intent, DETAIL_REQUEST);
        }

    }
}
