package com.liucheng.administrator.doubicinamatickit.entity;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 * 即将上映--数据源
 */

public class MovieComingNew {


    /**
     * 解析：

     首先大体分为两个部分 ——

     attention：最受关注
     moviecomings：即将上映
     接下来就是里面具体的字段：

     videos：预告片，不过我们无权访问
     */

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
         * actor1 : 范·迪塞尔
         * actor2 : 露比·罗丝
         * director : D·J·卡卢索
         * id : 125805
         * image : http://img5.mtime.cn/mt/2017/01/05/105822.16893974_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 美国
         * rDay : 10
         * rMonth : 2
         * rYear : 2017
         * releaseDate : 2月10日上映
         * title : 极限特工：终极回归
         * type : 动作 / 冒险 / 惊悚
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/01/05/105124.83548335.jpg","length":30,"title":"极限特工：终极回归 中国版预告片","url":"http://vf.test.com/Video/2017/01/05/mp4/170105105137886980.mp4","videoId":64107},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2016/11/02/082857.54680705.jpg","length":139,"title":"极限特工：终极回归 中文版终极预告片","url":"http://vf.test.com/Video/2016/11/02/mp4/161102083059175649.mp4","videoId":63180},{"hightUrl":"","image":"http://img31.mtime.cn/mg/2016/08/05/122731.94053608.jpg","length":91,"title":"极限特工：终极回归 中文版预告片","url":"http://vf.test.com/Video/2016/08/05/mp4/160805122727094193.mp4","videoId":61933}]
         * wantedCount : 1359
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
             * image : http://img5.mtime.cn/mg/2017/01/05/105124.83548335.jpg
             * length : 30
             * title : 极限特工：终极回归 中国版预告片
             * url : http://vf.test.com/Video/2017/01/05/mp4/170105105137886980.mp4
             * videoId : 64107
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
         * actor1 : 贾乃亮
         * actor2 : 马丽
         * director : 郭大雷
         * id : 230769
         * image : http://img5.mtime.cn/mt/2017/01/16/104630.29361196_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 中国
         * rDay : 3
         * rMonth : 2
         * rYear : 2017
         * releaseDate : 2月3日上映
         * title : 东北往事之破马张飞
         * type : 喜剧
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2016/11/01/211216.75603152.jpg","length":58,"title":"东北往事之破马张飞 先行版预告片","url":"http://vf.test.com/Video/2016/11/01/mp4/161101211204394445.mp4","videoId":63176},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2016/12/06/215919.97317974.jpg","length":89,"title":"东北往事之破马张飞 剧情版预告片","url":"http://vf.test.com/Video/2016/12/06/mp4/161206215730098083.mp4","videoId":63664},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2016/12/29/153033.28636603.jpg","length":53,"title":"东北往事之破马张飞 彩蛋之为金士杰庆生","url":"http://vf.test.com/Video/2016/12/29/mp4/161229153012984378.mp4","videoId":64028}]
         * wantedCount : 1677
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
             * image : http://img5.mtime.cn/mg/2016/11/01/211216.75603152.jpg
             * length : 58
             * title : 东北往事之破马张飞 先行版预告片
             * url : http://vf.test.com/Video/2016/11/01/mp4/161101211204394445.mp4
             * videoId : 63176
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
