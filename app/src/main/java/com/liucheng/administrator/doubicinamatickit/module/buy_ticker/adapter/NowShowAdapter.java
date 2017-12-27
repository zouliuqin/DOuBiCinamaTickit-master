package com.liucheng.administrator.doubicinamatickit.module.buy_ticker.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class NowShowAdapter extends BaseQuickAdapter<IsHit.MsBean,BaseViewHolder> {
    public NowShowAdapter(int layoutResId, @Nullable List<IsHit.MsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, IsHit.MsBean item) {
        Picasso.with(mContext).load(item.getImg()).placeholder(R.mipmap.ic_launcher).transform(new CropSquareTransformation()).noFade().into((ImageView) helper.getView(R.id.poster_movie));
        helper.setText(R.id.title_movie,item.getTCn());
        helper.setText(R.id.content_movie,item.getCommonSpecial());
        helper.setText(R.id.grader_movie,item.getR()+"");
        helper.setText(R.id.actor_movie,item.getActors());
        helper.addOnClickListener(R.id.buy_ciname_button_ticker);


    }


//    List<IsHit.MsBean> hitData = new ArrayList<>();
//
//    public NowShowAdapter(Context context, List data) {
//        super(context, data);
//        this.hitData = data;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder ;
//        if (view == null){
//            holder = new ViewHolder();
//            view = getLayoutInflater().inflate(R.layout.now_hot_show,viewGroup,false);
//            holder.imageView_movie = view.findViewById(R.id.poster_movie);
//            holder.textView_title = view.findViewById(R.id.title_movie);
//            holder.textView_content = view.findViewById(R.id.content_movie);
//            holder.textView_grader = view.findViewById(R.id.grader_movie);
//            holder.textView_actor = view.findViewById(R.id.actor_movie);
//            view.setTag(holder);
//        }else {
//            holder = (ViewHolder) view.getTag();
//        }
//       IsHit.MsBean hitMovie =  hitData.get(i);
////        Picasso.with(getContext()).load(hitMovie.getImg()).placeholder(R.mipmap.ic_launcher).into(holder.imageView_movie);
////        Glide.with(getContext()).load(hitMovie.getImg()).into(holder.imageView_movie);
//        Picasso.with(getContext()).load(hitMovie.getImg()).placeholder(R.drawable.logo).transform(new CropSquareTransformation()).into(holder.imageView_movie);
//holder.textView_title.setText(hitMovie.getTCn());
//holder.textView_content.setText(hitMovie.getCommonSpecial());
//holder.textView_grader.setText(hitMovie.getR()+"");
//holder.textView_actor.setText(hitMovie.getActors());
//
//
//
//        return view;
//    }

//    @Override
//    protected void convert(BaseViewHolder helper, IsHit.MsBean item) {
//
//    }

//    class  ViewHolder{
//        ImageView imageView_movie;
//        TextView textView_title;
//        TextView textView_content;
//        TextView textView_grader;
//        TextView textView_actor;
//
//
//
//}


}
