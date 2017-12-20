package com.liucheng.administrator.doubicinamatickit.module.cinemaplaysmovies.data;


import android.content.Context;

import com.liucheng.administrator.doubicinamatickit.entity.CinemaPlaysMovies;
import com.liucheng.administrator.doubicinamatickit.util.LocalJsonResolutionUtils;

/**
 * 虚拟获得本地当前影院正在播放电影的数据
 */
public class CinemaPlaysMoviesData {

    /**
     * 接口回调
     */
    public interface CinemaPlaysMoviesLoadListener {
        void onCinemaPlaysMoviesLoadEnd(CinemaPlaysMovies cinemaPlaysMovies);

    }

    /**
     * 获取电影资讯数据源
     */
    public static void getCinemaPlaysMoviesData(final CinemaPlaysMoviesLoadListener loadListener, Context context) {
        //得到本地json文本内容
        String fileName = "cinema_play_movies.json";
        String cinemaPlayMoviesJson = LocalJsonResolutionUtils.getJson(context, fileName);
        //转换为对象
        CinemaPlaysMovies cinemaPlaysMovies = LocalJsonResolutionUtils.JsonToObject(cinemaPlayMoviesJson, CinemaPlaysMovies.class);

        if (loadListener != null && cinemaPlaysMovies != null) {
            //接口回调
            loadListener.onCinemaPlaysMoviesLoadEnd(cinemaPlaysMovies);

        }
    }
}
