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
    /**
     * 默认城市
     */
    private static String cityName = "北京";

    /**
     * 纬度
     */
    private static double Latitude=30.585394;
    /**
     * 经度
     */
    private static double Longitude=114.347122;

    @Override
    public void onCreate() {
        super.onCreate();
//        Pay66.init("49987844faab4f5b8022e612b2ec142c", getApplicationContext());
        context = getApplicationContext();

        Bmob.initialize(this,"6ec73fd4d4b6c4091e12a6b2d632fcc1");
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("TAG", "Max memory is " + maxMemory + "KB");



    }

    public static String getCityName() {
        return cityName;
    }

    public static void setCityName(String cityName) {
        MyApplication.cityName = cityName;
    }

    public static Context getContext() {
        return context;
    }

    public static double getLatitude() {
        return Latitude;
    }

    public static void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public static double getLongitude() {
        return Longitude;
    }

    public static void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
