package com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.liucheng.administrator.doubicinamatickit.entity.CinemaPlaysMovies;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.data.CinemaPlaysMoviesData;
import com.liucheng.administrator.doubicinamatickit.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CinemaPlaysMoviesActivity extends AppCompatActivity implements CinemaPlaysMoviesData.CinemaPlaysMoviesLoadListener {

    @BindView(R.id.tv_cinema_plays_movies_cinema_name)
    TextView tvCinemaPlaysMoviesCinemaName;
    @BindView(R.id.tv_cinema_plays_movies_address)
    TextView tvCinemaPlaysMoviesAddress;
    @BindView(R.id.iv_cinema_plays_movies_movies_img_bg)
    ImageView ivCinemaPlaysMoviesMoviesImgBg;
    @BindView(R.id.rv_cinema_plays_movies)
    RecyclerView rvCinemaPlaysMovies;
    @BindView(R.id.tv_tv_cinema_plays_movies_movies_name)
    TextView tvTvCinemaPlaysMoviesMoviesName;
    @BindView(R.id.tv_cinema_plays_movies_describe)
    TextView tvCinemaPlaysMoviesDescribe;
    @BindView(R.id.rb_today)
    RadioButton rbToday;
    @BindView(R.id.rb_tomorrow)
    RadioButton rbTomorrow;
    @BindView(R.id.rb_the_day_after_tomorrw)
    RadioButton rbTheDayAfterTomorrw;
    @BindView(R.id.rg_cinema_plays_movies)
    RadioGroup rgCinemaPlaysMovies;
    @BindView(R.id.ll_cinema_plays_movies)
    LinearLayout llCinemaPlaysMovies;

    /**
     * 接收到的电影院信息
     */
    private Cinema.CinemaBean cinemaBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cinema_plays_movies);
        ButterKnife.bind(this);
        //接收电影院详情
        cinemaBean = getIntent().getParcelableExtra("cinemaBeans");

        //获取电影院正在播出的电影
        CinemaPlaysMoviesData.getCinemaPlaysMoviesData(this,this);

        //初始化UI
        initUi();



    }

    private void initUi() {
        //设置电影院地址
        tvCinemaPlaysMoviesCinemaName.setText(cinemaBean.getCinameName());
        tvCinemaPlaysMoviesAddress.setText(cinemaBean.getAddress());

        //模糊背景
        dimImage();

    }
    private void dimImage() {
        //得到原始图片

        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a111);
        int scaleRatio = 10;
        int blurRadius = 100;//模糊度 越大越模糊
        //将图片进行缩放 避免OOM错误
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originBitmap,
                originBitmap.getWidth() / scaleRatio,
                originBitmap.getHeight() / scaleRatio,
                false);
        Bitmap blurBitmap = Utils.doBlur(scaledBitmap, blurRadius, true);

        Drawable a = new BitmapDrawable(blurBitmap);

        rvCinemaPlaysMovies.setBackground(a);

    }

    @OnClick({R.id.iv_cinema_plays_movies_movies_img_bg, R.id.rb_today, R.id.rb_tomorrow, R.id.rb_the_day_after_tomorrw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_cinema_plays_movies_movies_img_bg:
                break;
            case R.id.rb_today:
                break;
            case R.id.rb_tomorrow:
                break;
            case R.id.rb_the_day_after_tomorrw:
                break;
        }
    }

    @Override
    public void onCinemaPlaysMoviesLoadEnd(CinemaPlaysMovies cinemaPlaysMovies) {
        Log.i("ATG", "~~~~~~~~~~~~~~~~~~~~~~: "+cinemaPlaysMovies.getData().toString());
    }
}
