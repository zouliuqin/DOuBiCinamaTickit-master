package com.liucheng.administrator.doubicinamatickit.module.homepage.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/17 0017.
 */

public class HomepageNewsAdapter extends BaseQuickAdapter<MovieNews.DataBeanX.DataBean, BaseViewHolder> {
    public HomepageNewsAdapter(int layoutResId, @Nullable List<MovieNews.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieNews.DataBeanX.DataBean item) {


        Log.i(TAG, "convert: " + item.getImg1());

        if (!item.getImg1().equals("")) {
            //设置图像
            Picasso.with(mContext).load(item.getImg1()).placeholder(R.mipmap.ic_launcher).transform(new CropSquareTransformation())
                    .noFade().into((ImageView) helper.getView(R.id.iv_item_news_picture));
        }

        //设置描述

        helper.setText(R.id.tv_item_news_describe, item.getTitle());

    }
}
