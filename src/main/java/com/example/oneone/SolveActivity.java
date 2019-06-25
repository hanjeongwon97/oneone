package com.example.oneone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SolveActivity extends AppCompatActivity {

    TextView assignTitle_tv,solveProblem_tv,selectAnswer_tv,solveResult_tv,solveSample_tv;
    RadioGroup radioGroup;
    RadioButton rdobtn_one,rdobtn_two,rdobtn_three,rdobtn_four,rdobtn_five;
    Button gotoDiarybtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solve_a_question);
        setTitle("문제를 풀어보세요");

        Intent intent = getIntent();

        //한정원 : AssignmentActivity.java에서 가져온 것들
        String protitle = intent.getStringExtra("title");
        String proindex = intent.getStringExtra("Pindex");
        String prosolveIt = intent.getStringExtra("solveIt");
        String[] proselectAnswer = intent.getStringArrayExtra("selectAnswer");
        final String proanswer = intent.getStringExtra("answer");



        assignTitle_tv = (TextView)findViewById(R.id.assignTitle_tv);
        solveProblem_tv = (TextView)findViewById(R.id.solveProblem_tv);
        selectAnswer_tv = (TextView)findViewById(R.id.selectAnswer_tv);
        solveResult_tv = (TextView)findViewById(R.id.solveResult_tv);
        solveSample_tv = (TextView)findViewById(R.id.solveSample_tv);
        gotoDiarybtn = (Button)findViewById(R.id.gotoDiarybtn);

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        rdobtn_one = (RadioButton)findViewById(R.id.rdobtn_one);
        rdobtn_two = (RadioButton)findViewById(R.id.rdobtn_two);
        rdobtn_four = (RadioButton)findViewById(R.id.rdobtn_four);
        rdobtn_three = (RadioButton)findViewById(R.id.rdobtn_three);
        rdobtn_five = (RadioButton)findViewById(R.id.rdobtn_five);


        assignTitle_tv.setText(proindex+"번 문제 : "+protitle);
        solveProblem_tv.setText(prosolveIt);
        solveSample_tv.setText("(1) "+proselectAnswer[0]+"\n\n"+
                "(2) "+proselectAnswer[1]+"\n\n"+
                "(3) "+proselectAnswer[2]+"\n\n"+
                "(4) "+proselectAnswer[3]+"\n\n"+
                "(5) "+proselectAnswer[4]+"\n\n");

        //solveResult_tv.setText(proanswer+"입니다.");


        rdobtn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(proanswer.equals("1")) {
                    solveResult_tv.setText("채점결과 : 정답입니다.");
                    solveResult_tv.setTextColor(Color.BLUE);
                }

                else{
                    solveResult_tv.setText("채점결과 : 오답입니다.");
                    solveResult_tv.setTextColor(Color.RED);
                }
            }
        });
        rdobtn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(proanswer.equals("2")) {
                    solveResult_tv.setText("채점결과 : 정답입니다.");
                    solveResult_tv.setTextColor(Color.BLUE);
                }

                else{
                    solveResult_tv.setText("채점결과 : 오답입니다.");
                    solveResult_tv.setTextColor(Color.RED);
                }
            }
        });
        rdobtn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(proanswer.equals("3")) {
                    solveResult_tv.setText("채점결과 : 정답입니다.");
                    solveResult_tv.setTextColor(Color.BLUE);
                }

                else{
                    solveResult_tv.setText("채점결과 : 오답입니다.");
                    solveResult_tv.setTextColor(Color.RED);
                }
            }
        });
        rdobtn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(proanswer.equals("4")) {
                    solveResult_tv.setText("채점결과 : 정답입니다.");
                    solveResult_tv.setTextColor(Color.BLUE);
                }

                else{
                    solveResult_tv.setText("채점결과 : 오답입니다.");
                    solveResult_tv.setTextColor(Color.RED);
                }
            }
        });
        rdobtn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(proanswer.equals("5")) {
                    solveResult_tv.setText("채점결과 : 정답입니다.");
                    solveResult_tv.setTextColor(Color.BLUE);
                }

                else{
                    solveResult_tv.setText("채점결과 : 오답입니다.");
                    solveResult_tv.setTextColor(Color.RED);
                }
            }
        });

        gotoDiarybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DiaryActivity.class);
                startActivity(intent);
            }
        });



    }


}
