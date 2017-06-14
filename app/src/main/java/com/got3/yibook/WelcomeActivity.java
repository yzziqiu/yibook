package com.got3.yibook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Intent intent = new Intent();
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                intent.setClass(WelcomeActivity.this,MainActivity.class);
                WelcomeActivity.this.startActivity(intent);
            }
        };
        timer.schedule(task,1000*5);
    }

}
