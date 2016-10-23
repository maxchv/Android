package com.example.max.usingmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContextMenuDemo extends AppCompatActivity {

    TextView mTextViewColorText;
    TextView mTextViewSizeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_demo);

        mTextViewColorText = (TextView) findViewById(R.id.textViewColorText);
        mTextViewSizeText = (TextView) findViewById(R.id.textViewSizeTExt);

        registerForContextMenu(mTextViewColorText);
        registerForContextMenu(mTextViewSizeText);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.color_red:
                mTextViewColorText.setTextColor(Color.RED);
                mTextViewColorText.setText("Colr: red");
                break;
            case R.id.color_green:
                mTextViewColorText.setTextColor(Color.GREEN);
                mTextViewColorText.setText("Colr: geen");
                break;
            case R.id.color_blue:
                mTextViewColorText.setTextColor(Color.BLUE);
                mTextViewColorText.setText("Colr: blue");
                break;
            case R.id.menu_font_size_22:
                mTextViewSizeText.setTextSize(22);
                mTextViewSizeText.setText("Font size 22 pt");
                break;
            case R.id.menu_font_size_24:
                mTextViewSizeText.setTextSize(24);
                mTextViewSizeText.setText("Font size 24 pt");
                break;
            case R.id.menu_font_size_26:
                mTextViewSizeText.setTextSize(26);
                mTextViewSizeText.setText("Font size 26 pt");
                break;
        }
        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        switch (v.getId()) {
            case R.id.textViewColorText:
                inflater.inflate(R.menu.menu_color_choice, menu);
                break;
            case R.id.textViewSizeTExt:
                inflater.inflate(R.menu.menu_text_size, menu);
                break;
            default:
                break;
        }

    }
}
