package com.example.max.usingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ProgramMenuDemo extends AppCompatActivity {

    public static final int OPEN_ID = 101;
    public static final int SAVE_ID = 102;
    public static final int EXIT_ID = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_menu_demo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //       Group,     Id,      Order,     Text
        menu.add(Menu.NONE, OPEN_ID, Menu.NONE, R.string.menu_open);
        menu.add(Menu.NONE, SAVE_ID, Menu.NONE, R.string.menu_save);
        menu.add(Menu.NONE, EXIT_ID, Menu.NONE, R.string.menu_exit);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case OPEN_ID:
                item.setChecked(!item.isChecked());
                return false;
            case SAVE_ID:
                break;
            case EXIT_ID:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
