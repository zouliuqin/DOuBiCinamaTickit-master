package com.liucheng.administrator.doubicinamatickit.module.details_movie.data;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/18 0018.
 */

public class AllReviewData {
    /**
     * 接口回调
     */
    public interface AllReviewDataLoadListener {
        void onAllReviewLoadEnd(AllReview review);
    }

    /**
     * 获取即将上映数据源
     */
    public static void getReviewData(final AllReviewData.AllReviewDataLoadListener loadListener, final String cinameId, final int index) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.ALL_REVIEW_MOVIE+cinameId+IUrl.REVIEW_INDEX+index)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    AllReview allReview = gson.fromJson(data, AllReview.class);

                    //接口回调
                    loadListener.onAllReviewLoadEnd(allReview);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
