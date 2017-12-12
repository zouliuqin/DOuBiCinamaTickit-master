package com.liucheng.administrator.doubicinamatickit.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.liucheng.administrator.doubicinamatickit.util.StringUtil;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;


/**
 * Created by 邹柳钦 on 2017/11/4 0004.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //初始化Bmob
        //初始化自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config = new BmobConfig.Builder(this)
                ////设置appkey
                .setApplicationId("6ec73fd4d4b6c4091e12a6b2d632fcc1")
                ////请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(30)
                ////文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024 * 1024)
                ////文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);



    }

    public static Context getContext() {
        return context;
    }
}
