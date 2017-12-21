package com.liucheng.administrator.doubicinamatickit.module.find.data;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.DetailNew;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/21 0021.
 */

public class DetailNewData {
    /**
     * 接口回调
     */
    public interface DetailNewDataLoadListener {
        void onDetailNewDataLoadEnd(DetailNew detailNewData);
    }

    /**
     * 获取电影资讯数据源
     */
    public static void getNewsData(final DetailNewData.DetailNewDataLoadListener loadListener, final String pageNumber) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.NEWS_DETAILS + pageNumber+IUrl.NEWS_PAGE)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    DetailNew detailNew = gson.fromJson(data, DetailNew.class);


                    if (loadListener!=null&&detailNew!=null){

                        //接口回调
                        loadListener.onDetailNewDataLoadEnd(detailNew);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
