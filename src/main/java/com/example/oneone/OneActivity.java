package com.example.oneone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/* 로그인 성공 후 oneactivity.xml에서 적용되는 OneActivity.java
* */
public class OneActivity extends AppCompatActivity {
    Button btn_assignment,btn_diary,btn_wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oneactivity);

        btn_assignment = (Button)findViewById(R.id.btn_assignment);
        btn_diary = (Button)findViewById(R.id.btn_diary);
        btn_wifi = (Button)findViewById(R.id.btn_wifi);


        btn_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AssignmentActivity.class);
                startActivity(intent);
            }
        });

        btn_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DiaryActivity.class);
                startActivity(intent);
            }
        });
        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WifiActivity.class);
                startActivity(intent);
            }
        });




    }
}
