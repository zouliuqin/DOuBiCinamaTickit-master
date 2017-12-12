package com.liucheng.administrator.doubicinamatickit.module.find.data;

import android.util.Log;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.entity.BoxOffice;
import com.liucheng.administrator.doubicinamatickit.entity.IUrl;
import com.liucheng.administrator.doubicinamatickit.entity.MovieBoxOffice;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 邹柳钦 on 2017/11/30 0030.
 */

public class BoxOfficeData {

    /**
     * 票房接口回调
     */
    public interface BoxOfficeLoadListener {
        void onBoxOfficeLoadEnd(BoxOffice boxOffice);
    }

    /**
     * 获取电影票房数据源
     */
    public static void getNewsData(final BoxOfficeLoadListener loadListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient实例
                    OkHttpClient client = new OkHttpClient();
                    //创建request实例
                    Request request = new Request.Builder()
                            //设置url
                            .url(IUrl.BOX_OFFICE)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();

                    Gson gson = new Gson();
                    BoxOffice boxOffice = gson.fromJson(data, BoxOffice.class);

                    if (boxOffice!=null&&loadListener!=null){
                        Log.i("TAG2", "run: "+loadListener);
                        Log.i("TAG2", "run: "+boxOffice);

                        //接口回调
                        loadListener.onBoxOfficeLoadEnd(boxOffice);

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
