package com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class UpcomingData {
    /**
     * 接口回调
     */
    public interface UpcomingLoadListener {
        void onIsHitLoadEnd(Upcoming upcoming);
    }

    /**
     * 获取即将上映数据源
     */
    public static void getIIsHitData(final UpcomingData.UpcomingLoadListener loadListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.UPCOMING_MOVIE)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    Upcoming upcoming = gson.fromJson(data, Upcoming.class);

                    //接口回调
                    loadListener.onIsHitLoadEnd(upcoming);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
