package com.liucheng.administrator.doubicinamatickit.util;

/**
 * Created by 邹柳钦 on 2017/12/18 0018.
 * 根据2点经纬度  计算距离
 *
 */

public class DistanceUtil {
    private static final double EARTH_RADIUS = 6378137.0;

    /**
     *
     * @param longitude1  第一个点纬度
     * @param latitude1 第一个点经度
     * @param longitude2 第二个点纬度
     * @param latitude2 第二个点经度
     * @return 两点距离（米）
     */
    public static double getDistance(double longitude1, double latitude1,
                                     double longitude2, double latitude2) {
        double Lat1 = rad(latitude1);
        double Lat2 = rad(latitude2);
        double a = Lat1 - Lat2;
        double b = rad(longitude1) - rad(longitude2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(Lat1) * Math.cos(Lat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
