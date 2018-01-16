package com.liucheng.administrator.doubicinamatickit.module.details_movie;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.CropSquareTransformation;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter.CreatorAdapter;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter.ReviewAdapter;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.adapter.StillAdapter;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Details;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.DetailsData;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.Review;
import com.liucheng.administrator.doubicinamatickit.module.details_movie.data.ReviewData;
import com.liucheng.administrator.doubicinamatickit.module.photo.PhotoActivity;
import com.liucheng.administrator.doubicinamatickit.ui.MainActivity;
import com.luck.picture.lib.PictureSelector;
import com.squareup.picasso.Picasso;
import com.timqi.sectorprogressview.ColorfulRingProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity implements DetailsData.DetailsDataLoadListener, ReviewData.ReviewDataLoadListener {
    /**
     * 进度条
     */
    ColorfulRingProgressView crpv;
    /**
     * 进度条中的评分
     */
    TextView tvPercent;
    Handler handler = null;
    Runnable runnable = null;

    WebView webView;
    Details detail = new Details();
    List<Review.DataBean.MiniBean.ListBean> listBeans = new ArrayList<>();

    private boolean islove = false;

    private boolean isstar = false;

    int i = 2;//控制简介的弹出与折叠
    @BindView(R.id.image_movie)
    ImageView imageMovie;
    @BindView(R.id.text_movieName)
    TextView textMovieName;
    @BindView(R.id.text_movieNameEn)
    TextView textMovieNameEn;
    @BindView(R.id.text_movieDate)
    TextView textMovieDate;
    @BindView(R.id.text_movieDuration)
    TextView textMovieDuration;
    @BindView(R.id.text_movieDirector)
    TextView textMovieDirector;
    @BindView(R.id.text_movieAct)
    TextView textMovieAct;
    @BindView(R.id.text_movieType)
    TextView textMovieType;
    @BindView(R.id.text_movieIntro)
    TextView textMovieIntro;
    @BindView(R.id.text_movieIntro1)
    TextView textMovieIntro1;
    @BindView(R.id.image_moviePrevue)
    ImageView imageMoviePrevue;
    @BindView(R.id.text_movieTitle)
    TextView textMovieTitle;
    @BindView(R.id.layout_moviePrevue)
    LinearLayout layoutMoviePrevue;
    @BindView(R.id.still_recyc)
    RecyclerView stillRecyc;
    //剧照的Adapter;
    StillAdapter stillAdapter;
    //剧照的Adapter
    @BindView(R.id.actor_recyc)
    RecyclerView actorRecyc;
    //主创的RecyclerView
    CreatorAdapter creatorAdapter;
    //热评的RecyclerView
    @BindView(R.id.review_recyc)
    RecyclerView reviewRecyc;
    //热评的Adapter
    ReviewAdapter reviewAdapter;
    @BindView(R.id.frame_play)
    FrameLayout framePlay;
    @BindView(R.id.image_down)
    ImageView imageDown;
    @BindView(R.id.image_up)
    ImageView imageUp;
    @BindView(R.id.video_play)
    ImageView videoPlay;
    @BindView(R.id.text_AllReview)
    TextView textAllReview;
    //当前页的电影id
    String cinameId;
    @BindView(R.id.ll_details_wanna_see)
    LinearLayout llDetailsWannaSee;
    @BindView(R.id.ll_details_have_seen)
    LinearLayout llDetailsHaveSeen;
    @BindView(R.id.iv_details_wanna_see)
    ImageView ivDetailsWannaSee;
    @BindView(R.id.tv_details_wanna_see)
    TextView tvDetailsWannaSee;
    @BindView(R.id.iv_details_have_seen)
    ImageView ivDetailsHaveSeen;
    @BindView(R.id.tv_details_have_seen)
    TextView tvDetailsHaveSeen;
    List<Details.DataBean.BasicBean.StageImgBean.ListBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        cinameId = intent.getStringExtra("cinameId");

        //电影详情
        DetailsData.getIIsHitData(this, cinameId);
        //热评
        ReviewData.getReviewData(this, cinameId);
        //        Log.d("rrrrrrrrrrrrrr",detail.getData().getBasic().getStory());

    }


    private void initiaData() {
        Picasso.with(this).load(detail.getData().getBasic().getImg()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                .noFade().into(imageMovie);
        textMovieName.setText(detail.getData().getBasic().getName());
        if (detail.getData().getBasic().getNameEn().length() > 1) {
            textMovieNameEn.setText(detail.getData().getBasic().getNameEn());
        } else {
            textMovieNameEn.setText("...");
        }


        textMovieDate.setText(detail.getData().getBasic().getReleaseDate().substring(0, 4));
        if (detail.getData().getBasic().getMins().length() > 1) {
            textMovieDuration.setText(detail.getData().getBasic().getMins() + "");
        } else {
            textMovieDuration.setText("....");
        }
        if (detail.getData().getBasic().getDirector().getName() != null) {
            textMovieDirector.setText(detail.getData().getBasic().getDirector().getName());
        } else {
            textMovieDirector.setText("...");
        }
        if (detail.getData().getBasic().getActors().size() > 1) {
            //主演名1
            int a1 = detail.getData().getBasic().getActors().get(0).getName().length();
            //主演名2
            int a2 = detail.getData().getBasic().getActors().get(1).getName().length();
            if (a1 > 0 & a2 == 0) {
                String act1 = detail.getData().getBasic().getActors().get(0).getName();


                textMovieAct.setText(act1);
            } else if (a1 > 0 & a2 > 0) {
                String act1 = detail.getData().getBasic().getActors().get(0).getName();
                String act2 = detail.getData().getBasic().getActors().get(1).getName();

                textMovieAct.setText(act1 + " " + act2);

            }
        } else {
            textMovieAct.setText("...");
        }


        textMovieType.setText(detail.getData().getBasic().getType() + "");
        textMovieIntro.setText(detail.getData().getBasic().getStory() + "");
        textMovieIntro1.setText(detail.getData().getBasic().getStory() + "");
        //        Log.d("000000000",detail.getData().getBasic().getVideo().getImg());
        if (detail.getData().getBasic().getVideo().getImg().length() > 0) {
            Picasso.with(this).load(detail.getData().getBasic().getVideo().getImg()).placeholder(R.drawable.logo).transform(new CropSquareTransformation())
                    .noFade().into(imageMoviePrevue);
        } else {
            layoutMoviePrevue.setVisibility(View.GONE);
            framePlay.setVisibility(View.GONE);

        }
        if (detail.getData().getBasic().getVideo().getTitle().length() > 0) {
            textMovieTitle.setText(detail.getData().getBasic().getVideo().getTitle());
        }


    }

    @Override
    public void onIsHitLoadEnd(final Details details) {
        detail = details;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initiaData();
                initiaProgress(details.getData().getBasic().getOverallRating());

                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                stillRecyc.setLayoutManager(layoutManager);
                stillAdapter = new StillAdapter(R.layout.item_still, details.getData().getBasic().getStageImg().getList());
                stillRecyc.setAdapter(stillAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(DetailsActivity.this);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                actorRecyc.setLayoutManager(manager);
                creatorAdapter = new CreatorAdapter(R.layout.item_actors, details.getData().getBasic().getActors());
                actorRecyc.setAdapter(creatorAdapter);

                //设置剧照点击事件
                stillAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        String img = details.getData().getBasic().getStageImg().getList().get(position).getImgUrl();
                        Intent intent = new Intent(DetailsActivity.this, PhotoActivity.class);
                        intent.putExtra("img", img);
                        startActivity(intent);
                    }
                });

            }
        });

    }


    @Override
    public void onReviewLoadEnd(final Review review) {
        listBeans.clear();
        listBeans.addAll(review.getData().getMini().getList());


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager manager = new LinearLayoutManager(DetailsActivity.this);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                reviewRecyc.setLayoutManager(manager);
                reviewAdapter = new ReviewAdapter(R.layout.recyview_item, listBeans);
                reviewRecyc.setAdapter(reviewAdapter);

            }
        });


    }

    @OnClick({R.id.image_down, R.id.image_up, R.id.text_AllReview, R.id.ll_details_wanna_see, R.id.ll_details_have_seen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_down:
                textMovieIntro.setVisibility(View.GONE);
                textMovieIntro1.setVisibility(View.VISIBLE);
                imageDown.setVisibility(View.GONE);
                imageUp.setVisibility(View.VISIBLE);
                break;
            case R.id.image_up:
                textMovieIntro.setVisibility(View.VISIBLE);
                textMovieIntro1.setVisibility(View.GONE);
                imageDown.setVisibility(View.VISIBLE);
                imageUp.setVisibility(View.GONE);
                break;
            case R.id.text_AllReview:
                Intent intent = new Intent(this, ReviewActivity.class);
                intent.putExtra("cinameId", cinameId);
                startActivity(intent);


                break;
            case R.id.ll_details_wanna_see:
                //想看
                //点击想看,改变图像样式，字体颜色
                if (islove) {
                    tvDetailsWannaSee.setTextColor(getResources().getColor(R.color.gray_500));
                    ivDetailsWannaSee.setImageResource(R.mipmap.ic_love);
                    islove = false;
                } else {
                    tvDetailsWannaSee.setTextColor(getResources().getColor(R.color.red_300));
                    ivDetailsWannaSee.setImageResource(R.mipmap.ic_love_select);
                    islove = true;
                }


                break;
            case R.id.ll_details_have_seen:
                if (isstar) {
                    tvDetailsHaveSeen.setTextColor(getResources().getColor(R.color.gray_500));
                    ivDetailsHaveSeen.setImageResource(R.mipmap.ic_star);
                    isstar = false;
                } else {
                    tvDetailsHaveSeen.setTextColor(getResources().getColor(R.color.red_300));
                    ivDetailsHaveSeen.setImageResource(R.mipmap.ic_star_select);
                    isstar = true;
                }


                //看过
                break;
        }
    }


    @OnClick(R.id.video_play)
    public void onViewClicked() {
        //        webView.setVisibility(View.VISIBLE);
        //        webView.loadUrl(detail.getData().getBasic().getVideo().getUrl());
        //        Log.d("5555555555555555555555",detail.getData().getBasic().getVideo().getUrl());
        Intent intent = new Intent(DetailsActivity.this, VideoActivity.class);
        intent.putExtra("URL", detail.getData().getBasic().getVideo().getUrl());
        intent.putExtra("TITLE", detail.getData().getBasic().getVideo().getTitle());
        startActivity(intent);

    }

    private void initiaProgress(double grade) {
        handler = new Handler();
        crpv = (ColorfulRingProgressView) findViewById(R.id.crpv);
        tvPercent = (TextView) findViewById(R.id.tvPercent);
        tvPercent.setText(grade + "分");
        setTemperature(((int) grade) * 10);
        crpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint("ObjectAnimatorBinding") ObjectAnimator anim = ObjectAnimator.ofFloat(v, "percent",
                        0, ((ColorfulRingProgressView) v).getPercent());
                anim.setInterpolator(new LinearInterpolator());
                anim.setDuration(1000);
                anim.start();
            }
        });


    }

    private void setTemperature(final int temperature) {
        //初始化handler对象
        handler.removeCallbacksAndMessages(null);
        runnable = new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                progress++;
                if (progress < temperature) {
                    crpv.setPercent(progress);

                }
                handler.postDelayed(runnable, 70);
            }
        };
        //启动线程
        handler.postDelayed(runnable, 1000);

    }

}
