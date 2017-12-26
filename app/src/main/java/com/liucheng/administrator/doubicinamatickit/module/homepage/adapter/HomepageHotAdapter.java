package com.liucheng.administrator.doubicinamatickit.module.homepage.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/16 0016.
 */

public class HomepageHotAdapter extends BaseQuickAdapter<IsHit.MsBean,BaseViewHolder> {
    public HomepageHotAdapter(int layoutResId, @Nullable List<IsHit.MsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, IsHit.MsBean item) {

        helper.setText(R.id.item_tv_homepage_hot_name,item.getTCn());
        Picasso.with(mContext).load(item.getImg()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into((ImageView)
                helper.getView(R.id.item_iv_homepage_hot));

    }
}
