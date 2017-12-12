package com.liucheng.administrator.doubicinamatickit.entity;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 * 影片详情-数据源
 */

public class MoviesDetails {


     /**
     * code : 1
     * data : {"advertisement":{"advList":[{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"西游伏妖篇（票务）","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2017/0122/210.html"}],"count":1,"error":"","success":true},"basic":{"actors":[{"actorId":913378,"img":"http://img31.mtime.cn/ph/2014/09/01/170748.64755972_1280X720X2.jpg","name":"范·迪塞尔","nameEn":"Vin Diesel","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162613.85098094.jpg","roleName":"Xander Cage"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"commentSpecial":"","community":{},"director":{"directorId":903521,"img":"http://img31.mtime.cn/ph/2016/09/02/144150.57291017_1280X720X2.jpg","name":"D·J·卡卢索","nameEn":"D.J. Caruso"},"festivals":[],"hotRanking":5,"img":"http://img5.mtime.cn/mt/2017/01/05/105822.16893974_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":false,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"107分钟","movieId":125805,"name":"极限特工：终极回归","nameEn":"xXx: The Return of Xander Cage","overallRating":-1,"personCount":123,"quizGame":{},"releaseArea":"中国","releaseDate":"20170210","showCinemaCount":27,"showDay":1486627200,"showtimeCount":14,"stageImg":{"count":124,"list":[{"imgId":7180661,"imgUrl":"http://img31.mtime.cn/pi/2016/04/06/163644.66635601_1280X720X2.jpg"},{"imgId":7301637,"imgUrl":"http://img5.mtime.cn/pi/2016/11/02/174909.42908242_1280X720X2.jpg"},{"imgId":7203067,"imgUrl":"http://img31.mtime.cn/pi/2016/04/07/160807.83892239_1280X720X2.jpg"},{"imgId":7301211,"imgUrl":"http://img5.mtime.cn/pi/2016/11/01/091327.68190533_1280X720X2.jpg"}]},"story":"《极限特工3》将故事聚焦在由范·迪塞尔带头的的特工小队和以甄子丹为首的反派组织之间的对决。在这部作品中，迪塞尔饰演的特工凯奇不再是孤胆英雄，他将与一群出色的伙伴共同作战：塞缪尔·杰克逊饰演的国安局特工，印度女星迪皮卡·帕度柯妮饰演的与凯奇颇有渊源的女猎人，凭借《吸血鬼日记》走红的妮娜·杜波夫扮演的技术专家，《女子监狱》女星露比·罗丝饰演的狙击手，中国当红偶像演员吴亦凡饰演的特工Nicks。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","惊悚"],"url":"https://movie.mtime.com/125805/","video":{"count":18,"hightUrl":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4","img":"http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg","title":"极限特工：终极回归 中国版预告片","url":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980_480.mp4","videoId":64107}},"boxOffice":{"movieId":125805,"ranking":41,"todayBox":0,"todayBoxDes":"","todayBoxDesUnit":"","totalBox":0,"totalBoxDes":"","totalBoxUnit":""},"live":{},"related":{"goodsCount":0,"goodsList":[],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/#!/commerce/list/","type":0}}
     * msg : 成功
     * showMsg :
      *
      * 解析：其中advertisement、related是无关字段，不做解析

      basic：具体内容
      actors：演员信息
      actorId：演员 id
      img：演员照片
      name：演员名
      nameEn：演员英文名
      roleImg：影片中饰演角色图片
      roleName：影片中饰演角色名字
      award：获得的奖项？
      commentSpecial：一句话总结该电影
      community：???
      director：导演信息
      hotRanking：热映排行榜
      img：剧照
      releaseArea：上映地区
      stageImg：影片剧照
      story：剧情简介
      video：预告片
      boxOffice：专业解读内容
      ranking：票房排名
      todayBox：今日实时票房量
      todayBoxDes 和 todayBoxDesUnit：今日实时票房量
      totalBox 和 totalBoxUnit：累计票房量
     */

    private String code;
    private DataBean data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public static class DataBean {
        /**
         * advertisement : {"advList":[{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"西游伏妖篇（票务）","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2017/0122/210.html"}],"count":1,"error":"","success":true}
         * basic : {"actors":[{"actorId":913378,"img":"http://img31.mtime.cn/ph/2014/09/01/170748.64755972_1280X720X2.jpg","name":"范·迪塞尔","nameEn":"Vin Diesel","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162613.85098094.jpg","roleName":"Xander Cage"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"commentSpecial":"","community":{},"director":{"directorId":903521,"img":"http://img31.mtime.cn/ph/2016/09/02/144150.57291017_1280X720X2.jpg","name":"D·J·卡卢索","nameEn":"D.J. Caruso"},"festivals":[],"hotRanking":5,"img":"http://img5.mtime.cn/mt/2017/01/05/105822.16893974_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":false,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"107分钟","movieId":125805,"name":"极限特工：终极回归","nameEn":"xXx: The Return of Xander Cage","overallRating":-1,"personCount":123,"quizGame":{},"releaseArea":"中国","releaseDate":"20170210","showCinemaCount":27,"showDay":1486627200,"showtimeCount":14,"stageImg":{"count":124,"list":[{"imgId":7180661,"imgUrl":"http://img31.mtime.cn/pi/2016/04/06/163644.66635601_1280X720X2.jpg"},{"imgId":7301637,"imgUrl":"http://img5.mtime.cn/pi/2016/11/02/174909.42908242_1280X720X2.jpg"},{"imgId":7203067,"imgUrl":"http://img31.mtime.cn/pi/2016/04/07/160807.83892239_1280X720X2.jpg"},{"imgId":7301211,"imgUrl":"http://img5.mtime.cn/pi/2016/11/01/091327.68190533_1280X720X2.jpg"}]},"story":"《极限特工3》将故事聚焦在由范·迪塞尔带头的的特工小队和以甄子丹为首的反派组织之间的对决。在这部作品中，迪塞尔饰演的特工凯奇不再是孤胆英雄，他将与一群出色的伙伴共同作战：塞缪尔·杰克逊饰演的国安局特工，印度女星迪皮卡·帕度柯妮饰演的与凯奇颇有渊源的女猎人，凭借《吸血鬼日记》走红的妮娜·杜波夫扮演的技术专家，《女子监狱》女星露比·罗丝饰演的狙击手，中国当红偶像演员吴亦凡饰演的特工Nicks。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","惊悚"],"url":"https://movie.mtime.com/125805/","video":{"count":18,"hightUrl":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4","img":"http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg","title":"极限特工：终极回归 中国版预告片","url":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980_480.mp4","videoId":64107}}
         * boxOffice : {"movieId":125805,"ranking":41,"todayBox":0,"todayBoxDes":"","todayBoxDesUnit":"","totalBox":0,"totalBoxDes":"","totalBoxUnit":""}
         * live : {}
         * related : {"goodsCount":0,"goodsList":[],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/#!/commerce/list/","type":0}
         */

        private AdvertisementBean advertisement;
        private BasicBean basic;
        private BoxOfficeBean boxOffice;
        private LiveBean live;
        private RelatedBean related;

        public AdvertisementBean getAdvertisement() {
            return advertisement;
        }

        public void setAdvertisement(AdvertisementBean advertisement) {
            this.advertisement = advertisement;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public BoxOfficeBean getBoxOffice() {
            return boxOffice;
        }

        public void setBoxOffice(BoxOfficeBean boxOffice) {
            this.boxOffice = boxOffice;
        }

        public LiveBean getLive() {
            return live;
        }

        public void setLive(LiveBean live) {
            this.live = live;
        }

        public RelatedBean getRelated() {
            return related;
        }

        public void setRelated(RelatedBean related) {
            this.related = related;
        }

        public static class AdvertisementBean {
            /**
             * advList : [{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"西游伏妖篇（票务）","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2017/0122/210.html"}]
             * count : 1
             * error :
             * success : true
             */

            private int count;
            private String error;
            private boolean success;
            private List<AdvListBean> advList;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public List<AdvListBean> getAdvList() {
                return advList;
            }

            public void setAdvList(List<AdvListBean> advList) {
                this.advList = advList;
            }

            public static class AdvListBean {
                /**
                 * advTag :
                 * endDate : 1514649599
                 * isHorizontalScreen : false
                 * isOpenH5 : false
                 * startDate : 1451577600
                 * tag : 西游伏妖篇（票务）
                 * type : 203
                 * typeName : 影片详情页banner2
                 * url : https://static4da.mtime.cn/feature/mobile/banner/2017/0122/210.html
                 */

                private String advTag;
                private int endDate;
                private boolean isHorizontalScreen;
                private boolean isOpenH5;
                private int startDate;
                private String tag;
                private String type;
                private String typeName;
                private String url;

                public String getAdvTag() {
                    return advTag;
                }

                public void setAdvTag(String advTag) {
                    this.advTag = advTag;
                }

                public int getEndDate() {
                    return endDate;
                }

                public void setEndDate(int endDate) {
                    this.endDate = endDate;
                }

                public boolean isIsHorizontalScreen() {
                    return isHorizontalScreen;
                }

                public void setIsHorizontalScreen(boolean isHorizontalScreen) {
                    this.isHorizontalScreen = isHorizontalScreen;
                }

                public boolean isIsOpenH5() {
                    return isOpenH5;
                }

                public void setIsOpenH5(boolean isOpenH5) {
                    this.isOpenH5 = isOpenH5;
                }

                public int getStartDate() {
                    return startDate;
                }

                public void setStartDate(int startDate) {
                    this.startDate = startDate;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class BasicBean {
            /**
             * actors : [{"actorId":913378,"img":"http://img31.mtime.cn/ph/2014/09/01/170748.64755972_1280X720X2.jpg","name":"范·迪塞尔","nameEn":"Vin Diesel","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162613.85098094.jpg","roleName":"Xander Cage"}]
             * award : {"awardList":[],"totalNominateAward":0,"totalWinAward":0}
             * commentSpecial :
             * community : {}
             * director : {"directorId":903521,"img":"http://img31.mtime.cn/ph/2016/09/02/144150.57291017_1280X720X2.jpg","name":"D·J·卡卢索","nameEn":"D.J. Caruso"}
             * festivals : []
             * hotRanking : 5
             * img : http://img5.mtime.cn/mt/2017/01/05/105822.16893974_1280X720X2.jpg
             * is3D : true
             * isDMAX : true
             * isEggHunt : false
             * isFilter : false
             * isIMAX : false
             * isIMAX3D : true
             * isTicket : true
             * message : 该操作将清除您对该片的评分！是否确认？
             * mins : 107分钟
             * movieId : 125805
             * name : 极限特工：终极回归
             * nameEn : xXx: The Return of Xander Cage
             * overallRating : -1
             * personCount : 123
             * quizGame : {}
             * releaseArea : 中国
             * releaseDate : 20170210
             * showCinemaCount : 27
             * showDay : 1486627200
             * showtimeCount : 14
             * stageImg : {"count":124,"list":[{"imgId":7180661,"imgUrl":"http://img31.mtime.cn/pi/2016/04/06/163644.66635601_1280X720X2.jpg"},{"imgId":7301637,"imgUrl":"http://img5.mtime.cn/pi/2016/11/02/174909.42908242_1280X720X2.jpg"},{"imgId":7203067,"imgUrl":"http://img31.mtime.cn/pi/2016/04/07/160807.83892239_1280X720X2.jpg"},{"imgId":7301211,"imgUrl":"http://img5.mtime.cn/pi/2016/11/01/091327.68190533_1280X720X2.jpg"}]}
             * story : 《极限特工3》将故事聚焦在由范·迪塞尔带头的的特工小队和以甄子丹为首的反派组织之间的对决。在这部作品中，迪塞尔饰演的特工凯奇不再是孤胆英雄，他将与一群出色的伙伴共同作战：塞缪尔·杰克逊饰演的国安局特工，印度女星迪皮卡·帕度柯妮饰演的与凯奇颇有渊源的女猎人，凭借《吸血鬼日记》走红的妮娜·杜波夫扮演的技术专家，《女子监狱》女星露比·罗丝饰演的狙击手，中国当红偶像演员吴亦凡饰演的特工Nicks。
             * style : {"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""}
             * totalNominateAward : 0
             * totalWinAward : 0
             * type : ["动作","冒险","惊悚"]
             * url : https://movie.mtime.com/125805/
             * video : {"count":18,"hightUrl":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4","img":"http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg","title":"极限特工：终极回归 中国版预告片","url":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980_480.mp4","videoId":64107}
             */

            private AwardBean award;
            private String commentSpecial;
            private CommunityBean community;
            private DirectorBean director;
            private int hotRanking;
            private String img;
            private boolean is3D;
            private boolean isDMAX;
            private boolean isEggHunt;
            private boolean isFilter;
            private boolean isIMAX;
            private boolean isIMAX3D;
            private boolean isTicket;
            private String message;
            private String mins;
            private int movieId;
            private String name;
            private String nameEn;
            private int overallRating;
            private int personCount;
            private QuizGameBean quizGame;
            private String releaseArea;
            private String releaseDate;
            private int showCinemaCount;
            private int showDay;
            private int showtimeCount;
            private StageImgBean stageImg;
            private String story;
            private StyleBean style;
            private int totalNominateAward;
            private int totalWinAward;
            private String url;
            private VideoBean video;
            private List<ActorsBean> actors;
            private List<?> festivals;
            private List<String> type;

            public AwardBean getAward() {
                return award;
            }

            public void setAward(AwardBean award) {
                this.award = award;
            }

            public String getCommentSpecial() {
                return commentSpecial;
            }

            public void setCommentSpecial(String commentSpecial) {
                this.commentSpecial = commentSpecial;
            }

            public CommunityBean getCommunity() {
                return community;
            }

            public void setCommunity(CommunityBean community) {
                this.community = community;
            }

            public DirectorBean getDirector() {
                return director;
            }

            public void setDirector(DirectorBean director) {
                this.director = director;
            }

            public int getHotRanking() {
                return hotRanking;
            }

            public void setHotRanking(int hotRanking) {
                this.hotRanking = hotRanking;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public boolean isIs3D() {
                return is3D;
            }

            public void setIs3D(boolean is3D) {
                this.is3D = is3D;
            }

            public boolean isIsDMAX() {
                return isDMAX;
            }

            public void setIsDMAX(boolean isDMAX) {
                this.isDMAX = isDMAX;
            }

            public boolean isIsEggHunt() {
                return isEggHunt;
            }

            public void setIsEggHunt(boolean isEggHunt) {
                this.isEggHunt = isEggHunt;
            }

            public boolean isIsFilter() {
                return isFilter;
            }

            public void setIsFilter(boolean isFilter) {
                this.isFilter = isFilter;
            }

            public boolean isIsIMAX() {
                return isIMAX;
            }

            public void setIsIMAX(boolean isIMAX) {
                this.isIMAX = isIMAX;
            }

            public boolean isIsIMAX3D() {
                return isIMAX3D;
            }

            public void setIsIMAX3D(boolean isIMAX3D) {
                this.isIMAX3D = isIMAX3D;
            }

            public boolean isIsTicket() {
                return isTicket;
            }

            public void setIsTicket(boolean isTicket) {
                this.isTicket = isTicket;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getMins() {
                return mins;
            }

            public void setMins(String mins) {
                this.mins = mins;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNameEn() {
                return nameEn;
            }

            public void setNameEn(String nameEn) {
                this.nameEn = nameEn;
            }

            public int getOverallRating() {
                return overallRating;
            }

            public void setOverallRating(int overallRating) {
                this.overallRating = overallRating;
            }

            public int getPersonCount() {
                return personCount;
            }

            public void setPersonCount(int personCount) {
                this.personCount = personCount;
            }

            public QuizGameBean getQuizGame() {
                return quizGame;
            }

            public void setQuizGame(QuizGameBean quizGame) {
                this.quizGame = quizGame;
            }

            public String getReleaseArea() {
                return releaseArea;
            }

            public void setReleaseArea(String releaseArea) {
                this.releaseArea = releaseArea;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public int getShowCinemaCount() {
                return showCinemaCount;
            }

            public void setShowCinemaCount(int showCinemaCount) {
                this.showCinemaCount = showCinemaCount;
            }

            public int getShowDay() {
                return showDay;
            }

            public void setShowDay(int showDay) {
                this.showDay = showDay;
            }

            public int getShowtimeCount() {
                return showtimeCount;
            }

            public void setShowtimeCount(int showtimeCount) {
                this.showtimeCount = showtimeCount;
            }

            public StageImgBean getStageImg() {
                return stageImg;
            }

            public void setStageImg(StageImgBean stageImg) {
                this.stageImg = stageImg;
            }

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public int getTotalNominateAward() {
                return totalNominateAward;
            }

            public void setTotalNominateAward(int totalNominateAward) {
                this.totalNominateAward = totalNominateAward;
            }

            public int getTotalWinAward() {
                return totalWinAward;
            }

            public void setTotalWinAward(int totalWinAward) {
                this.totalWinAward = totalWinAward;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public VideoBean getVideo() {
                return video;
            }

            public void setVideo(VideoBean video) {
                this.video = video;
            }

            public List<ActorsBean> getActors() {
                return actors;
            }

            public void setActors(List<ActorsBean> actors) {
                this.actors = actors;
            }

            public List<?> getFestivals() {
                return festivals;
            }

            public void setFestivals(List<?> festivals) {
                this.festivals = festivals;
            }

            public List<String> getType() {
                return type;
            }

            public void setType(List<String> type) {
                this.type = type;
            }

            public static class AwardBean {
            }

            public static class CommunityBean {
            }

            public static class DirectorBean {
            }

            public static class QuizGameBean {
            }

            public static class StageImgBean {
                /**
                 * count : 124
                 * list : [{"imgId":7180661,"imgUrl":"http://img31.mtime.cn/pi/2016/04/06/163644.66635601_1280X720X2.jpg"},{"imgId":7301637,"imgUrl":"http://img5.mtime.cn/pi/2016/11/02/174909.42908242_1280X720X2.jpg"},{"imgId":7203067,"imgUrl":"http://img31.mtime.cn/pi/2016/04/07/160807.83892239_1280X720X2.jpg"},{"imgId":7301211,"imgUrl":"http://img5.mtime.cn/pi/2016/11/01/091327.68190533_1280X720X2.jpg"}]
                 */

                private int count;
                private List<ListBean> list;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * imgId : 7180661
                     * imgUrl : http://img31.mtime.cn/pi/2016/04/06/163644.66635601_1280X720X2.jpg
                     */

                    private int imgId;
                    private String imgUrl;

                    public int getImgId() {
                        return imgId;
                    }

                    public void setImgId(int imgId) {
                        this.imgId = imgId;
                    }

                    public String getImgUrl() {
                        return imgUrl;
                    }

                    public void setImgUrl(String imgUrl) {
                        this.imgUrl = imgUrl;
                    }
                }
            }

            public static class StyleBean {
                /**
                 * isLeadPage : 0
                 * leadImg : https://img2.mtime.cn/mg/.jpg
                 * leadUrl :
                 */

                private int isLeadPage;
                private String leadImg;
                private String leadUrl;

                public int getIsLeadPage() {
                    return isLeadPage;
                }

                public void setIsLeadPage(int isLeadPage) {
                    this.isLeadPage = isLeadPage;
                }

                public String getLeadImg() {
                    return leadImg;
                }

                public void setLeadImg(String leadImg) {
                    this.leadImg = leadImg;
                }

                public String getLeadUrl() {
                    return leadUrl;
                }

                public void setLeadUrl(String leadUrl) {
                    this.leadUrl = leadUrl;
                }
            }

            public static class VideoBean {
                /**
                 * count : 18
                 * hightUrl : https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4
                 * img : http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg
                 * title : 极限特工：终极回归 中国版预告片
                 * url : https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980_480.mp4
                 * videoId : 64107
                 */

                private int count;
                private String hightUrl;
                private String img;
                private String title;
                private String url;
                private int videoId;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getHightUrl() {
                    return hightUrl;
                }

                public void setHightUrl(String hightUrl) {
                    this.hightUrl = hightUrl;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
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

            public static class ActorsBean {
                /**
                 * actorId : 913378
                 * img : http://img31.mtime.cn/ph/2014/09/01/170748.64755972_1280X720X2.jpg
                 * name : 范·迪塞尔
                 * nameEn : Vin Diesel
                 * roleImg : http://img5.mtime.cn/mg/2017/01/05/162613.85098094.jpg
                 * roleName : Xander Cage
                 */

                private int actorId;
                private String img;
                private String name;
                private String nameEn;
                private String roleImg;
                private String roleName;

                public int getActorId() {
                    return actorId;
                }

                public void setActorId(int actorId) {
                    this.actorId = actorId;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getNameEn() {
                    return nameEn;
                }

                public void setNameEn(String nameEn) {
                    this.nameEn = nameEn;
                }

                public String getRoleImg() {
                    return roleImg;
                }

                public void setRoleImg(String roleImg) {
                    this.roleImg = roleImg;
                }

                public String getRoleName() {
                    return roleName;
                }

                public void setRoleName(String roleName) {
                    this.roleName = roleName;
                }
            }
        }

        public static class BoxOfficeBean {
        }

        public static class LiveBean {
        }

        public static class RelatedBean {
            /**
             * goodsCount : 0
             * goodsList : []
             * relateId : 0
             * relatedUrl : https://mall-wv.mtime.cn/#!/commerce/list/
             * type : 0
             */

            private int goodsCount;
            private int relateId;
            private String relatedUrl;
            private int type;
            private List<?> goodsList;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getRelateId() {
                return relateId;
            }

            public void setRelateId(int relateId) {
                this.relateId = relateId;
            }

            public String getRelatedUrl() {
                return relatedUrl;
            }

            public void setRelatedUrl(String relatedUrl) {
                this.relatedUrl = relatedUrl;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public List<?> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<?> goodsList) {
                this.goodsList = goodsList;
            }
        }
    }
}
