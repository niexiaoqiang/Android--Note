package com.example.albert.intenttest;

import android.animation.ObjectAnimator;
import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button click;
    ImageView imageView;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.click);
        click.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.image);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.click:
                Intent intent = new Intent();
                intent.setAction("com.example.albert.launchmodetest");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.start:
//                ObjectAnimator.ofFloat(imageView,"rotationY",0.0f,90.0f)
//                        .setDuration(500)
//                        .start();
                startAnimation();
                break;
        }
    }

    private void  startAnimation(){
        //创建一个AnimationSet对象，参数为Boolean型，
        //true表示使用Animation的interpolator，false则是使用自己的
        AnimationSet animationSet = new AnimationSet(true);

        //创建一个AlphaAnimation对象，参数从完全的透明度，到完全的不透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        //设置动画执行的时间
        alphaAnimation.setDuration(500);
        //alphaAnimation.setDuration(long durationMills)
        //设置动画持续时间（单位：毫秒）
        //alphaAnimation.setFillAfter(Boolean fillAfter)
        //如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
        //alphaAnimation.setFillBefore(Boolean fillBefore)
        //如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
        //alphaAnimation.setStartOffSet(long startOffSet)
        //设置动画执行之前的等待时间
        //alphaAnimation.setRepeatCount(int repeatCount)
        //设置动画重复执行的次数

        //参数1：从哪个旋转角度开始
        //参数2：转到什么角度
        //后4个参数用于设置围绕着旋转的圆的圆心在哪里
        //参数3：确定x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
        //参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        //参数5：确定y轴坐标的类型
        //参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,1f);
        rotateAnimation.setDuration(500);

        //参数1：x轴的初始值
        //参数2：x轴收缩后的值
        //参数3：y轴的初始值
        //参数4：y轴收缩后的值
        //参数5：确定x轴坐标的类型
        //参数6：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        //参数7：确定y轴坐标的类型
        //参数8：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f,0,1f,Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,1f);
        scaleAnimation.setDuration(500);

        //参数1～2：x轴的开始位置
        //参数3～4：y轴的开始位置
        //参数5～6：x轴的结束位置
        //参数7～8：x轴的结束位置
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,1f);
        translateAnimation.setDuration(500);

        //将alphaAnimation对象添加到AnimationSet当中
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);

        //使用ImageView的startAnimation方法执行动画
        imageView.startAnimation(animationSet);
    }
}
