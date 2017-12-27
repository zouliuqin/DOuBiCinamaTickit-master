package com.liucheng.administrator.doubicinamatickit.module.find;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.liucheng.administrator.doubicinamatickit.module.find.adapter.NewsAdapter;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class NewsFragment extends Fragment implements NewsData.NewsLoadListener {


    Unbinder unbinder;
    @BindView(R.id.lv_news)
    RecyclerView lvNews;
    @BindView(R.id.srl_news)
    SwipeRefreshLayout srlNews;
    @BindView(R.id.banner)
    Banner banner;
    //是否有横幅新闻
    private boolean isBanner = false;
    //新闻页码 最大为10
    private int pageNumber = 1;

    /**
     * setImages
     */
    List<String> images = new ArrayList<>();
    /**
     * 新闻资讯数据
     */
    private List<MovieNews.DataBeanX.DataBean> newsLists = new ArrayList<>();

    /**
     * 新闻资讯adapter
     */
    private NewsAdapter adapter;
    private List<String> titles = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        //获取新闻资讯数据
        NewsData.getNewsData(this, pageNumber);

        initUi();

        return view;
    }

    private void initUi() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        lvNews.setLayoutManager(manager);
        adapter = new NewsAdapter(R.layout.item_news, newsLists);
        lvNews.setAdapter(adapter);

        //默认下拉刷新
        srlNews.setColorSchemeColors(Color.parseColor("#000000"));
        srlNews.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载数据
                if (pageNumber <= 4) {
                    pageNumber++;
                    //获取新闻资讯数据
                    NewsData.getNewsData(NewsFragment.this, pageNumber);
                    //停止更新
                    srlNews.setRefreshing(false);
                } else {
                    //最多加载5页
                    Toast.makeText(getActivity(), "无法加载更多数据", Toast.LENGTH_SHORT).show();
                    //停止更新
                    srlNews.setRefreshing(false);
                }

            }
        });
    }


    private void setBanner() {






        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置轮播样式（默认为CIRCLE_INDICATOR）
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置轮播图片间隔时间（单位毫秒，默认为2000）
        banner.setDelayTime(3000);

        banner.setBannerTitles(titles);
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();


    }


    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 接口回调显示电影资讯数据
     *
     * @param movieNews 电影资讯
     */
    @Override
    public void onNewsLoadEnd(final MovieNews movieNews) {
        //获取新闻资讯集合
        if (newsLists.size() <= 0) {
            newsLists.clear();
            newsLists.addAll(movieNews.getData().getData());
        } else {
            newsLists.addAll(0, movieNews.getData().getData());
        }


        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //                adapter = new NewsAdapter(getActivity(), newsLists);
                //                lvNews.setAdapter(adapter);
                //更新界面
                //                adapter.notifyDataSetChanged();
                //如果没有横幅 则添加横幅信息


                adapter.setNewData(newsLists);

                if (!isBanner) {
                    for (int i = 0; i < 4; i++) {
                        images.add(newsLists.get(i).getImg1());
                        titles.add(newsLists.get(i).getTitle());
                    }
                    //修改是否有横幅状态
                    isBanner = true;
                }

                setBanner();
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
            if (!path.toString().equals("")) {
                Picasso.with(context).load(path.toString()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                        .noFade().into((ImageView) imageView);
            }


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
}
