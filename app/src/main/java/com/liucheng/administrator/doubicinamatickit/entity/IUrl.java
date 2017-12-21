package com.liucheng.administrator.doubicinamatickit.entity;

/**
 * Created by Administrator on 2017/10/29 0029.
 */

public interface IUrl {
    String MOVIES_IS_HIT = "https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=";

    String MOVIES_ON_NEXT = "https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=";

    //影片资讯   参数传入1-10
    String MOVIES_NEWS = "https://ticket-api-m.mtime.cn/choice/feed.api?pageIndex=";
    //新闻详情，传入新闻的ID
    String NEWS_DETAILS ="https://ticket-api-m.mtime.cn/article/detail.api?locationId=561&articleId=";
    String NEWS_PAGE ="&topListPageIndex=1";

    //票房榜
    // String BOX_OFFICE="http://api.shenjian.io/?appid=64f3dae56d5e2b86655c5b7d6dbf121a";

    //正在热映
    String IS_HIT = "https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=290";
    //时光网票房榜
    String BOX_OFFICE = "https://api-m.mtime.cn/TopList/TopListDetailsByRecommend.api?locationId=290&pageSubAreaID=48266&pageIndex=1";
    //即将上映
    String UPCOMING_MOVIE = "https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=290";
    //电影详情
    String DETAILS_MOVIE = "https://ticket-api-m.mtime.cn/movie/detail.api?locationId=290&movieId=";


    //根据城市ID获取全部影院
    String CINEMA_BY_CITY_ID = "https://api-m.mtime.cn/OnlineLocationCinema/OnlineCinemasByCity.api?locationId=";

    //热评
    String REVIEW_MOVIE = "http://ticket-api.m.mtime.cn/movie/hotComment.api?movieId=";
    //全部热评
    String ALL_REVIEW_MOVIE = "http://api.m.mtime.cn/Showtime/HotMovieComments.api?movieId=";
    //热评下标
    String REVIEW_INDEX = "&pageIndex=";

    //电影院当前播放的电影
  //  String  TEST="https://ticket-api-m.mtime.cn/cinema/showtime.api?cinemaId=1306";
    //电影院信息详情locationId 地区号    cinemaId 电影院代号
    //https://ticket-api-m.mtime.cn/cinema/detail.api?locationId=561&cinemaId=9997
    String  TEST = "https://ticket-api-m.mtime.cn/cinema/detail.api?locationId="+"&cinemaId="   ;


}
