package com.example.qudqj_000.fourth_week_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("4주차 실습");

        program();
    }

    void program(){
        b1 = (Button)findViewById(R.id.first_assignment);
        b2 = (Button)findViewById(R.id.second_assignment);
    }

    public void OnClick(View v){
        switch (v.getId()){
            case R.id.first_assignment:
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
                break;
            case R.id.second_assignment:
                startActivity(new Intent(MainActivity.this, CalcActivity.class));
                break;
        }
    }
}
