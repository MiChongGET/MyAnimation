package com.example.administrator.myanimation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2016/10/9.
 */

public class MyAnimation extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
       //t.setAlpha(interpolatedTime);
        //设置界面抖动
        t.getMatrix().setTranslate((float)(Math.sin(interpolatedTime*15)*50),(float)(Math.sin(interpolatedTime*15)*50));
        super.applyTransformation(interpolatedTime, t);

    }
}
