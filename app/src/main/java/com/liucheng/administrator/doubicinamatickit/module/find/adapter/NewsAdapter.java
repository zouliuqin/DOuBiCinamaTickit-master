package com.liucheng.administrator.doubicinamatickit.module.find.adapter;

import android.content.Context;
import android.media.tv.TvContract;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 */

public class NewsAdapter extends BaseQuickAdapter<MovieNews.DataBeanX.DataBean,BaseViewHolder> {
    public NewsAdapter(int layoutResId, @Nullable List<MovieNews.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieNews.DataBeanX.DataBean item) {
        Picasso.with(mContext).load(item.getImg1()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into((ImageView) helper.getView(R.id.iv_item_news_picture));
        helper.setText(R.id.tv_item_news_describe,item.getTitle());
    }
//    List<MovieNews.DataBeanX.DataBean> data =new ArrayList<>();
//    public NewsAdapter(Context context, List<MovieNews.DataBeanX.DataBean> data) {
//
//        super(context, data);
//        this.data=data;
//    }
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        MovieNews.DataBeanX.DataBean news = getData().get(i+4);
//        ViewHolder holer = null;
//        if (null == view) {
//            holer = new ViewHolder();
//            view = getLayoutInflater().inflate(R.layout.item_news, null);
//            holer.ivItemNewsPicture = view.findViewById(R.id.iv_item_news_picture);
//            holer.tvItemNewsDescribe = view.findViewById(R.id.tv_item_news_describe);
//            view.setTag(holer);
//        } else {
//            holer = (ViewHolder) view.getTag();
//        }
//        //设置图像
//        Picasso.with(getContext()).load(news.getImg1()).placeholder(R.drawable.logo).into(holer.ivItemNewsPicture);
//        //设置描述
//        holer.tvItemNewsDescribe.setText(news.getTitle());
//        return view;
//
//    }
//
//
//    class ViewHolder {
//        /**
//         * 新闻图片
//         */
//        ImageView ivItemNewsPicture;
//
//        /**
//         * 新闻描述
//         */
//        TextView tvItemNewsDescribe;
//
//    }
//
//    //由于滚动栏 用了4条数据，所以从中去除
//    @Override
//    public int getCount() {
//        return data.size()-4;
//    }
}
