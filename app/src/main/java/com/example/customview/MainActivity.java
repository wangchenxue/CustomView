package com.example.customview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main";
    private LinearLayout layout_one, layout_sec;
    private TextView view_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        layout_one = (LinearLayout) findViewById(R.id.activity_main);
        layout_sec = (LinearLayout) findViewById(R.id.layout_second);
        view_three = (TextView) findViewById(R.id.view_three);
        view_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        String str = new String("name");
        String str1 = new String("name");
        final  StringBuffer str2= new StringBuffer("1234");
        str2.append("1234");

        Log.i(TAG, "initView: "+(str==str1));
      layout_sec.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View view, MotionEvent motionEvent) {
              if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                  Log.i(TAG, "onTouch: getx :"+motionEvent.getX());
                  Log.i(TAG, "onTouch: getRawX :"+motionEvent.getRawX());
              }

              return false;
          }
      });
        view_three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Log.i(TAG, "view_three onTouch: getx :"+motionEvent.getX());//相对点所在本身的坐标系的x位置
                    Log.i(TAG, "view_three onTouch: getRawX :"+motionEvent.getRawX());//相对屏幕默认坐标系所在的位置
                }
                return true;
            }
        });
    }

    private void initData() {

        /**
         * getTop(),view的左上点距离父控件顶部的距离
         * getleft(),view的左上点距离父控件左侧的距离
         * getRight(),view的右下点距离父控件右侧的距离
         * getBottom(),view的右下点距离父控件顶部距离
         */
        //720*1280的手机测试，top：0，left：0，right：720，bottom：1280
        Log.i(TAG, "initData: one-top:" + layout_one.getTop());
        Log.i(TAG, "initData: one-left:" + layout_one.getLeft());
        Log.i(TAG, "initData: one-right:" + layout_one.getRight());
        Log.i(TAG, "initData: one-bottom:" + layout_one.getBottom());
        //720*1280的手机测试，top：100，left：100，right：620，bottom：1180
        Log.i(TAG, "initData: sec-top:" + layout_sec.getTop());
        Log.i(TAG, "initData: sec-left:" + layout_sec.getLeft());
        Log.i(TAG, "initData: sec-right:" + layout_sec.getRight());
        Log.i(TAG, "initData: sec-bottom:" + layout_sec.getBottom());

        Log.i(TAG, "initData: three-top:" + view_three.getTop());
        Log.i(TAG, "initData: three-left:" + view_three.getLeft());
        Log.i(TAG, "initData: three-right:" + view_three.getRight());
        Log.i(TAG, "initData: three-bottom:" + view_three.getBottom());

    }
}
