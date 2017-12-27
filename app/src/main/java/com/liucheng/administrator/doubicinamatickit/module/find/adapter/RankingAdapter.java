package com.liucheng.administrator.doubicinamatickit.module.find.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.BoxOffice;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.util.StringUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 邹柳钦 on 2017/11/30 0030.
 */

public class RankingAdapter extends BaseAdapter<BoxOffice.MoviesBean> {




    public RankingAdapter(Context context, List<BoxOffice.MoviesBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holer = null;
        if (null == view) {
            view = getLayoutInflater().inflate(R.layout.item_box_office, null);

            holer = new ViewHolder(view);

            view.setTag(holer);
        } else {
            holer = (ViewHolder) view.getTag();
        }

        //        //设置信息
        //        holer.tvMovieName.setText(getItem(i).getMovieName());
        //        holer.tvBoxOffice.setText(getItem(i).getBoxOffice());
        //        holer.tvSumBoxOffice.setText(getItem(i).getSumBoxOffice());
        //        holer.tvMovieDay.setText(getItem(i).getMovieDay()+"天");
        //        holer.tvBoxPer.setText(getItem(i).getBoxPer()+"%");
        holer.tvMovieRanking.setText(getItem(i).getRankNum() + "");
        Picasso.with(getContext()).load(getItem(i).getPosterUrl()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into(holer.imMoviePoster);
        holer.tvMovieName.setText(getItem(i).getName());
        holer.rankWeek2.setText(StringUtil.BoxOfficeString(getItem(i).getWeekBoxOffice()));
        holer.rankingAdd.setText(StringUtil.BoxOfficeString(getItem(i).getTotalBoxOffice()));
        holer.rankGraded.setText(getItem(i).getRating() + "分");
        return view;

    }


    class ViewHolder {
        @BindView(R.id.im_movie_poster)
        ImageView imMoviePoster;
        @BindView(R.id.tv_movie_name)
        TextView tvMovieName;
        @BindView(R.id.ranking_add1)
        TextView rankingAdd1;
        @BindView(R.id.ranking_add)
        TextView rankingAdd;
        @BindView(R.id.ranking_week1)
        TextView rankingWeek1;
        @BindView(R.id.rank_week2)
        TextView rankWeek2;
        @BindView(R.id.rank_graded)
        TextView rankGraded;
        @BindView(R.id.tv_movie_ranking)
        TextView tvMovieRanking;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
