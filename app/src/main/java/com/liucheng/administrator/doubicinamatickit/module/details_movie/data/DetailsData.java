package com.liucheng.administrator.doubicinamatickit.module.details_movie.data;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.Upcoming;
import com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data.UpcomingData;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class DetailsData {
    /**
     * 接口回调
     */
    public interface DetailsDataLoadListener {
        void onIsHitLoadEnd(Details details);
    }

    /**
     * 获取即将上映数据源
     */
    public static void getIIsHitData(final DetailsData.DetailsDataLoadListener loadListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.DETAILS_MOVIE)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    Details details = gson.fromJson(data, Details.class);

                    //接口回调
                    loadListener.onIsHitLoadEnd(details);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
