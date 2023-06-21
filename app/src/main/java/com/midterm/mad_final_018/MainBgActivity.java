package com.midterm.mad_final_018;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainBgActivity extends AppCompatActivity {

    private EditText editText;
    private float offsetX;
    private float offsetY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bg);
        editText = findViewById(R.id.editText);
        registerForContextMenu(editText);

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getRawX();
                float y = event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        offsetX = x - v.getX();
                        offsetY = y - v.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        v.setX(x - offsetX);
                        v.setY(y - offsetY);
                        break;
                }
                return false;
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(editText);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        EditText Text = findViewById(R.id.editText);
        switch (item.getItemId()) {
            case R.id.change_color:
                 Text.setTextColor(Color.RED);
                return true;
            case R.id.change_size:
                 Text.setTextSize(40);
                return true;
            case R.id.change_style_bold:
                Text.setTypeface(null, Typeface.BOLD);
                return true;
            case R.id.change_style_italic:
                Text.setTypeface(null, Typeface.ITALIC);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}