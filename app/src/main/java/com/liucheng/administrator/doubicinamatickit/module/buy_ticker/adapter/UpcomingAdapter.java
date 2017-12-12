package com.liucheng.administrator.doubicinamatickit.module.buy_ticker.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class UpcomingAdapter extends BaseAdapter {
    List<Upcoming.MoviecomingsBean> upcoming = new ArrayList<>();


    public UpcomingAdapter(Context context, List data) {
        super(context, data);
        this.upcoming = data;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
ViewHolder holder;
        if (view == null) {

            view = getLayoutInflater().inflate(R.layout.upcoming_show, viewGroup, false);
            holder = new ViewHolder(view);
view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Upcoming.MoviecomingsBean moviecomingsBean = upcoming.get(i);
        Picasso.with(getContext()).load(moviecomingsBean.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.posterUpcoming);
        holder.titleUpvoming.setText(moviecomingsBean.getTitle());
        holder.actorUpcoming.setText(moviecomingsBean.getActor1()+" / "+moviecomingsBean.getActor2());
        holder.contentUpcoming.setText(moviecomingsBean.getType());
        holder.upcomingDate.setText(moviecomingsBean.getReleaseDate());
        return view;
    }



    static class ViewHolder {
        @BindView(R.id.poster_upcoming)
        ImageView posterUpcoming;
        @BindView(R.id.title_upvoming)
        TextView titleUpvoming;
        @BindView(R.id.actor_upcoming)
        TextView actorUpcoming;
        @BindView(R.id.content_upcoming)
        TextView contentUpcoming;
        @BindView(R.id.upcoming_date)
        TextView upcomingDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
