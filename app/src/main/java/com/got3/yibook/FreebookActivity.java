package com.got3.yibook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FreebookActivity extends AppCompatActivity{

    private Spinner bigSpinner = null;  //大分类
    private Spinner smallSpinner = null;     //细分类
    ArrayAdapter<String> bigAdapter = null;  //大分类适配器
    ArrayAdapter<String> smallAdapter = null;    //大分类适配器
    //大分类选项值
    private String[] bigstyle = new String[] {"公共课","学院"};//
    //细分类选项值
    private String[][] smallstyle = new String[][]
            {
                    { "文科类", "理科类", "公选课" },
                    { "美术", "心理", "计算机", "地理科学", "数学科学", "生命科学",
                            "旅游管理", "教育科学", "网络学院", "继续教育", "政治与行政", "外国语言文化", "教育信息技术"}
            };

    private Button search;

    String stringbig,stringsmall;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freebook);

        setSpinner();

        search = (Button) findViewById(R.id.fbb_select);

    }

   private void setSpinner()
    {
        bigSpinner = (Spinner)findViewById(R.id.fb_spinner);
        smallSpinner = (Spinner)findViewById(R.id.fb_spinner_style);

        //绑定适配器和值
        bigAdapter = new ArrayAdapter<String>(FreebookActivity.this,
                android.R.layout.simple_spinner_item, bigstyle);
        bigSpinner.setAdapter(bigAdapter);
        bigSpinner.setSelection(1,true);  //设置默认选中项，此处为默认选中第1个值

        smallAdapter = new ArrayAdapter<String>(FreebookActivity.this,
                android.R.layout.simple_spinner_item, smallstyle[1]);
        smallSpinner.setAdapter(smallAdapter);
        smallSpinner.setSelection(2,true);  //默认选中第2个

        //省级下拉框监听
      bigSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //position为当前选中的值的序号

                //将地级适配器的值改变为smallstyle[position]中的值
                smallAdapter = new ArrayAdapter<String>(
                        FreebookActivity.this, android.R.layout.simple_spinner_item, smallstyle[position]);
                // 设置二级下拉列表的选项内容适配器
                smallSpinner.setAdapter(smallAdapter);
                stringbig=bigSpinner.getSelectedItem().toString();
                stringsmall=smallSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

        });

    }

}