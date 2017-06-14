package com.got3.yibook;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FreebmessageActivity extends ListActivity {

    private TextView want;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freebmessage);

        want=  (TextView) findViewById(R.id.fbmtv_select);
        want.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sIntent = new Intent(FreebmessageActivity.this, WantfreebookActivity.class);
                FreebmessageActivity.this.startActivity(sIntent);
            }
        });
    }


}
