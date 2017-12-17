package com.liucheng.administrator.doubicinamatickit.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.liucheng.administrator.doubicinamatickit.app.MyApplication;
import com.liucheng.administrator.doubicinamatickit.entity.Location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class LocationId {
    private LocationId() {

    }

    /**
     * 读取raw文件夹下的文件
     *
     * @param resourceId raw文件夹下的文件资源ID
     * @return 文件内容
     */
    public static int getLocationId(Context context,int resourceId) {


        if (null == context || resourceId < 0) {
            return 0;
        }
         Location location = null;

        BufferedReader reader = null;

        String jsonBuilder = null;
        try {
            InputStream inputStream = context.getResources().openRawResource(resourceId);

            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder builder = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            jsonBuilder = builder.toString();
            //解析字符串
            Gson gson = new Gson();
            location = gson.fromJson(jsonBuilder, Location.class);
            for (int i = 0; i < location.getP().size(); i++) {
                if (MyApplication.getCityName().equals(location.getP().get(i).getN())) {
                    return location.getP().get(i).getId();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

//    public static int getLocationId(Location location) {
//        for (int i = 0; i < location.getP().size(); i++) {
//            if ("武汉".equals(location.getP().get(i).getN())) {
//                return location.getP().get(i).getId();
//            }
//        }
//
//
//        return 0;
//    }


}

