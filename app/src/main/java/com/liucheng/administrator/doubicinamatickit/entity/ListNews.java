package com.liucheng.administrator.doubicinamatickit.entity;

/**
 * Created by 邹柳钦 on 2017/12/16 0016.
 * 首页电影轮播
 */

public class ListNews {
    /**
     * 电影ID
     */
    private  int  movieId;

    /**
     * 电影剧照(用来做轮播图片)
     */
    private  String  img;
    /**
     * 是否是热映电影
     */
    private boolean isHot;

    /**
     * 是否是 IMAX3D 电影
     */
    private boolean isIMAX3D;

    /**
     *是否3D电影
     */
    private  boolean is3D;


    public ListNews() {
    }

    public ListNews(int movieId, String img, boolean isHot, boolean isIMAX3D, boolean is3D) {
        this.movieId = movieId;
        this.img = img;
        this.isHot = isHot;
        this.isIMAX3D = isIMAX3D;
        this.is3D = is3D;
    }

    @Override
    public String toString() {
        return "ListNews{" +
                "movieId=" + movieId +
                ", img='" + img + '\'' +
                ", isHot=" + isHot +
                ", isIMAX3D=" + isIMAX3D +
                ", is3D=" + is3D +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isIMAX3D() {
        return isIMAX3D;
    }

    public void setIMAX3D(boolean IMAX3D) {
        isIMAX3D = IMAX3D;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }
}
