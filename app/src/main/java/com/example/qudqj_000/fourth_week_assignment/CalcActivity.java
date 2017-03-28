package com.example.qudqj_000.fourth_week_assignment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {
    TabHost tabHost;
    Button b1, b2, b3;
    EditText e1, e2, e3;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setTitle("각종 계산기");

        program();
    }

    void program(){
        tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("a").setContent(R.id.tab1).setIndicator("BMI계산기"));
        tabHost.addTab(tabHost.newTabSpec("b").setContent(R.id.tab2).setIndicator("면적계산기"));

        b1 = (Button)findViewById(R.id.bmiCalc);
        b2 = (Button)findViewById(R.id.p_to_m);
        b3 = (Button)findViewById(R.id.m_to_p);

        e1 = (EditText)findViewById(R.id.height);
        e2 = (EditText)findViewById(R.id.weight);
        e3 = (EditText)findViewById(R.id.m_or_p);

        t1 = (TextView)findViewById(R.id.result1);
        t2 = (TextView)findViewById(R.id.result2);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.bmiCalc:
                calcBMI();
                break;
            case R.id.p_to_m:
                calcP_to_M();
                break;
            case R.id.m_to_p:
                calcM_to_P();
                break;
        }
    }

    void calcBMI(){
        String height = e1.getText().toString();
        String weight = e2.getText().toString();

        Double h = Double.parseDouble(height);
        Double w = Double.parseDouble(weight);

        h = h/100;
        Double bmi = w/(h*h);
        if(bmi>=25.0){
            t1.setText("비만입니다!!!");
            t1.setTextColor(Color.RED);
        }
        else if(bmi>=23.0){
            t1.setText("과체중입니다!!!");
            t1.setTextColor(Color.rgb(230,94,0));
        }
        else if(bmi>=18.5){
            t1.setText("정상입니다.");
            t1.setTextColor(Color.BLACK);
        }
        else{
            t1.setText("저체중입니다!!!");
            t1.setTextColor(Color.GRAY);
        }
    }

    void calcP_to_M(){
        String pyoung = e3.getText().toString();

        Double p = Double.parseDouble(pyoung)*3.305;

        t2.setText(p+"제곱미터");
    }

    void calcM_to_P(){
        String meter = e3.getText().toString();

        Double m = Double.parseDouble(meter)*0.3025;

        t2.setText(m+"평");
    }
}
