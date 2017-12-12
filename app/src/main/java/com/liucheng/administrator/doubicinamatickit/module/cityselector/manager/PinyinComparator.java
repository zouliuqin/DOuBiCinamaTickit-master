package com.liucheng.administrator.doubicinamatickit.module.cityselector.manager;

import com.liucheng.administrator.doubicinamatickit.module.cityselector.database.City;



import java.util.Comparator;

/**
 * 用来对ListView中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
 */
public class PinyinComparator implements Comparator<City> {



    @Override
    public int compare(City o1, City o2) {
        if (o1.getPinyi().substring(0,1).equals("@")
                || o2.getPinyi().substring(0,1).equals("#")) {
            return -1;
        } else if (o1.getPinyi().substring(0,1).equals("#")
                || o2.getPinyi().substring(0,1).equals("@")) {
            return 1;
        } else {
            return o1.getPinyi().substring(0,1).compareTo(o2.getPinyi().substring(0,1));
        }
    }
}
