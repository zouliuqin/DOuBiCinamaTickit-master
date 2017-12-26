package com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter;

import android.animation.Animator;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.entity.DateUtils;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.AllReview;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18 0018.
 */

public class AllReviewAdapter extends BaseQuickAdapter<AllReview.DataBean.CtsBean,BaseViewHolder> {
    public AllReviewAdapter(int layoutResId, @Nullable List<AllReview.DataBean.CtsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AllReview.DataBean.CtsBean item) {
        Picasso.with(mContext).load(item.getCaimg()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into((ImageView)
                helper.getView(R.id.user_image));
        helper.setText(R.id.text_movieTitle,item.getCa()+"");
        helper.setText(R.id.review_content,item.getCe()+"");
        String date =  DateUtils.timet(item.getCd()+"");
        helper.setText(R.id.review_date,date+"");
        helper.setText(R.id.review_grade, "评分："+item.getCr()+"");
    }


}
