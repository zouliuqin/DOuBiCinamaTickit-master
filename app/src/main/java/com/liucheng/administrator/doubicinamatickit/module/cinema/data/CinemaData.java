package com.liucheng.administrator.doubicinamatickit.module.cinema.data;



import android.util.Log;

import com.google.gson.Gson;

import com.google.gson.stream.JsonReader;
import com.liucheng.administrator.doubicinamatickit.entity.BoxOffice;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;


import java.io.IOException;
import java.io.StringReader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 邹柳钦 on 2017/12/17 0017.
 */

public class CinemaData {
    /**
     * 接口回调
     */
    public interface CinemaLoadListener {
        void onCinemaLoadEnd(Cinema cinema);
    }

    /**
     * 获取电影资讯数据源
     */
    public static void getCinemaData(final CinemaData.CinemaLoadListener loadListener, final int cityId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.CINEMA_BY_CITY_ID + cityId)
                            .build();
                    Response response = client.newCall(request).execute();

                    String data = response.body().string();
                    StringBuffer s = new StringBuffer("{\"cinema\":");
                    s.append(data);
                    s.append("}");
                    Gson gson = new Gson();
                    Cinema cinema = gson.fromJson(s.toString(), Cinema.class);

                    Log.i("TAG", "run: "+cinema.getCinema().toString());

                    if (loadListener != null && cinema != null) {
                        //接口回调
                        loadListener.onCinemaLoadEnd(cinema);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
