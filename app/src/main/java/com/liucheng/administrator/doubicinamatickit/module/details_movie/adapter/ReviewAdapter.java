package com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.DateUtils;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Review;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public class ReviewAdapter extends BaseQuickAdapter<Review.DataBean.MiniBean.ListBean,BaseViewHolder> {


    public ReviewAdapter(int layoutResId, @Nullable List<Review.DataBean.MiniBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Review.DataBean.MiniBean.ListBean item) {
        Picasso.with(mContext).load(item.getHeadImg()).placeholder(R.drawable.logo).into((ImageView)
                helper.getView(R.id.user_imageIt));
        helper.setText(R.id.text_movieTitleIt,item.getNickname()+"");
        helper.setText(R.id.review_contentIt,item.getContent()+"");
        String date =  DateUtils.timet(item.getCommentDate()+"");
        helper.setText(R.id.review_dateIt,date+"");
        helper.setText(R.id.review_gradeIt, item.getRating()+"");

    }
}
