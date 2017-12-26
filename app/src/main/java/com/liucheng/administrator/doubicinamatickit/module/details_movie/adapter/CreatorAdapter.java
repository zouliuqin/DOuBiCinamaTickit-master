package com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17 0017.
 */

public class CreatorAdapter extends BaseQuickAdapter<Details.DataBean.BasicBean.ActorsBean,BaseViewHolder> {
    public CreatorAdapter(int layoutResId, @Nullable List<Details.DataBean.BasicBean.ActorsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Details.DataBean.BasicBean.ActorsBean item) {
        helper.setText(R.id.text_names,item.getName()+"");
        Picasso.with(mContext).load(item.getImg()).placeholder(R.drawable.logo).into((ImageView)
                helper.getView(R.id.image_actors));
    }
}
