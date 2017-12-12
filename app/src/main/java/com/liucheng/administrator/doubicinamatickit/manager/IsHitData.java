package com.liucheng.administrator.doubicinamatickit.manager;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;
import com.liucheng.administrator.doubicinamatickit.entity.IsHit;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 邹柳钦 on 2017/12/1 0001.
 */

public class IsHitData {
    /**
     * 接口回调
     */
    public interface IsHitLoadListener {
        void onIsHitLoadEnd(IsHit isHit);
    }

    /**
     * 获取正在热映数据源
     */
    public static void getIIsHitData(final IsHitData.IsHitLoadListener loadListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.IS_HIT)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    IsHit isHit = gson.fromJson(data, IsHit.class);

                    //接口回调
                    loadListener.onIsHitLoadEnd(isHit);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
