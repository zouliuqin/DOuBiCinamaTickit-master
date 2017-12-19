package com.liucheng.administrator.doubicinamatickit.module.details_movie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter.AllReviewAdapter;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.AllReview;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.AllReviewData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;

public class ReviewActivity extends AppCompatActivity implements AllReviewData.AllReviewDataLoadListener {
    int index = 1;
    int i = 0;


    @BindView(R.id.recyclerView_Review)
    RecyclerView recyclerViewReview;
    AllReviewAdapter adapter;
    //所评论的电影的Id
    String movieId;
    List<AllReview.DataBean.CtsBean> ctsBeans = new ArrayList<>();
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        movieId = intent.getStringExtra("cinameId");
        AllReviewData.getReviewData(this, movieId, index);
        adapter = new AllReviewAdapter(R.layout.item_allreview, ctsBeans);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        adapter.isFirstOnly(false);
        // 当列表滑动到倒数第N个Item的时候(默认是1)回调onLoadMoreRequested方法
        adapter.disableLoadMoreIfNotFullPage(recyclerViewReview);
        swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        initRefreshLayout();
//        adapter.setEnableLoadMore(true);
//        adapter.setStartUpFetchPosition(1);
        // 滑动最后一个Item的时候回调onLoadMoreRequested方法
        initiaUi();

    }

    private void initRefreshLayout() {
       swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {

        if (index>1){
            index--;
            AllReviewData.getReviewData(ReviewActivity.this, movieId, index);
            adapter.setEnableLoadMore(true);
//            swipeLayout.setRefreshing(false);

        }
        swipeLayout.setRefreshing(false);

    }

    private void initiaUi() {
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                i++;
                recyclerViewReview.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i % 2 == 1) {
                            index++;
                            if (ctsBeans.size() < 20 || index >= 10) {
                                adapter.loadMoreEnd(true);
                            } else {

                                AllReviewData.getReviewData(ReviewActivity.this, movieId, index);

                            }
                        }
                        adapter.loadMoreComplete();


                    }
                }, 3000);


            }


        });


    }


    @Override
    public void onAllReviewLoadEnd(final AllReview review) {
        ctsBeans.clear();
        ctsBeans.addAll(review.getData().getCts());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager manager = new LinearLayoutManager(ReviewActivity.this);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewReview.setLayoutManager(manager);

                recyclerViewReview.setAdapter(adapter);


            }
        });

    }


}
