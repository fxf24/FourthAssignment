package com.example.qudqj_000.fourth_week_assignment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MenuActivity extends AppCompatActivity {
    RelativeLayout r1;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        program();
    }

    void program(){
        r1 = (RelativeLayout)findViewById(R.id.background);
        iv1 = (ImageView)findViewById(R.id.imageView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuRed:
                r1.setBackgroundColor(Color.RED);
                break;
            case R.id.menuBlue:
                r1.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuYellow:
                r1.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.turn_30degree:
                break;
            case R.id.show_title:
                break;
            case R.id.larger_image:
                break;
            case R.id.chicken:

                break;
            case R.id.spaghetti:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
