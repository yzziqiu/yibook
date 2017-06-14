package com.got3.yibook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DonatebookActivity extends AppCompatActivity {

    private TextView recycling,Independent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatebook);

        //获得实例对象
        recycling = (TextView) findViewById(R.id.recycling);
        Independent = (TextView) findViewById(R.id.Independent);


        recycling.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent rIntent = new Intent(DonatebookActivity.this, RecyclingActivity.class);
                DonatebookActivity.this.startActivity(rIntent);
            }
        });
        Independent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent iIntent = new Intent(DonatebookActivity.this, IndependentActivity.class);
                DonatebookActivity.this.startActivity(iIntent);
            }
        });
    }
}

