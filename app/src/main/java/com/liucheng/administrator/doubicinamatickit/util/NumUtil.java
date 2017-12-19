package com.liucheng.administrator.doubicinamatickit.util;

/**
 * Created by 邹柳钦 on 2017/12/18 0018.
 * 四舍五入保留小数点2位数
 */

public class NumUtil {

    public static double getNum(double num) {

        return (double) (Math.round(num * 100)) / 100;
    }

}
