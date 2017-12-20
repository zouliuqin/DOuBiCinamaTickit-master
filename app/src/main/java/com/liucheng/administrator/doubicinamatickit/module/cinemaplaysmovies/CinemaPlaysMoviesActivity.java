package com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.liucheng.administrator.doubicinamatickit.entity.CinemaPlaysMovies;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.adapter.PlayTimeAdapter;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.data.CinemaPlaysMoviesData;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.view.ClipViewPager;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.view.PageTransformer;
import com.liucheng.administrator.doubicinamatickit.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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

    @BindView(R.id.pager)
    ClipViewPager pager;
    @BindView(R.id.cinema_plays_movies)
    RelativeLayout cinemaPlaysMovies;
    @BindView(R.id.rv_cinema_plays_movies)
    RecyclerView rvCinemaPlaysMovies;


    private PlayTimeAdapter playTimeAdapter;


    /**
     * 接收到的电影院信息
     */
    private Cinema.CinemaBean cinemaBean;

    /**
     * 解析得到的电影信息
     */
    private CinemaPlaysMovies.DataBean.CinemaBean newCinemaBean;

    /**
     * 解析的到的正在播放的电影
     */
    private List<CinemaPlaysMovies.DataBean.MoviesBean> moviesBeans = new ArrayList<>();
    /**
     * 解析得到的电影排班表
     */
    private List<CinemaPlaysMovies.DataBean.ShowtimesBean> showtimesBeans = new ArrayList<>();

    /**
     * 选中影片后的下标
     */
    private int moviesPosition;
    /**
     * 某电影“今天”的排片
     */
    private List<CinemaPlaysMovies.DataBean.ShowtimesBean> todayShowTimes = new ArrayList<>();
    /**
     * 滑动选中的电影ID
     */
   private int  movieId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cinema_plays_movies);
        ButterKnife.bind(this);
        //接收电影院详情
        cinemaBean = getIntent().getParcelableExtra("cinemaBeans");

        //获取电影院正在播出的电影
        CinemaPlaysMoviesData.getCinemaPlaysMoviesData(this, this);

        //initData
        initData();
        //初始化UI
        initUi();


    }

    private void initData() {

        //获取第一部电影的影片ID
        int movieId = moviesBeans.get(0).getMovieId();
        //遍历 通过movieId 找到集合里面为当前影片的排片数组
        todayShowTimes.clear();
        for (int i = 0; i < showtimesBeans.size(); i++) {
            if (showtimesBeans.get(i).getMovieId() == movieId) {
                todayShowTimes.add(showtimesBeans.get(i));
            }
        }

    }


    private void initUi() {
        //初始化playTimeAdapter
        LinearLayoutManager manager = new LinearLayoutManager(CinemaPlaysMoviesActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCinemaPlaysMovies.setLayoutManager(manager);
        playTimeAdapter = new PlayTimeAdapter(R.layout.item_news, todayShowTimes);
        rvCinemaPlaysMovies.setAdapter(playTimeAdapter);

        //设置电影院地址,第一个电影的信息
        tvCinemaPlaysMoviesCinemaName.setText(cinemaBean.getCinameName());
        tvCinemaPlaysMoviesAddress.setText(cinemaBean.getAddress());
        tvTvCinemaPlaysMoviesMoviesName.setText(moviesBeans.get(0).getTitle());
        tvCinemaPlaysMoviesDescribe.setText(moviesBeans.get(0).getType());
        //设置"今天"为点中
        rbToday.setChecked(true);

        //设置cinemaPlaysMovies
        cinemaPlaysMovies.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return pager.dispatchTouchEvent(motionEvent);
            }


        });
        pager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));
        pager.setOffscreenPageLimit(moviesBeans.size());
        pager.setPageTransformer(true, new PageTransformer());

        //设置滑动监听，用于改变电影信息和排片
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                //设置当前影片名字
                tvTvCinemaPlaysMoviesMoviesName.setText(moviesBeans.get(position).getTitle());
                tvCinemaPlaysMoviesDescribe.setText(moviesBeans.get(position).getType());

                moviesPosition = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return moviesBeans.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View pageView = LayoutInflater.from(CinemaPlaysMoviesActivity.this).inflate(R.layout.pager_item_poster, null);
                ImageView imageView = pageView.findViewById(R.id.imageView1);
                Picasso.with(CinemaPlaysMoviesActivity.this).load(moviesBeans.get(position).getImg()).into(imageView);
                // imageView.setLayoutParams(lp);
                pager.addView(pageView);


                return pageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

                pager.removeView((View) object);
            }


        });


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
        cinemaPlaysMovies.setBackground(a);
    }

    @OnClick({R.id.iv_cinema_plays_movies_movies_img_bg, R.id.rb_today, R.id.rb_tomorrow, R.id.rb_the_day_after_tomorrw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_cinema_plays_movies_movies_img_bg:
                break;
            case R.id.rb_today:
                // List<Integer> index =new ArrayList<>();

                //获取当前选中的影片ID
                movieId = moviesBeans.get(moviesPosition).getMovieId();
                //遍历 通过movieId 找到集合里面为当前影片的排片数组
                todayShowTimes.clear();
                for (int i = 0; i < showtimesBeans.size(); i++) {
                    if (showtimesBeans.get(i).getMovieId() == movieId) {
                        todayShowTimes.add(showtimesBeans.get(i));
                    }
                }
                //显示“今天” 的排片
                playTimeAdapter.setNewData(todayShowTimes);
                break;
            case R.id.rb_tomorrow:
                // List<Integer> index =new ArrayList<>();

                //获取当前选中的影片ID
                 movieId = moviesBeans.get(moviesPosition).getMovieId();
                //遍历 通过movieId 找到集合里面为当前影片的排片数组
                todayShowTimes.clear();
                for (int i = 0; i < showtimesBeans.size(); i++) {
                    if (showtimesBeans.get(i).getMovieId() == movieId) {
                        todayShowTimes.add(showtimesBeans.get(i));
                    }
                }
                //显示“今天” 的排片
                playTimeAdapter.setNewData(todayShowTimes);
                break;
            case R.id.rb_the_day_after_tomorrw:
                // List<Integer> index =new ArrayList<>();

                //获取当前选中的影片ID
                movieId = moviesBeans.get(moviesPosition).getMovieId();
                //遍历 通过movieId 找到集合里面为当前影片的排片数组
                todayShowTimes.clear();
                for (int i = 0; i < showtimesBeans.size(); i++) {
                    if (showtimesBeans.get(i).getMovieId() == movieId) {
                        todayShowTimes.add(showtimesBeans.get(i));
                    }
                }
                //显示“今天” 的排片
                playTimeAdapter.setNewData(todayShowTimes);
                break;
        }
    }

    @Override
    public void onCinemaPlaysMoviesLoadEnd(CinemaPlaysMovies cinemaPlaysMovies) {
        Log.i("ATG", "~~~~~~~~~~~~~~~~~~~~~~: " + cinemaPlaysMovies.getData().toString());
        //取电影院信息，电影院排片信息，电影院电影排排片时间信息
        newCinemaBean = cinemaPlaysMovies.getData().getCinema();
        moviesBeans = cinemaPlaysMovies.getData().getMovies();
        showtimesBeans = cinemaPlaysMovies.getData().getShowtimes();

        //设置界面
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {


            }
        });

    }
}
