package com.liucheng.administrator.doubicinamatickit.entity;

/**
 * Created by Administrator on 2017/10/29 0029.
 */

public interface IUrl {
    String  MOVIES_IS_HIT = "https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=";

   String MOVIES_ON_NEXT = "https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=";

   //影片资讯   参数传入1-10
    String MOVIES_NEWS="https://api-m.mtime.cn/News/NewsList.api?pageIndex=";
    //票房榜
   // String BOX_OFFICE="http://api.shenjian.io/?appid=64f3dae56d5e2b86655c5b7d6dbf121a";

    //正在热映
    String IS_HIT="https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=290";

    //时光网票房榜
    String BOX_OFFICE="https://api-m.mtime.cn/TopList/TopListDetailsByRecommend.api?locationId=290&pageSubAreaID=48266&pageIndex=1";

}
