package com.example.dell.jingdongapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.dell.jingdongapp.R;

/**
 * Created by DELL on 2018/4/9.
 */

public class ZiDingYing extends RelativeLayout {
    final  int REQUEST_CODE = 8888;
    public ZiDingYing(Context context) {
        super(context,null);
    }

    public ZiDingYing(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public ZiDingYing(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view=View.inflate(context, R.layout.zidingyi,null);
    }

}
