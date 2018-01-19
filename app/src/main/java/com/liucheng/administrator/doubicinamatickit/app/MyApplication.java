package com.liucheng.administrator.doubicinamatickit.app;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.module.cityselector.citychoose.SharedPreferencesUtil;
import com.liucheng.administrator.doubicinamatickit.ui.MainActivity;
import com.liucheng.administrator.doubicinamatickit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;


/**
 * Created by 邹柳钦 on 2017/11/4 0004.
 */

public class MyApplication extends Application   {


    private static Context context;
    /**
     * 默认城市
     */
    private static String cityName ="武汉" ;
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

        context = getApplicationContext();

        Bmob.initialize(this,"6ec73fd4d4b6c4091e12a6b2d632fcc1");

        //获取城市

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
