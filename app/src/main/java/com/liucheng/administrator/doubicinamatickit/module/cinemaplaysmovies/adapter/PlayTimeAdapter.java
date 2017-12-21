package com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CinemaPlaysMovies;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by 邹柳钦 on 2017/12/20 0020.
 */

public class PlayTimeAdapter extends BaseQuickAdapter<CinemaPlaysMovies.DataBean.ShowtimesBean.ListBean, BaseViewHolder> {


    public PlayTimeAdapter(int layoutResId, @Nullable List<CinemaPlaysMovies.DataBean.ShowtimesBean.ListBean> data) {

        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CinemaPlaysMovies.DataBean.ShowtimesBean.ListBean item) {
        helper.setText(R.id.item_play_time_tv_start_time, dateFormatting(item.getStartTime()));
        helper.setText(R.id.item_play_time_tv_end_time,dateFormatting(item.getEndTime())+"散场");
        helper.setText(R.id.item_play_time_tv_version_desc,item.getVersionDesc());
        helper.setText(R.id.item_play_time_tv_hall,item.getHall());
        helper.setText(R.id.item_play_time_tv_language,item.getLanguage());
        helper.setText(R.id.item_play_time_tv_price,item.getPrice()+"元");

        helper.addOnClickListener(R.id.item_play_time_but_ticket);






    }


    /**
     * @param date 时间戳
     * @return 格式化后时间 12：00
     */
    public String dateFormatting(int date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.CHINA);
        Long time = new Long(date);
        String d = format.format(time);

        return d;

    }



}
