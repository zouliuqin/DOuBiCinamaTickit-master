package com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17 0017.
 */

public class StillAdapter extends BaseQuickAdapter<Details.DataBean.BasicBean.StageImgBean.ListBean,BaseViewHolder> {

    public StillAdapter(int layoutResId, @Nullable List<Details.DataBean.BasicBean.StageImgBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Details.DataBean.BasicBean.StageImgBean.ListBean item) {
        Picasso.with(mContext).load(item.getImgUrl()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into((ImageView)
                helper.getView(R.id.image_still));
    }

}
