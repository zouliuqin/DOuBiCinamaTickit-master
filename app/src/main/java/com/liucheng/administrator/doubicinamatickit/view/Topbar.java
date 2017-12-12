package com.liucheng.administrator.doubicinamatickit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class Topbar extends RelativeLayout {
    //声明要自定义的控件
    private Button leftButton, rightButton;
    private TextView tvTitle;
    private LayoutParams leftParams,rightParams,titleParams;
    


    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;
    private float leftTextSize;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;
    private float rightTextSize;

    private float titleTextSize;
    private int titleTextColor;
    private String title;


    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
        leftTextColor = typedArray.getColor(R.styleable.Topbar_leftTextColor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = typedArray.getString(R.styleable.Topbar_leftText);
        leftTextSize = typedArray.getFloat(R.styleable.Topbar_leftTextSize, 0);

        rightTextColor = typedArray.getColor(R.styleable.Topbar_rightTextColor, 0);
        rightBackground = typedArray.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = typedArray.getString(R.styleable.Topbar_rightText);
        rightTextSize = typedArray.getFloat(R.styleable.Topbar_rightTextSize, 0);

        titleTextSize = typedArray.getFloat(R.styleable.Topbar_titleTextSize, 0);
        titleTextColor = typedArray.getInt(R.styleable.Topbar_titleTextColor, 0);
        title = typedArray.getString(R.styleable.Topbar_title);


        typedArray.recycle();

        //实例化控件
        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);
        leftButton.setTextSize(leftTextSize);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);
        rightButton.setTextSize(rightTextSize);

        tvTitle.setText(title);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setGravity(Gravity.CENTER);


        setBackgroundColor(0xFFF59563);
        
        
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftButton,leftParams);


        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tvTitle,titleParams);

    }
}
