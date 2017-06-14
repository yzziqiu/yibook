package com.got3.yibook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText no, phone,pw,pw2;
    private Button btn_reg;
    private String noValue,phoneValue,pwValue,pw2Value;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //获得实例对象
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        no = (EditText) findViewById(R.id.ret_no);
        phone = (EditText) findViewById(R.id.ret_phone);
        pw = (EditText) findViewById(R.id.ret_pw);
        pw2 = (EditText) findViewById(R.id.ret_pw2);
        btn_reg = (Button) findViewById(R.id.button_register);

        // 注册监听事件
        btn_reg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                noValue = no.getText().toString();
                phoneValue = phone.getText().toString();
                pwValue = pw.getText().toString();
                pw2Value = pw2.getText().toString();

                if(pwValue.equals(pw2Value))
                {
                    Toast.makeText(RegisterActivity.this,"注册成功", Toast.LENGTH_SHORT).show();

                    //跳转界面
                    Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
                    RegisterActivity.this.startActivity(intent);
                    //finish();

                }else{
                    Toast.makeText(RegisterActivity.this,"两次密码输入不匹配，请重新输入", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
