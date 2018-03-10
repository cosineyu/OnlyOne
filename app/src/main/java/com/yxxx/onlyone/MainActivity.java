package com.yxxx.onlyone;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private EditText daScores;
        private EditText xiaoScores;
        private EditText zhaoScores;
        private EditText yuScores;
        private ListView listViewScores;

        private ArrayList<OnlyOneBean> onlyOneList = new ArrayList<>();


        private OnlyOneAdapter onlyOneAdapter = new OnlyOneAdapter(this,onlyOneList);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //定义listView控件
        listViewScores = findViewById(R.id.lv_scores);
        //定义EditText控件
        daScores = findViewById(R.id.editText);
        xiaoScores = findViewById(R.id.editText2);
        zhaoScores = findViewById(R.id.editText3);
        yuScores = findViewById(R.id.editText4);
        //定义按键控件
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        //设置按钮监听
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //创建一个队列存储分值


        switch (v.getId()){

            case R.id.button:

                String daS = daScores.getText().toString();
                String xiaoS = xiaoScores.getText().toString();
                String zhaoS = zhaoScores.getText().toString();
                String yuS = yuScores.getText().toString();
                if (null == daS || "".equals(daS)||null == xiaoS || "".equals(xiaoS)||
                        null == zhaoS || "".equals(zhaoS)||null == yuS || "".equals(yuS)){
                    Toast.makeText(this,"填写错误",Toast.LENGTH_LONG).show();
                    break;
                }

                int daI= Integer.parseInt(daS);
                int xiaoI = Integer.parseInt(xiaoS);
                int zhaoI = Integer.parseInt(zhaoS);
                int yuI = Integer.parseInt(yuS);

                if (daI+xiaoI+zhaoI+yuI!= 0){
                    Toast.makeText(this,"填写错误",Toast.LENGTH_LONG).show();
                    break;
                }
                if (daI>0){
                    daI = 0-(xiaoI+zhaoI+yuI);
                }
                if (xiaoI>0){
                    xiaoI = 0-(daI+zhaoI+yuI);
                }
                if (zhaoI>0){
                    zhaoI = 0-(daI+xiaoI+yuI);
                }
                if (yuI>0){
                    yuI = 0-(daI+xiaoI+zhaoI);
                }

                OnlyOneBean onlyOneBean = new OnlyOneBean();
                onlyOneBean.da = daS;
                onlyOneBean.xiao = xiaoS;
                onlyOneBean.zhao = zhaoS;
                onlyOneBean.yu = yuS;
                onlyOneList.add(onlyOneBean);
                Toast.makeText(this,"添加成功",Toast.LENGTH_LONG).show();

                listViewScores.setAdapter(onlyOneAdapter);

                daScores.setText("");
                xiaoScores.setText("");
                zhaoScores.setText("");
                yuScores.setText("");

                break;
                // Integer das = new Integer(daScores.getText().toString());
               // Integer xiaos = new Integer(xiaoScores.getText().toString());
                // Integer zhaos = new Integer(zhaoScores.getText().toString());
                //Integer yus = new Integer(yuScores.getText().toString());


            case R.id.button2:

                int dasum = 0;
                int xiaosum = 0;
                int zhaosum = 0;
                int yusum = 0;
                for (int i = 0; i < onlyOneList.size(); i++) {

                    dasum = dasum + Integer.parseInt(onlyOneList.get(i).da);
                    xiaosum = xiaosum + Integer.parseInt(onlyOneList.get(i).xiao);
                    zhaosum = zhaosum + Integer.parseInt(onlyOneList.get(i).zhao);
                    yusum = yusum + Integer.parseInt(onlyOneList.get(i).yu);

                }
//                onlyOneList.clear();
//                OnlyOneBean onlyOneBean2 = new OnlyOneBean();
//                onlyOneBean2.da = Integer.toString(dasum);
//                onlyOneBean2.xiao = Integer.toString(xiaosum);
//                onlyOneBean2.zhao = Integer.toString(zhaosum);
//                onlyOneBean2.yu = Integer.toString(yusum);
//                onlyOneList.add(onlyOneBean2);
//                //onlyOneList.add(onlyOneBean2);Toast.makeText(this,Integer.toString(dasum)+"添加成功",Toast.LENGTH_LONG).show();
//
//                listViewScores.setAdapter(onlyOneAdapter);



                //新建一个列表存储每个人的总成绩
                ArrayList<ScoresList> scoresLists = new ArrayList<>();

                ScoresList scoresList = new ScoresList();
                scoresList.name ="大王";
                scoresList.sumscores =dasum;
                scoresLists.add(scoresList);

                ScoresList scoresList1 = new ScoresList();
                scoresList1.name ="小王";
                scoresList1.sumscores = xiaosum;
                scoresLists.add(scoresList1);

                ScoresList scoresList2 = new ScoresList();
                scoresList2.name ="赵";
                scoresList2.sumscores =zhaosum;
                scoresLists.add(scoresList2);

                ScoresList scoresList3 = new ScoresList();
                scoresList3.name ="余";
                scoresList3.sumscores = yusum;
                scoresLists.add(scoresList3);

                MyListComparator mc =new MyListComparator();
                Collections.sort(scoresLists,mc);


                if (scoresLists.get(0).getSumscores()>9){
                    if(scoresLists.get(3).getSumscores()<-9){
                        scoresLists.get(0).setSumscores((scoresLists.get(0).getSumscores()-10));
                        scoresLists.get(3).setSumscores((scoresLists.get(3).getSumscores()+10));
                        String ts = scoresLists.get(3).getName()+"给"+scoresLists.get(0).getName()+"一张";
                        Toast.makeText(this,ts,Toast.LENGTH_LONG).show();
                        onlyOneList.clear();
                        OnlyOneBean onlyOneBean2 = new OnlyOneBean();

                        for (int i = 0; i < scoresLists.size(); i++) {

                            String name = scoresLists.get(i).getName();

                            switch (name){

                                case "大王":

                                onlyOneBean2.da = Integer.toString(scoresLists.get(i).getSumscores());

                                break;

                                case "小王":

                                onlyOneBean2.xiao = Integer.toString(scoresLists.get(i).getSumscores());

                                break;

                                case "赵":
                                    onlyOneBean2.zhao = Integer.toString(scoresLists.get(i).getSumscores());

                                    break;

                                case "余":

                                    onlyOneBean2.yu = Integer.toString(scoresLists.get(i).getSumscores());

                                    break;

                                default:
                                    break;



                            }
                        }

                        onlyOneList.add(onlyOneBean2);
//                //onlyOneList.add(onlyOneBean2);Toast.makeText(this,Integer.toString(dasum)+"添加成功",Toast.LENGTH_LONG).show();
//
                        listViewScores.setAdapter(onlyOneAdapter);


                    }
                }

//                for (int i = 0; i <scoresLists.size() ; i++) {
//
//                    ScoresList scoresList4 = scoresLists.get(i);
//
//                    System.out.println(scoresList4.getSumscores());
//
//                }












                break;

            default:
                break;




        }



    }
}
