package com.liucheng.administrator.doubicinamatickit.module.buy_ticker.data;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class Upcoming {

    private List<AttentionBean> attention;
    private List<MoviecomingsBean> moviecomings;

    public List<AttentionBean> getAttention() {
        return attention;
    }

    public void setAttention(List<AttentionBean> attention) {
        this.attention = attention;
    }

    public List<MoviecomingsBean> getMoviecomings() {
        return moviecomings;
    }

    public void setMoviecomings(List<MoviecomingsBean> moviecomings) {
        this.moviecomings = moviecomings;
    }

    public static class AttentionBean {
        /**
         * actor1 : 大鹏
         * actor2 : 倪妮
         * director : 袁和平
         * id : 229668
         * image : http://img5.mtime.cn/mt/2017/11/15/094642.97308757_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 中国
         * rDay : 15
         * rMonth : 12
         * rYear : 2017
         * releaseDate : 12月15日上映
         * title : 奇门遁甲
         * type : 奇幻 / 动作
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/10/12/213607.85117809.jpg","length":70,"title":"奇门遁甲 奇侠集结预告","url":"http://vfx.mtime.cn/Video/2017/10/12/mp4/171012213527783330.mp4","videoId":67975},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/09/20/181135.30619926.jpg","length":111,"title":"奇门遁甲 先导预告片","url":"http://vfx.mtime.cn/Video/2017/09/20/mp4/170920181533211801.mp4","videoId":67722},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/12/04/221001.86593733.jpg","length":82,"title":"奇门遁甲 \u201c千奇百怪\u201d版预告","url":"http://vfx.mtime.cn/Video/2017/12/04/mp4/171204220844523173.mp4","videoId":68699}]
         * wantedCount : 1921
         */

        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        private List<VideosBean> videos;

        @Override
        public String toString() {
            return "AttentionBean{" +
                    "actor1='" + actor1 + '\'' +
                    ", actor2='" + actor2 + '\'' +
                    ", director='" + director + '\'' +
                    ", id=" + id +
                    ", image='" + image + '\'' +
                    ", isFilter=" + isFilter +
                    ", isTicket=" + isTicket +
                    ", isVideo=" + isVideo +
                    ", locationName='" + locationName + '\'' +
                    ", rDay=" + rDay +
                    ", rMonth=" + rMonth +
                    ", rYear=" + rYear +
                    ", releaseDate='" + releaseDate + '\'' +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    ", videoCount=" + videoCount +
                    ", wantedCount=" + wantedCount +
                    ", videos=" + videos +
                    '}';
        }

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean {
            /**
             * hightUrl :
             * image : http://img5.mtime.cn/mg/2017/10/12/213607.85117809.jpg
             * length : 70
             * title : 奇门遁甲 奇侠集结预告
             * url : http://vfx.mtime.cn/Video/2017/10/12/mp4/171012213527783330.mp4
             * videoId : 67975
             */

            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }

    public static class MoviecomingsBean {
        /**
         * actor1 : 黄轩
         * actor2 : 苗苗
         * director : 冯小刚
         * id : 236404
         * image : http://img5.mtime.cn/mt/2017/12/09/120449.13626053_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 中国
         * rDay : 15
         * rMonth : 12
         * rYear : 2017
         * releaseDate : 12月15日上映
         * title : 芳华
         * type : 爱情 / 剧情 / 战争
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/09/13/205711.58374690.jpg","length":157,"title":"芳华 终极预告","url":"http://vfx.mtime.cn/Video/2017/09/13/mp4/170913205716289107.mp4","videoId":67658},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/08/21/215235.13231694.jpg","length":129,"title":"芳华 偶像版预告片","url":"http://vfx.mtime.cn/Video/2017/08/21/mp4/170821215958499913.mp4","videoId":67224},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/09/04/201231.77778589.jpg","length":38,"title":"芳华 战火青春预告","url":"http://vfx.mtime.cn/Video/2017/09/04/mp4/170904201239795077.mp4","videoId":67488}]
         * wantedCount : 2607
         */

        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        private List<VideosBeanX> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBeanX> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBeanX> videos) {
            this.videos = videos;
        }

        public static class VideosBeanX {
            /**
             * hightUrl :
             * image : http://img5.mtime.cn/mg/2017/09/13/205711.58374690.jpg
             * length : 157
             * title : 芳华 终极预告
             * url : http://vfx.mtime.cn/Video/2017/09/13/mp4/170913205716289107.mp4
             * videoId : 67658
             */

            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }
}
