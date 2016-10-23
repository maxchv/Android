package ua.dp.itstep.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ProgramCreations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_program_creations);

        LinearLayout linearLayout = new LinearLayout(this);
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.gravity = Gravity.CENTER;
        button.setText("Button");
        button.setLayoutParams(params);


        linearLayout.addView(button);

        setContentView(linearLayout, params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "Open");
        menu.add(Menu.NONE, 2, Menu.NONE, "Save");
        menu.add(Menu.NONE, 3, Menu.NONE, "Close");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                Toast.makeText(this, "Open", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
