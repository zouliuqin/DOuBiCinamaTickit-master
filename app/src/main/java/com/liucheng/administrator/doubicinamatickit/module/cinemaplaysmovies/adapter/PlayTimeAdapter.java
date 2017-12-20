package com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CinemaPlaysMovies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/20 0020.
 */

public class PlayTimeAdapter extends BaseQuickAdapter<CinemaPlaysMovies.DataBean.ShowtimesBean,BaseViewHolder> {




    public PlayTimeAdapter(int layoutResId, @Nullable List<CinemaPlaysMovies.DataBean.ShowtimesBean> data) {

        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CinemaPlaysMovies.DataBean.ShowtimesBean item) {
        helper.setText(R.id.iv_item_news_picture,item.getMovieId());
    }
}
