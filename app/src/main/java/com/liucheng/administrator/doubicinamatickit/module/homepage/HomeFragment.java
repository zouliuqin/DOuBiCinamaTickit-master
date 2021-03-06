package com.liucheng.administrator.doubicinamatickit.module.homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.liucheng.administrator.doubicinamatickit.entity.SquareTransformation;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.manager.LocationId;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHit;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.IsHitData;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.UpcomingData;
import com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.CinemaPlaysMoviesActivity;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.DetailsActivity;
import com.liucheng.administrator.doubicinamatickit.module.find.DetailNewsActivity;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;
import com.liucheng.administrator.doubicinamatickit.module.homepage.adapter.HomepageComingSoonAdapter;
import com.liucheng.administrator.doubicinamatickit.module.homepage.adapter.HomepageHotAdapter;
import com.liucheng.administrator.doubicinamatickit.module.homepage.adapter.HomepageNewsAdapter;
import com.liucheng.administrator.doubicinamatickit.ui.MainActivity;
import com.liucheng.administrator.doubicinamatickit.view.ImageText;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class HomeFragment extends BaseFragment implements IsHitData.IsHitLoadListener, UpcomingData.UpcomingLoadListener, NewsData.NewsLoadListener,BDLocationListener {


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
    private List<IsHit.MsBean> isHitsTop10 = new ArrayList<>();

    /**
     * 即将上线
     */
    private List<Upcoming.AttentionBean> comingSoons = new ArrayList<>();

    private HomepageComingSoonAdapter comingSoonAdapter;
    private List<Upcoming.AttentionBean> comingSoonTop10 = new ArrayList<>();

    /**
     * 新闻资讯
     */
    private List<MovieNews.DataBeanX.DataBean> news = new ArrayList<>();

    private HomepageNewsAdapter newsAdapter;
    private List<MovieNews.DataBeanX.DataBean> newsTop4 = new ArrayList<>();

    /**
     * 定位城市
     */
    private String city;
    private View view;

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

        LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvComingSoon.setLayoutManager(manager2);
        comingSoonAdapter = new HomepageComingSoonAdapter(R.layout.item_homepage_comingsoon, comingSoons);
        rvComingSoon.setAdapter(comingSoonAdapter);

        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvHomepageHot.setLayoutManager(manager1);
        hotAdapter = new HomepageHotAdapter(R.layout.item_homepage_hot, isHits);
        rvHomepageHot.setAdapter(hotAdapter);

        //设置标题栏
        actionBar = contentView.findViewById(R.id.include_actionbar_home);
        initiaActionBar(R.drawable.ic_brake, city, "易迅电影", -1);

        //初始化新闻信息
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMovieNews.setLayoutManager(manager);
        newsAdapter = new HomepageNewsAdapter(R.layout.item_news, newsTop4);
        rvMovieNews.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //点击电影资讯item跳转到资讯详情
//                Toast.makeText(getContext(), "sdafvsadf", Toast.LENGTH_SHORT).show();
                Intent intentNew = new Intent(getActivity(), DetailNewsActivity.class);
//                        Log.d("00000000000ppppp",comingSoons.get(position).getId()+"");
                intentNew.putExtra("NewsId",news.get(position).getAId()+"");
                startActivity(intentNew);


            }
        });
        comingSoonAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // 点击即将上映item跳转到电影详情
                Intent intentCom = new Intent(getActivity(), DetailsActivity.class);
                intentCom.putExtra("cinameId",comingSoons.get(position).getId()+"");
                startActivity(intentCom);
            }
        });
        hotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // 点击正在热映item跳转到电影详情
                Intent intentHit = new Intent(getActivity(), DetailsActivity.class);
                intentHit.putExtra("cinameId",isHits.get(position).getId()+"");

                startActivity(intentHit);
            }



        });
        hotAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ((MainActivity)getActivity()).getViewPager_main().setCurrentItem(2);
            }
        });
        homepageBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                // 点击首页滚动条跳转到电影详情
                Intent intentHit = new Intent(getActivity(), DetailsActivity.class);
                intentHit.putExtra("cinameId",isHits.get(position).getId()+"");
                startActivity(intentHit);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        //获取当前城市
        city = MyApplication.getCityName();
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

                // 点击正在热映 -更多按钮 跳转到购票-正在热映
                EventBus.getDefault().post("0");
                ((MainActivity)getActivity()).getViewPager_main().setCurrentItem(1);
                break;
            case R.id.tv_coming_soon_more:
                EventBus.getDefault().post("1");
                ((MainActivity)getActivity()).getViewPager_main().setCurrentItem(1);
                // 点击即将上映 -更多按钮 跳转到购票-即将上映
                break;
            case R.id.tv_movie_news_more:
                // 点击最新资讯 -更多按钮 跳转到发现-资讯
//                EventBus.getDefault().post("0");
                ((MainActivity)getActivity()).getViewPager_main().setCurrentItem(3);
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
    public void onIsHitLoadEnd(final IsHit isHit) {
        isHitsTop10.clear();
        isHits.clear();
        //获取资讯集合
        isHits.addAll(isHit.getMs());
        if (isHits.size() <= 0) {
            return;
        }
        //取前10条数据放在首页
        if (isHits.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                isHitsTop10.add(isHits.get(i));
            }
        } else {
            for (int i = 0; i < 5; i++) {
                isHitsTop10.add(isHits.get(i));
            }

        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //设置正在热映
                hotAdapter.setNewData(isHitsTop10);
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


        comingSoonTop10.clear();

        comingSoons.addAll(upcoming.getAttention());
        if (comingSoons.size() <= 0) {
            return;
        }
        //取前10条数据放在首页
        if (comingSoons.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                comingSoonTop10.add(comingSoons.get(i));
            }
        } else {
            for (int i = 0; i < 4; i++) {
                comingSoonTop10.add(comingSoons.get(i));
            }
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 设置即将上映
                comingSoonAdapter.setNewData(comingSoonTop10);


            }
        });

    }

    /**
     * @param movieNews 最新资讯
     */


    @Override
    public void onNewsLoadEnd(MovieNews movieNews) {
        int j = 8;
        news.clear();

        news.addAll(movieNews.getData().getData());
        //首页只显示4条电影资讯，点击更多跳转到发现-电影资讯，查看更多电影资讯
        newsTop4.clear();
        if (news.size() >= 8) {
            j = 8;
        } else {
            j = 4;
        }

        for (int i = 0; i < j; i++) {

            newsTop4.add(movieNews.getData().getData().get(i));
        }

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //设置电影资讯
                newsAdapter.setNewData(newsTop4);

            }
        });

    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {

        StringBuilder currentPosition = new StringBuilder();
        currentPosition.append("纬度：").append(bdLocation.getLatitude()).append("\n");
        currentPosition.append("经线：").append(bdLocation.getLongitude()).append("\n");
        currentPosition.append("国家：").append(bdLocation.getCountry()).append("\n");
        currentPosition.append("省：").append(bdLocation.getProvince()).append("\n");
        currentPosition.append("市：").append(bdLocation.getCity()).append("\n");
        currentPosition.append("区：").append(bdLocation.getDistrict()).append("\n");
        currentPosition.append("街道：").append(bdLocation.getStreet()).append("\n");
        currentPosition.append("定位方式：");
        if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
            currentPosition.append("GPS");
        } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            currentPosition.append("网络");
        }
        //设置城市
        city = bdLocation.getCity().substring(0,bdLocation.getCity().length()-1);
        MyApplication.setCityName(city);
        initiaActionBar(R.drawable.ic_brake, city, "易迅电影", -1);
        EventBus.getDefault().post(city);

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
            Picasso.with(context).load(path.toString()).placeholder(R.drawable.logo).transform(new SquareTransformation())
                    .noFade()
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
