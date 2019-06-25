package com.example.oneone;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AssignmentActivity extends AppCompatActivity {

    ListView list;
    //String tag = "ONEONEONEONEONEONEONEONE";
   // static int selectItem=0;


    ArrayList<Problems>  problemsArrayList = new ArrayList<Problems>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_main);
        setTitle("문제를 선택해주세요");
        list = (ListView)findViewById(R.id.listview);


        //한정원 : 문제 답안 선택지 배열
        String Answer01 [] = {"자바는 절차 지향 언어이다","WORA(Write Once Run Anywhere) ","플랫폼 종속성","자바는 링크의 과정이 없다","클래스 이름과 소스파일의 이름이 일치한다"};
        String Answer02 [] = {"주석문은 행의 시작에 '//' 으로 작성한다","주석문은 프로그램의 실행에 영향을 미친다.","자바 프로그램의 가장 기본적이고 중요한 것은 클래스를 만드는 것이다"
                ,"모든 문장은 ';' 으로 끝나야 한다","클래스의 멤버 함수는 메소드라고 부른다"};
        String Answer03 [] = {"한글은 식별자로 사용할 수 없다","길이 제한이 있다","대소문자를 구별한다",
                "true,false,null은 식별자로 사용 가능하다","식별자의 첫번째 문자로 숫자를 사용 가능하다"};
        String Answer04 [] = {"var radius=10;","int radius=10","double radius=10;","int radius=10;","radius=10;"};
        String Answer05 [] = {"int b = (byte)n;","byte b = n;","byte b =n",
                "byte b = (byte)n","byte b = (byte)n;"};
        String Answer06 [] = {"0","1","2","3","4"};
        String Answer07 [] = {"3<5...true","1<=0...false","!(2<5)...true","1==7...false","1!=4...true"};
        String Answer08 [] = {"for(int i=0;;i++)","for(int i=0;i<10;i+=2)"
                ,"while(true)","for(int j=0;true;j++;)","for(int i=0;i>0;i++)"};
        String Answer09 [] = {"int a[10];","int b[] = new int[9];",
                "int c [];","int [] d;","e = new int[4]"};
        String Answer10 [] = {"int size = sizeof(array);","int size = array.length;","int size = length.array;"
                ,"int size = 3;","int size = length(array);"};
        String Answer11 [] = {"캡슐화","상속","C language","다형성","python"};
        String Answer12 [] = {"객체가 생성되는 순간에 자동으로 호출된다.","생성자는 오버로딩 할 수 있다.","생성자에 리턴 타입을 지정할 수 없다.",
                "생성자의 이름은 클래스이름과 일치할 수 없다.","생성자가 없는 클래스는 있을 수 없다."};
        String Answer13 [] = {"static 멤버는 객체를 생성하지 않고도 사용할 수 있는 멤버이다.",
                "static 멤버는 동일한 클래스의 모든 객체들이 공유한다.","static멤버는 클래스 멤버라고 불린다",
                "non-static 멤버는 인스턴스 멤버라고 부른다.","static 멤버는 객체가 생길 때 객체마다 생긴다."};
        String Answer14 [] = {"어쩌구이다.","저쩌구이다.","어쩌구저쩌구이다.","간장게장은 꿀맛이다.","모르겠다."};
        String Answer15 [] = {"final class Example{...}이면 Example을 상속할 수 있다.",
                "final로 메소드를 선언하면 오버라이딩 할 수 없는 메소드이다.","final int a = 10; 이면 a는 값을 변경 할 수 없다.",
                "final 키워드는 클래스,메소드,필드 총 3군데에서 사용된다.","final은 유용하게 사용된다."};
        String Answer16 [] = {"멤버의 중복 작성이 필요하여 클래스가 간결","클래스들의 계층적 분류가 가능","클래스 재사용과 확장 용이",
                "클래스의 유지 보수가 용이","객체 사이의 상속이 아니다."};
        String Answer17 [] = {"슈퍼 클래스 메소드 무시하기 혹은 덮어쓰기","정적 바인딩","슈퍼클래스와 서브 클래스의 메소드 사이에 발생하는 관계가 아님",
                "목적은 수퍼클래스의 메소드를 서브 클래스에서 그대로 사용하기 위함이다","super키워드는 사용할 수 없다."};



        problemsArrayList.add(new Problems("1","자바 언어의 이해",
                "다음 java에 대한 설명 중에서 틀린 선택지는 무엇인가?",Answer01,"1",
                R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("2","자바 프로그램의 구조",
                "다음 자바의 기본 구조에 대한 설명에서 틀린 선택지는 무엇인가?",Answer02,"2",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("3","식별자 이름 규칙",
                "다음 중 식별자(이름) 규칙이 옳은 것은?",Answer03,"3",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("4","변수 선언(1)",
                "radius 라는 이름의 정수 타입 변수 선언을 하려고 한다. 옳게 작성한 코드는 무엇인가",Answer04,"4",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("5","변수 선언(2)",
                "int n=300; 으로 변수 n에 300을 저장하였다. n값을 byte 변수 b에 저장하여라.",Answer05,"5",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("6","증감 연산",
                "int a = 1; \n a++;\n" +
                        "++a;\n 이 코드에서 a의 최종적인 값은 무엇인가",Answer06,"4",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("7","비교 연산과 논리 연산",
                "연산 결과가 틀린 것은?",Answer07,"3",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("8","반복문",
                "무한 반복(infinite loop)가 되지 않는 조건을 찾으시오.",Answer08,"2",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("9","배열(1)",
                "배열 선언이 옳지 않은 것은?",Answer09,"1",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("10","배열(2)",
                "int = array[];\n array = new int [5]; \n 일 때, int size = (array의 크기(길이)) 를 구하여라.",
                Answer10,"2",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("11","객체 지향 언어",
                "객체 지향 언어와 관련이 없는 것은?",Answer11,"3",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("12","클래스-생성자",
                "생성자는 객체가 생성 될 때 객체의 초기화를 위해 실행되는 메소드이다. 다음중 " +
                        "생성자에 대한 설명을 틀린 것은?",Answer12,"4",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("13","클래스-static",
                "static 에 대해 틀린 설명을 고르시오",Answer13,"5",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("14","어쩌구저쩌구",
                "어쩌구저쩌구는 어쩌구인가",Answer14,"4",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("15","클래스-final",
                "final 키워드의 쓰임이 틀린 것은?",Answer15,"1",R.drawable.oneone_pink));
        problemsArrayList.add(new Problems("16","상속",
                "상속의 장점과 특징이 아닌 것은",Answer16,"1",R.drawable.oneone_green));
        problemsArrayList.add(new Problems("17","메소드 오버라이딩",
                "메소드 오버라이딩에 대해 옳은 것은?",Answer17,"1",R.drawable.oneone_pink));


        MyAdapter adapter = new MyAdapter(
                getApplicationContext(),
                R.layout.row,
                problemsArrayList);

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),SolveActivity.class);

                intent.putExtra("title",problemsArrayList.get(position).title);
                intent.putExtra("Pindex",problemsArrayList.get(position).Pindex);
                intent.putExtra("solveIt",problemsArrayList.get(position).solveIt);
                intent.putExtra("selectAnswer",problemsArrayList.get(position).selectAnswer);
                intent.putExtra("answer",problemsArrayList.get(position).answer);


                startActivity(intent);


            }
        });


    }
}

class MyAdapter extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<Problems> al;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<Problems> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        return al.size();
    }
    @Override
    public Object getItem(int position) {

        return al.get(position);
    }
    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }

        //한정원 : row의 problemIndex ..
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView tvIndex = (TextView)convertView.findViewById(R.id.problemIndex);
        TextView tvTitle = (TextView)convertView.findViewById(R.id.problemTitle);

        Problems m = al.get(position);
        //iv.setImageResource(m.img);
        iv.setImageResource(m.img);
        tvIndex.setText(m.Pindex);
        tvTitle.setText(m.title);

        return convertView;

       // return null;
    }

}

class Problems{
    String Pindex = "";//한정원 : 문제번호
    String title = "";//한정원 : 문제제목
    String solveIt="";//한정원 : 문제 내용
    String selectAnswer [] = {"a","b","c","d","e"};
    String answer = "";
    int img;

    public Problems(String Pindex,String title,String solveIt,String sa[],String answer,int img){
        super();
        this.Pindex = Pindex;
        this.title = title;
        this.solveIt = solveIt;
        this.selectAnswer = sa;
        this.answer = answer;
        this.img = img;

    }
    public Problems(){};

}
