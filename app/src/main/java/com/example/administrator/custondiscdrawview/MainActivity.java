package com.example.administrator.custondiscdrawview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private PieChat pieChat;
    private TextView textView;
    private int a=0;
    private int i;
    private int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChat= (PieChat) findViewById(R.id.piechat);
        textView= (TextView) findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {

            Random random=new Random();

            @Override
            public void onClick(View v) {
                boolean flag=true;
                while (flag) {
                    i = random.nextInt(5000);

                    if (i > 1000) {
                        flag = false;
                        i=i+j;
                    }
                }
                RotateAnimation rotateAnimation = new RotateAnimation(j,i, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(5000);
                AnimationSet set=new AnimationSet(true);
                set.setFillAfter(true);
                set.addAnimation(rotateAnimation);
                pieChat.startAnimation(set);

                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        a=360-(i-j-a)%360;
                        System.out.println("aaaa"+a);
                        if(a>=0&&a<=30){
                            Toast.makeText(MainActivity.this,"获得一等奖",Toast.LENGTH_SHORT).show();
                        }else if(a>30&&a<=90){
                            Toast.makeText(MainActivity.this,"获得二等奖",Toast.LENGTH_SHORT).show();
                        } else if(a>90&&a<=150){
                            Toast.makeText(MainActivity.this,"获得优胜奖",Toast.LENGTH_SHORT).show();
                        } else if(a>150&&a<=210){
                            Toast.makeText(MainActivity.this,"获得二等奖",Toast.LENGTH_SHORT).show();
                        } else if(a>210&&a<=270){
                            Toast.makeText(MainActivity.this,"获得三等奖",Toast.LENGTH_SHORT).show();
                        } else if(a>270&&a<=330){
                            Toast.makeText(MainActivity.this,"获得二等奖",Toast.LENGTH_SHORT).show();
                        } else if(a>330&&a<=360){
                            Toast.makeText(MainActivity.this,"获得一等奖",Toast.LENGTH_SHORT).show();
                        }

                        j=i;

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {


                    }
                });

            }
        });
    }

}

