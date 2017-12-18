package com.liucheng.administrator.doubicinamatickit.module.cinema.adapter;

import android.app.Application;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.liucheng.administrator.doubicinamatickit.util.DistanceUtil;
import com.liucheng.administrator.doubicinamatickit.util.NumUtil;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/18 0018.
 */

public class CinemaAdapter extends BaseQuickAdapter<Cinema.CinemaBean, CinemaAdapter.ViewHolder> {
    public CinemaAdapter(int layoutResId, @Nullable List<Cinema.CinemaBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ViewHolder helper, Cinema.CinemaBean item) {
        helper.setText(R.id.item_cinema_cinameName, item.getCinameName());

        helper.setText(R.id.item_cinema_address, item.getAddress());
        //如果最低消费大于0则显示最低价格
        if (item.getMinPrice() > 0) {
           // helper.itemCinemaMinPrice.setVisibility(View.VISIBLE);
            helper.setText(R.id.item_cinema_minPrice, "￥" + item.getMinPrice() / 100 + "起");
        } else {
            helper.setText(R.id.item_cinema_minPrice, "");
           // helper.itemCinemaMinPrice.setVisibility(View.GONE);
        }
    //设置电影院包含设施的图标
        if (item.getFeature().getHasIMAX() == 1) {
            helper.itemCinemaMinPrice.setVisibility(View.VISIBLE);
            helper.setImageResource(R.id.item_cinema_imax, R.mipmap.ic_imax);
        } else {
            helper.itemCinemaImax.setVisibility(View.GONE);
        }

        if (item.getFeature().getHasVIP() == 1) {
            helper.itemCinemaMinPrice.setVisibility(View.VISIBLE);
            helper.setImageResource(R.id.item_cinema_vip, R.mipmap.ic_vip);
        } else {
            helper.itemCinemaVip.setVisibility(View.GONE);
        }

        if (item.getFeature().getHasPark() == 1) {
            helper.itemCinemaMinPrice.setVisibility(View.VISIBLE);
            helper.setImageResource(R.id.item_cinema_park, R.mipmap.ic_park);
        } else {
            helper.itemCinemaPark.setVisibility(View.GONE);
        }

        if (item.getFeature().getHasWifi() == 1) {
            helper.itemCinemaMinPrice.setVisibility(View.VISIBLE);
            helper.setImageResource(R.id.item_cinema_wifi, R.mipmap.ic_wifi);
        } else {
            helper.itemCinemaWifi.setVisibility(View.GONE);
        }

       double a = DistanceUtil.getDistance(item.getBaiduLongitude(),item.getBaiduLatitude(), MyApplication.getLongitude(),MyApplication.getLatitude());

        helper.itemCinemaDistance.setText(NumUtil.getNum(a/1000)+"KM");
    }


    public static class ViewHolder extends BaseViewHolder {
        TextView itemCinemaCinameName;
        TextView itemCinemaMinPrice;
        TextView itemCinemaAddress;
        TextView itemCinemaDistance;
        ImageView itemCinemaVip;
        ImageView itemCinemaPark;
        ImageView itemCinemaImax;
        ImageView itemCinemaWifi;
        public ViewHolder(View view) {
            super(view);
             itemCinemaCinameName= view.findViewById(R.id.item_cinema_cinameName);
             itemCinemaMinPrice= view.findViewById(R.id.item_cinema_minPrice);
             itemCinemaAddress= view.findViewById(R.id.item_cinema_address);
             itemCinemaDistance= view.findViewById(R.id.item_cinema_distance);
             itemCinemaVip= view.findViewById(R.id.item_cinema_vip);
             itemCinemaPark= view.findViewById(R.id.item_cinema_park);
             itemCinemaImax= view.findViewById(R.id.item_cinema_imax);
             itemCinemaWifi= view.findViewById(R.id.item_cinema_wifi);
        }
    }
}
