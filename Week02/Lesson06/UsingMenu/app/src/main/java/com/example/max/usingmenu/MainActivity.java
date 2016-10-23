package com.example.max.usingmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDemoActivity(View v) {
        Intent intent = null;
        switch (v.getId())
        {
            case R.id.button_program_menu:
                intent = new Intent(this, ProgramMenuDemo.class);
                break;
            case R.id.button_xml_menu:
                intent = new Intent(this, UsingXmlActivity.class);
                break;
            case R.id.button_context_menu:
                intent = new Intent(this, ContextMenuDemo.class);
                break;
            case R.id.button_popup_menu:
                intent = new Intent(this, PopupMenuDemo.class);
            case R.id.button_group_menu:
                intent = new Intent(this, GroupMenuDemo.class);
            default:
                break;
        }
        if(intent != null) {
            startActivity(intent);
        }
    }
}
