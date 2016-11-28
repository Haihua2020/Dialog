package com.example.zhanghaihua.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHelper.showConfirmDialog(MainActivity.this,
                        "提示",//这个是title
                        "确认退出吗？",//这个是message
                        "确认"//这个是确认按钮
                        , "取消",//这个是取消按钮
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //这是确认按钮点击事件
                                arg0.dismiss();

                            }
                        }, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //这是取消按钮点击事件
                                arg0.dismiss();
                            }
                        }, null, null, false, true, 0);
            }
        });
    }
    }

