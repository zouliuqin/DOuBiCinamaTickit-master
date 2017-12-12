package com.liucheng.administrator.doubicinamatickit.module.find.data;

import android.util.Log;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;

import java.io.IOException;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 */

public class NewsData {
    /**
     * 接口回调
     */
    public interface NewsLoadListener {
        void onNewsLoadEnd(MovieNews movieNews);
    }

    /**
     * 获取电影资讯数据源
     */
    public static void getNewsData(final NewsLoadListener loadListener, final int pageNumber) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.MOVIES_NEWS + pageNumber)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    MovieNews movieNews = gson.fromJson(data, MovieNews.class);


                    if (loadListener!=null&&movieNews!=null){
                        Log.i("TAG", "-------------------------------------------");
                        Log.i("TAG", "run: "+loadListener);
                        Log.i("TAG", "run: "+movieNews);
                        Log.i("TAG", "-------------------------------------------");
                        //接口回调
                        loadListener.onNewsLoadEnd(movieNews);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
