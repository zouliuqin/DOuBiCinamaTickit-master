package com.liucheng.administrator.doubicinamatickit.module.details_movie.data;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public class ReviewData {
    /**
     * 接口回调
     */
    public interface ReviewDataLoadListener {
        void onReviewLoadEnd(Review review);
    }

    /**
     * 获取即将上映数据源
     */
    public static void getReviewData(final ReviewData.ReviewDataLoadListener loadListener, final String cinameId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.REVIEW_MOVIE+cinameId)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    Review review = gson.fromJson(data, Review.class);

                    //接口回调
                    loadListener.onReviewLoadEnd(review);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
