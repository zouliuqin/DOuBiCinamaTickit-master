package com.liucheng.administrator.doubicinamatickit.module.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.ListNews;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.manager.LocationId;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHitData;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.UpcomingData;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;
import com.liucheng.administrator.doubicinamatickit.module.homepage.adapter.HomepageComingSoonAdapter;
import com.liucheng.administrator.doubicinamatickit.module.homepage.adapter.HomepageHotAdapter;
import com.liucheng.administrator.doubicinamatickit.module.homepage.adapter.HomepageNewsAdapter;
import com.liucheng.administrator.doubicinamatickit.view.ImageText;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class HomeFragment extends BaseFragment implements IsHitData.IsHitLoadListener, UpcomingData.UpcomingLoadListener,NewsData.NewsLoadListener {


    @BindView(R.id.imageviewText)
    ImageText imageviewText;
    @BindView(R.id.tv_hot_more)
    TextView tvHotMore;
    @BindView(R.id.rv_homepage_hot)
    RecyclerView rvHomepageHot;
    @BindView(R.id.tv_coming_soon_more)
    TextView tvComingSoonMore;
    @BindView(R.id.rv_coming_soon)
    RecyclerView rvComingSoon;
    @BindView(R.id.tv_movie_news_more)
    TextView tvMovieNewsMore;
    @BindView(R.id.rv_movie_news)
    RecyclerView rvMovieNews;
    Unbinder unbinder;
    @BindView(R.id.homepage_banner)
    Banner homepageBanner;
    /**
     * 首页新闻轮播图片
     */
    private List<String> imgs = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    /**
     * 正在热映
     */
    private List<IsHit.MsBean> isHits = new ArrayList<>();

    private HomepageHotAdapter hotAdapter;

    /**
     * 即将上线
     */
    private List<Upcoming.AttentionBean> comingSoons = new ArrayList<>();

    private HomepageComingSoonAdapter comingSoonAdapter;

    /**
     *新闻资讯
     */
    private  List<MovieNews.NewsListBean>  news = new ArrayList<>();

    private HomepageNewsAdapter newsAdapter;
    private  List<MovieNews.NewsListBean>  newsTop4 =new ArrayList<>();

    /**
     * 定位城市
     */
    private  String city;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.home_fragment, container, false);

        //获取正在热映数据

        IsHitData.getIIsHitData(this);

        //获取即将上线数据
        UpcomingData.getUpcomingData(this);



        //获取新闻资讯数据
        NewsData.getNewsData(this, 1);




        unbinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void initialUI() {
        //设置标题栏
        actionBar = contentView.findViewById(R.id.include_actionbar_home);
        initiaActionBar(R.drawable.go, city, "某票", -1);
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取当前城市
        city= MyApplication.getCityName();
        initialUI();
        //获取城市ID
        int Locationid = LocationId.getLocationId(getActivity(), R.raw.json);
        //Toast.makeText(getActivity(), "Locationid"+Locationid, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.imageviewText, R.id.tv_hot_more, R.id.tv_coming_soon_more, R.id.tv_movie_news_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.imageviewText:
                //TODO 点击定位，选择城市
                break;
            case R.id.tv_hot_more:
                //TODO 点击正在热映 -更多按钮 跳转到购票-正在热映
                break;
            case R.id.tv_coming_soon_more:
                //TODO 点击即将上映 -更多按钮 跳转到购票-即将上映
                break;
            case R.id.tv_movie_news_more:
                //TODO 点击最新资讯 -更多按钮 跳转到发现-资讯

                break;
        }
    }


    private void setBanner() {
        //取正在热映的前6条数据剧照
        for (int i = 0; i < 6; i++) {
            imgs.add(isHits.get(i).getImg());

        }

        //设置图片加载器
        homepageBanner.setImageLoader(new GlideImageLoader());
        //设置轮播样式（默认为CIRCLE_INDICATOR）
        homepageBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);

        //设置轮播图片间隔时间（单位毫秒，默认为2000）
        homepageBanner.setDelayTime(3000);

        //设置图片集合
        homepageBanner.setImages(imgs);
        //banner设置方法全部调用完毕时最后调用
        homepageBanner.start();


    }

    /**
     * @param isHit 正在热映数据
     */

    @Override
    public void onIsHitLoadEnd(IsHit isHit) {
        //获取资讯集合
        isHits.addAll(isHit.getMs());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //设置正在热映
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvHomepageHot.setLayoutManager(manager);
                hotAdapter = new HomepageHotAdapter(R.layout.item_homepage_hot, isHits);
                rvHomepageHot.setAdapter(hotAdapter);
                //设置轮播
                setBanner();
            }
        });
    }

    /**
     * @param upcoming 即将上线数据
     */


    @Override
    public void onUpcomingLoadEnd(Upcoming upcoming) {

        comingSoons.addAll(upcoming.getAttention());

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO 设置即将上映
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvComingSoon.setLayoutManager(manager);
                comingSoonAdapter = new HomepageComingSoonAdapter(R.layout.item_homepage_comingsoon, comingSoons);
                rvComingSoon.setAdapter(comingSoonAdapter);


            }
        });




    }

    /**
     * @param movieNews 最新资讯
     */


    @Override
    public void onNewsLoadEnd(MovieNews movieNews) {
        news.clear();

        news.addAll(movieNews.getNewsList());
        //首页只显示4条电影资讯，点击更多跳转到发现-电影资讯，查看更多电影资讯
        newsTop4.clear();
        for (int i = 0 ; i< 4 ; i ++){

            newsTop4.add(movieNews.getNewsList().get(i));
        }

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO 设置电影资讯
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                rvMovieNews.setLayoutManager(manager);
                newsAdapter = new HomepageNewsAdapter(R.layout.item_news, newsTop4);
                rvMovieNews.setAdapter(newsAdapter);
            }
        });

    }

    private class GlideImageLoader implements ImageLoaderInterface {
        @Override
        public void displayImage(Context context, Object path, View imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //
            //            //Glide 加载图片简单用法
            //            Glide.with(context).load(path).into(imageView);

            //Picasso 加载图片简单用法
            Picasso.with(context).load(path.toString())
                    .into((ImageView) imageView);
            //
            //            //用fresco加载图片简单用法，记得要写下面的createImageView方法
            //            Uri uri = Uri.parse((String) path);
            //            imageView.setImageURI(uri);
        }

        @Override
        public View createImageView(Context context) {
            return null;
        }
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        homepageBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        homepageBanner.stopAutoPlay();
    }
}
