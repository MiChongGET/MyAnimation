package com.example.administrator.myanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private RotateAnimation mRotateAnimation;
    private Button rotate_btn;
    private RelativeLayout main;
    private Button translate;
    private TranslateAnimation tl ;
    private Button scale;
    private ScaleAnimation mScaleAnimation;
    private AnimationSet mAnimationSet;
    private Button total;
    private MyAnimation ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAnimationSet = new AnimationSet(true);
        mAnimationSet.setDuration(1000);

        //透明
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
                //设定时间
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);
                //startActivity(new Intent(MainActivity.this,Main2Activity.class));
                //设置翻页效果，此处无效果
                overridePendingTransition(0,0);
            }
        });

        main = (RelativeLayout) findViewById(R.id.activity_main);

        //旋转
        rotate_btn = (Button) findViewById(R.id.btn_rotate);
        mRotateAnimation = new RotateAnimation(0,720, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateAnimation.setDuration(1000);
        //往综合控件添加效果
        mAnimationSet.addAnimation(mRotateAnimation);
        rotate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(mRotateAnimation);
                //main.startAnimation(mRotateAnimation);
                    v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.ai));

            }
        });


        //平移
        tl = new TranslateAnimation(0,200,0,200);
        tl.setDuration(1000);
        translate = (Button) findViewById(R.id.button3);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(tl);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));
            }
        });


        //缩放

        scale = (Button) findViewById(R.id.button4);
        mScaleAnimation = new ScaleAnimation(1,0,1,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mScaleAnimation.setDuration(1000);

        //往综合控件添加效果
        mAnimationSet.addAnimation(mScaleAnimation);

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scale.startAnimation(mScaleAnimation);
                //隐藏按钮控件
                scale.setVisibility(View.INVISIBLE);
            }
        });

        total = (Button) findViewById(R.id.button5);
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.startAnimation(mAnimationSet);

                //使用xml文件
                //v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.total));

                //效果监听
                Animation a = AnimationUtils.loadAnimation(MainActivity.this,R.anim.total);
                a.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this,"哈哈，控件消失啦！！！",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });

                v.startAnimation(a);
                total.setVisibility(View.INVISIBLE);

            }
        });

        //自定义的界面抖动
        ma= new MyAnimation();
        ma.setDuration(1000);
        Button b = (Button) findViewById(R.id.button6);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.startAnimation(ma);
            }
        });
    }
}
