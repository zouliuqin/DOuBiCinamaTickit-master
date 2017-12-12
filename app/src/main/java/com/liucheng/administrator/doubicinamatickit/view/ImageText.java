package com.liucheng.administrator.doubicinamatickit.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.module.cityselector.CityActivity;
import com.liucheng.administrator.doubicinamatickit.ui.MainActivity;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class ImageText extends LinearLayout {
    private Context context;
    private Drawable viewImage;
    private String viewText;
    private int viewTextColor;
    private float viewTextSize;
    private OnImageWithTextViewClickListener onImageWithTextViewClickListener;


    public ImageText(Context context) {
        this(context, null);
    }












    public ImageText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageWithTextView);
        viewImage = typedArray.getDrawable(R.styleable.ImageWithTextView_view_image);
        viewText = typedArray.getString(R.styleable.ImageWithTextView_view_text);
        viewTextColor = typedArray.getColor(R.styleable.ImageWithTextView_view_text_color, 0);
        viewTextSize = typedArray.getDimension(R.styleable.ImageWithTextView_view_text_size, 16);
        initView();
        typedArray.recycle();
    }
    private void initView() {
        final View view = LayoutInflater.from(context).inflate(R.layout.imageview_text, this, true);
        LinearLayout lv = (LinearLayout) view.findViewById(R.id.linearlayout_view_image_with_text);
        final ImageView iv = (ImageView) view.findViewById(R.id.imageview_view_image_with_text);
        TextView tv = (TextView) view.findViewById(R.id.textview_view_image_with_text);
        iv.setImageDrawable(viewImage);
        tv.setText(viewText);
        tv.setTextColor(viewTextColor);
        tv.setTextSize(viewTextSize);
        lv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "dsafdddfafd", Toast.LENGTH_SHORT).show();
               context.startActivity(new Intent(getContext(),CityActivity.class));

            }
        });
    }


    /**
     * 设置OnImageWithTextViewClickListener回调
     *
     * @param onImageWithTextViewClickListener:OnImageWithTextViewClickListener
     */
    public void setOnImageWithTextViewClickListener(OnImageWithTextViewClickListener onImageWithTextViewClickListener) {
        this.onImageWithTextViewClickListener = onImageWithTextViewClickListener;
    }
    public interface OnImageWithTextViewClickListener {

        /**
         * 单击View
         */
       public void onViewClick(View view);

    }

}
