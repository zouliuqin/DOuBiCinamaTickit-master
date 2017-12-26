package com.liucheng.administrator.doubicinamatickit.module.homepage.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/16 0016.
 */

public class HomepageComingSoonAdapter extends BaseQuickAdapter<Upcoming.AttentionBean,BaseViewHolder> {

    public HomepageComingSoonAdapter(int layoutResId, @Nullable List<Upcoming.AttentionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Upcoming.AttentionBean item) {
        helper.setText(R.id.item_tv_homepage_coming_soon_name,item.getTitle());
        helper.setText(R.id.item_tv_homepage_coming_soon_releaseDate,item.getReleaseDate());
        Picasso.with(mContext).load(item.getImage()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into((ImageView) helper.getView(R.id.item_iv_homepage_coming_soon_img));


    }
}
