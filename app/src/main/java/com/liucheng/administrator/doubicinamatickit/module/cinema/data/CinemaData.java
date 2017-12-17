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
    public static void getNewsData(final CinemaData.CinemaLoadListener loadListener, final int cityId) {
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

//String data = "[{\"address\":\"上海市徐汇区淮海中路999号环贸广场L6-1\",\"baiduLatitude\":31.221869,\"baiduLongitude\":121.46461,\"cinameName\":\"上海百丽宫影城环贸iapm店\",\"cinemaId\":4249,\"couponActivityList\":[],\"districtID\":1583,\"feature\":{\"has3D\":1,\"hasFeature4D\":0,\"hasFeature4K\":0,\"hasFeatureDolby\":0,\"hasFeatureHuge\":0,\"hasIMAX\":1,\"hasLoveseat\":0,\"hasPark\":1,\"hasServiceTicket\":1,\"hasVIP\":0,\"hasWifi\":1},\"isETicket\":true,\"isTicket\":true,\"latitude\":31.216019,\"longitude\":121.45732,\"minPrice\":5900,\"movieCount\":16,\"ratingFinal\":7.7836256,\"showtimeCount\":67}]";
                  //  String data ="[{\"address\":\"上海市虹口区西江湾路388号凯德龙之梦B座6F-7F\"},{\"address\":\"上海市徐汇区淮海中路999号环贸广场L6-1\"}]";


                   // String data1 = data.substring(1,data.length()-1);
                    String data = response.body().string();
                    StringBuffer s = new StringBuffer("{\"cinema\":");
                    s.append(data);
                    s.append("}");
                    Gson gson = new Gson();
                    Cinema cinema = gson.fromJson(s.toString(), Cinema.class);

                    Log.i("TAG", "run: "+cinema.toString());

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
