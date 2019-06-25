package com.example.oneone;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DiaryActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText edtDiary;
    TextView tvyear,tvmonth,tvday;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main);
        setTitle("다이어리");

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        edtDiary = (EditText)findViewById(R.id.edtDiary);
        tvyear = (TextView)findViewById(R.id.tvYear);
        tvmonth = (TextView)findViewById(R.id.tvMonth);
        tvday = (TextView)findViewById(R.id.tvDay);
        btnSave = (Button)findViewById(R.id.btnSave);

        int cYear = datePicker.getYear();
        int cMonth = datePicker.getMonth();
        int cDay = datePicker.getDayOfMonth();


        datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int dmonth = monthOfYear +1;
                String fileName = "oneone_"+year+"_"+dmonth+"_"+dayOfMonth+".txt";
                String msg = readDiary(fileName);
                edtDiary.setText(msg);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String year = Integer.toString(datePicker.getYear());
                    String month = Integer.toString(datePicker.getMonth() + 1);
                    String day = Integer.toString(datePicker.getDayOfMonth());
                    tvyear.setText(year);
                    tvmonth.setText(month);
                    tvday.setText(day);
                    String fileName = "oneone_"+year + "_" + month + "_" + day + ".txt";
                    FileOutputStream outFs = openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                    String msg = edtDiary.getText().toString();
                    outFs.write(msg.getBytes());
                    outFs.close();
                }catch(IOException e){ }
            }
        });

    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnSave.setText("수정 하기");
        } catch (IOException e) {
            edtDiary.setHint("일기 없음");
            btnSave.setText("저장");
        }return diaryStr;
    }}
