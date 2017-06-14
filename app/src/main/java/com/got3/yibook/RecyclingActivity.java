package com.got3.yibook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class RecyclingActivity extends AppCompatActivity {

    private Button submit,cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling);

        //获得实例对象
        submit = (Button) findViewById(R.id.reb_submit);
        cancle = (Button) findViewById(R.id.reb_can);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            //    Intent sIntent = new Intent(RecyclingActivity.this, DonatebookActivity.class);
           //     RecyclingActivity.this.startActivity(sIntent);
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cIntent = new Intent(RecyclingActivity.this, DonatebookActivity.class);
                RecyclingActivity.this.startActivity(cIntent);
            }
        });
    }



}
