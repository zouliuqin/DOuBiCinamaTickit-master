package com.liucheng.administrator.doubicinamatickit.util;


/**
 * Created by 邹柳钦 on 2017/12/4 0004.
 */

public class StringUtil {

    //一段话截取其中的数字或者.
    public static String BoxOfficeString(String s) {
       String sb = s.substring(6,s.length());

        return  sb;

    }
}