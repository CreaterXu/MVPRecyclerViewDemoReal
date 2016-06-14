package com.example.administrator.test;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import imsdk.data.IMMyself;
import imsdk.data.IMSDK;

public class MainActivity extends AppCompatActivity {
    private  TextInputLayout textInputLayout;
    private TextInputEditText inputEditText;
    private Fragment fragment;
    private Button okButton;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        okButton=(Button)findViewById(R.id.okbtn);
        textInputLayout=(TextInputLayout)findViewById(R.id.input_layout);
        inputEditText=(TextInputEditText) findViewById(R.id.userid);
        fragment=new MessageFragment();
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid=inputEditText.getText().toString();
                // 初始化IMSDK
                // 在Application类onCreate()方法中，设置applicationContext和appKey
                IMSDK.init(getApplicationContext(), "00b6413a92d4c1c84ad99e0a");
                //在具体Activity类中，执行如下代码：
                // 设置本用户的用户名
                IMMyself.setCustomUserID("im@imsdk.im");
                // 设置本用户密码
                IMMyself.setPassword("impasswordforim");
                // 一键登录
                IMMyself.login(false, 5, null);
                // 发送文本消息
                IMMyself.sendText("Hello!", "lyc@imsdk.im", 5, null);
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
