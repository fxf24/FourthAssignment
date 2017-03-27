package com.example.qudqj_000.fourth_week_assignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    RelativeLayout r1;
    ImageView iv1;
    TextView t1;
    Bitmap bp1, bp2;
    int index = R.drawable.chicken;
    int count,original_w=1000, original_h=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        program();
    }

    void program(){
        r1 = (RelativeLayout)findViewById(R.id.background);
        iv1 = (ImageView)findViewById(R.id.food);
        t1 = (TextView)findViewById(R.id.description);

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
                rotateImage(iv1,index);
                break;
            case R.id.show_title:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                if(item.isChecked()) {
                    t1.setVisibility(View.VISIBLE);
                }
                else{
                    t1.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.larger_image:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                if(item.isChecked()){
                    imageSize(iv1, 2);
                }
                else{
                    imageSize(iv1, 1);
                }
                break;
            case R.id.chicken:
                item.setChecked(true);
                iv1.setImageResource(R.drawable.chicken);
                index = R.drawable.chicken;
                t1.setText("맛있는 치킨");
                break;
            case R.id.spaghetti:
                item.setChecked(true);
                iv1.setImageResource(R.drawable.spaghetti);
                index = R.drawable.spaghetti;
                t1.setText("맛있는 스파게티");
                break;
            case R.id.next_page:
                startActivity(new Intent(MenuActivity.this,CalcActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void rotateImage(ImageView imageView, int id){
        bp1 = BitmapFactory.decodeResource(getResources(), id);
        imageView.setImageBitmap(bp1);

        Matrix matrix = new Matrix();
        if(count ==0) {
            matrix.postRotate(30);
        }
        else{
            matrix.postRotate(0);
        }
        imageView.setImageMatrix(matrix);

        bp2 = Bitmap.createBitmap(bp1,0,0,bp1.getWidth(),bp1.getHeight(), matrix,false);
        imageView.setImageBitmap(bp2);
        count = (++count)%2;
    }

    void imageSize(ImageView imageView, int size){
        if(imageView.getWidth()>original_w){

        }
        else{
            original_w = imageView.getWidth();
            original_h = imageView.getHeight();
        }
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = original_w*size;
        params.height = original_h*size;

        imageView.setLayoutParams(params);
    }
}
