package com.got3.yibook;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private RelativeLayout selectbook, donbook, sellbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得实例对象
        selectbook = (RelativeLayout) findViewById(R.id.mainrl_selectbook);
        donbook = (RelativeLayout) findViewById(R.id.mainrl_donbook);
        sellbook = (RelativeLayout) findViewById(R.id.mainrl_sellbook);

        selectbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sIntent = new Intent(MainActivity.this, FreebookActivity.class);
                MainActivity.this.startActivity(sIntent);
            }
        });
        donbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent dIntent = new Intent(MainActivity.this, DonatebookActivity.class);
                MainActivity.this.startActivity(dIntent);
            }
        });
        sellbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //     Intent seIntent = new Intent(MainActivity.this,TradebookActivity.class);
                //      MainActivity.this.startActivity(seIntent);
                Toast.makeText(MainActivity.this, "即将推出，敬请期待", Toast.LENGTH_LONG).show();
            }
        });

    }
}

