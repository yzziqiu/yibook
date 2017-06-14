package com.got3.yibook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity{

    private TextView selectbook,donbook,sellbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //获得实例对象
        selectbook = (TextView) findViewById(R.id.hometv_selectbook);
        donbook = (TextView) findViewById(R.id.hometv_donbook);
        sellbook = (TextView) findViewById(R.id.hometv_sellbook);

        selectbook.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              Intent sIntent = new Intent(HomeActivity.this, FreebookActivity.class);
                                              HomeActivity.this.startActivity(sIntent);
                                          }
                                      });
        donbook.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                Intent dIntent = new Intent(HomeActivity.this, DonatebookActivity.class);
                                                HomeActivity.this.startActivity(dIntent);
                                            }
                                        });
        sellbook.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                Intent seIntent = new Intent(HomeActivity.this,TradebookActivity.class);
                                                HomeActivity.this.startActivity(seIntent);
                                            }
                                        });

        }

}
