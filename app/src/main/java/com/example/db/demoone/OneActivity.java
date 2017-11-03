package com.example.db.demoone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OneActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_layout);

        Button button1= (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
//                    测试销毁活动，无条件退回,这里的销毁只是放弃当前活动，回退到上一个活动，没有上一个活动就回到主页面
                    public void onClick(View v) {
                        Toast.makeText(OneActivity.this,"You Clicked Button_1!",Toast.LENGTH_SHORT)
                                .show();
                        finish();
                    }
                }
        );
        Button button2= (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        测试活动跳转
                        Intent intent=new Intent(OneActivity.this,TwoActivity.class);
                        startActivity(intent);
                    }
                }
        );
        Button button3= (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
//                    测试隐式Intent
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.db.demoone.ACTION_START");
                        intent.addCategory("com.example.db.demoone.MY_GATEGORY");
                        startActivity(intent);

//                        Toast.makeText(OneActivity.this, "你点击了按钮三", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Button button4= (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(OneActivity.this,ThreeActivity.class);
                        startActivity(intent);
//                        Toast.makeText(OneActivity.this,"你点击了按钮4",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


}
