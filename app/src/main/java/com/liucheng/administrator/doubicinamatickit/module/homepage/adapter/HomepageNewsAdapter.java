package com.liucheng.administrator.doubicinamatickit.module.homepage.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/17 0017.
 */

public class HomepageNewsAdapter extends BaseQuickAdapter<MovieNews.NewsListBean,BaseViewHolder> {
    public HomepageNewsAdapter(int layoutResId, @Nullable List<MovieNews.NewsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieNews.NewsListBean item) {


        //设置图像
      Picasso.with(mContext).load(item.getImage()).placeholder(R.mipmap.ic_launcher).into((ImageView) helper.getView(R.id.iv_item_news_picture));
        //设置描述

        helper.setText(R.id.tv_item_news_describe,item.getTitle());

    }
}
