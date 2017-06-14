package com.got3.yibook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user, password;
    private Button btn_login;
    private TextView register;
    private String userValue,passwordValue;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //获得实例对象
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        user = (EditText) findViewById(R.id.let_no);
        password = (EditText) findViewById(R.id.let_pw);
        btn_login = (Button) findViewById(R.id.lb_login);
        register = (TextView) findViewById(R.id.ltv_register);

        if(sp.getBoolean("ISCHECK", false))
        {
            //设置记住密码状态
            user.setText(sp.getString("USER_NO", ""));
            password.setText(sp.getString("PASSWORD", ""));
            //判断自动登陆多选框状态
           // if(sp.getBoolean("AUTO_ISCHECK", false))
           // {
                //跳转界面
            //    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            //    LoginActivity.this.startActivity(intent);
           // }
        }

        // 登录监听事件  现在默认为用户名为：123 密码：123
        btn_login.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                userValue = user.getText().toString();
                passwordValue = password.getText().toString();

                if(userValue.equals("123")&&passwordValue.equals("123"))
                {
                    Toast.makeText(LoginActivity.this,"登录成功", Toast.LENGTH_SHORT).show();

                        //记住用户名、密码、
                        Editor editor = sp.edit();
                        editor.putString("USER_NAME", userValue);
                        editor.putString("PASSWORD",passwordValue);
                        editor.commit();

                    //跳转界面
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    LoginActivity.this.startActivity(intent);
                    //finish();

                }else{

                    Toast.makeText(LoginActivity.this,"用户名或密码错误，请重新登录", Toast.LENGTH_LONG).show();
                }

            }
        });
        register.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent raIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(raIntent);
            }
        });
    };

}
