package com.liucheng.administrator.doubicinamatickit.module.find.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 */

public class NewsAdapter extends BaseAdapter<MovieNews.NewsListBean> {
    List<MovieNews.NewsListBean> data =new ArrayList<>();
    public NewsAdapter(Context context, List<MovieNews.NewsListBean> data) {

        super(context, data);
        this.data=data;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MovieNews.NewsListBean news = getData().get(i+4);
        ViewHolder holer = null;
        if (null == view) {
            holer = new ViewHolder();
            view = getLayoutInflater().inflate(R.layout.item_news, null);
            holer.ivItemNewsPicture = view.findViewById(R.id.iv_item_news_picture);
            holer.tvItemNewsDescribe = view.findViewById(R.id.tv_item_news_describe);
            view.setTag(holer);
        } else {
            holer = (ViewHolder) view.getTag();
        }
        //设置图像
        Picasso.with(getContext()).load(news.getImage()).placeholder(R.mipmap.ic_launcher).into(holer.ivItemNewsPicture);
        //设置描述
        holer.tvItemNewsDescribe.setText(news.getTitle());
        return view;

    }


    class ViewHolder {
        /**
         * 新闻图片
         */
        ImageView ivItemNewsPicture;

        /**
         * 新闻描述
         */
        TextView tvItemNewsDescribe;

    }

    //由于滚动栏 用了4条数据，所以从中去除
    @Override
    public int getCount() {
        return data.size()-4;
    }
}
