package com.liucheng.administrator.doubicinamatickit.entity;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 * 影片资讯 数据源
 * "https://api-m.mtime.cn/News/NewsList.api?pageIndex="
 */

public class MovieNews {

    /**
     * code : 1
     * data : {"count":4,"data":[{"imageCount":0,"publishTime":"6小时前","recommendID":"fa6a105c1ca9416a9aa15dfcf5de17a7","dataType":2,"comSpecialObjId":26118627,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"歌舞片《妈妈咪呀2》杀青原班人马回归","titlesmall":"10031363","type":51,"content":"梅姨、布鲁斯南、阿曼达齐聚 明年暑期上映","commentCount":1,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Fri Jan 21 11:20:00 CST 20171678","aId":"10031363","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/110004.55998266.jpg","status":0},{"imageCount":0,"publishTime":"6小时前","recommendID":"e9a8d0a744004f2cb1f708fda03df7b9","dataType":2,"comSpecialObjId":26118521,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"《妖猫传》白居易类似\u201c北漂\u201d渴望成名","titlesmall":"10031361","type":51,"content":"陈凯歌：电影是白乐天被妖猫\u201c催稿\u201d的故事","commentCount":2,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sat Sep 18 11:20:00 CST 20171677","aId":"10031361","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/104003.40665963.jpg","status":1},{"imageCount":0,"publishTime":"6小时前","recommendID":"3522b98462d64dec95c81a4a85086881","dataType":0,"comSpecialObjId":26118515,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"《芳华》票房破5亿已超《潘金莲》","titlesmall":"10031357","type":51,"content":"周五起贺岁档国产三新片入市 竞争白热化","commentCount":2,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sun Jun 27 03:20:00 CST 20171677","aId":"10031357","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/103000.39188848.jpg","status":1},{"imageCount":0,"publishTime":"6小时前","recommendID":"6deaab9d9ab847129924868c6fe0c1ff","dataType":2,"comSpecialObjId":26118514,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"《无问西东》发\u201c只问盛放\u201d预告","titlesmall":"10031208","type":51,"content":"章子怡黄晓明牵手奔跑 众星演绎别样\u201c穿梭\u201d","commentCount":1,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Thu Jun 24 14:13:20 CST 20171677","aId":"10031208","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/103007.99544797.jpg","status":1},{"imageCount":0,"publishTime":"6小时前","recommendID":"aff97b90f53640f680da88ea75fb7025","dataType":2,"comSpecialObjId":26118306,"publicHeadImage":"http://img5.mtime.cn/mg/2017/11/27/164357.32289936.jpg","title":"2018这些日韩新片哪部会引进？","titlesmall":"10031206","type":51,"content":"死神PK东野圭吾 李沧东改编村上春树","commentCount":0,"isShow":"是","publicName":"映画日韩","recommendType":"articles","time":"Tue May 18 18:53:20 CST 20171677","aId":"10031206","publicId":100043,"img1":"http://img5.mtime.cn/mg/2017/12/21/101004.75432199.jpg","status":2},{"imageCount":0,"publishTime":"8小时前","recommendID":"62b70122e64d4d92bf6d4b18b06befbb","dataType":2,"comSpecialObjId":26118144,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"\"神奇动物2\"杀青 \"奎妮\"发视频","titlesmall":"10031343","type":51,"content":"\"小雀斑\"巴黎街头行色匆匆 雅各布恢复记忆?","commentCount":3,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sat Nov 30 03:20:00 CST 20171675","aId":"10031343","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/084000.37726768.jpg","status":1},{"imageCount":0,"publishTime":"8小时前","recommendID":"b2894bc86c274ede889168d735e5cd28","dataType":1,"comSpecialObjId":26118143,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"\"幻视\"与\"卡魔拉\"发\"复联4\"片场自拍","titlesmall":"10031345","type":51,"content":"饭制海报中\"复联\"成员化身\"正联\"风格","commentCount":3,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sat Nov 23 21:20:00 CST 20171675","aId":"10031345","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/090001.53713130.jpg","status":0},{"imageCount":0,"publishTime":"9小时前","recommendID":"577465c6e79a479fbe2a4d28ca45eb3b","dataType":1,"comSpecialObjId":26117957,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"\"卢克天行者\"空降《星球大战8》中国首映","titlesmall":"10031337","type":51,"content":"用整部电影致敬\"莱娅\" 调侃蕾伊父女推测 ","commentCount":5,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Mon Aug 20 08:33:20 CST 20171674","aId":"10031337","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/080002.39610790.jpg","status":0},{"imageCount":0,"publishTime":"9小时前","recommendID":"704b2ec43eaa4d2b80faaf44822c9c84","dataType":0,"comSpecialObjId":26117956,"publicHeadImage":"http://img5.mtime.cn/mg/2017/11/27/164252.81748979.jpg","title":"《功夫熊猫3》之后，\"东梦\"还有这些大动作","titlesmall":"10031188","type":51,"content":"专访东方梦工厂首席创意官 动画版西藏雪人后年问世 ","commentCount":0,"isShow":"是","publicName":"时光专访","recommendType":"articles","time":"Wed Aug 15 23:00:00 CST 20171674","aId":"10031188","publicId":100039,"img1":"http://img5.mtime.cn/mg/2017/12/21/080026.70535134.jpg","status":1},{"imageCount":0,"publishTime":"18小时前","recommendID":"91fde68ed2bd45898de3dfae15b73ab5","dataType":1,"comSpecialObjId":26115402,"publicHeadImage":"http://img5.mtime.cn/mg/2017/11/27/163929.16566537.jpg","title":"《时代》杂志2017年度十佳电影出炉","titlesmall":"10031163","type":51,"content":"岁末已至，北美的媒体也开始各类评选和盘点，今天，美国《时代》杂志公布了他们评选的2017年度十佳电影，史蒂文·斯皮尔伯格执导的《华盛顿邮报》夺魁，成为最被《时代》杂志推崇的年度电影。或许是因为这部电影讲述了美国媒体的勇气，所以脱颖而出。","commentCount":5,"isShow":"是","publicName":"全球拾趣","recommendType":"articles","time":"Tue Oct 02 22:26:40 CST 20171663","aId":"10031163","publicId":100013,"img1":"http://img5.mtime.cn/mg/2017/12/20/222000.96206091.jpg","status":0}]}
     * msg : 成功
     * showMsg :
     */

    private String code;
    private DataBeanX data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX {
        /**
         * count : 4
         * data : [{"imageCount":0,"publishTime":"6小时前","recommendID":"fa6a105c1ca9416a9aa15dfcf5de17a7","dataType":2,"comSpecialObjId":26118627,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"歌舞片《妈妈咪呀2》杀青原班人马回归","titlesmall":"10031363","type":51,"content":"梅姨、布鲁斯南、阿曼达齐聚 明年暑期上映","commentCount":1,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Fri Jan 21 11:20:00 CST 20171678","aId":"10031363","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/110004.55998266.jpg","status":0},{"imageCount":0,"publishTime":"6小时前","recommendID":"e9a8d0a744004f2cb1f708fda03df7b9","dataType":2,"comSpecialObjId":26118521,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"《妖猫传》白居易类似\u201c北漂\u201d渴望成名","titlesmall":"10031361","type":51,"content":"陈凯歌：电影是白乐天被妖猫\u201c催稿\u201d的故事","commentCount":2,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sat Sep 18 11:20:00 CST 20171677","aId":"10031361","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/104003.40665963.jpg","status":1},{"imageCount":0,"publishTime":"6小时前","recommendID":"3522b98462d64dec95c81a4a85086881","dataType":0,"comSpecialObjId":26118515,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"《芳华》票房破5亿已超《潘金莲》","titlesmall":"10031357","type":51,"content":"周五起贺岁档国产三新片入市 竞争白热化","commentCount":2,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sun Jun 27 03:20:00 CST 20171677","aId":"10031357","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/103000.39188848.jpg","status":1},{"imageCount":0,"publishTime":"6小时前","recommendID":"6deaab9d9ab847129924868c6fe0c1ff","dataType":2,"comSpecialObjId":26118514,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"《无问西东》发\u201c只问盛放\u201d预告","titlesmall":"10031208","type":51,"content":"章子怡黄晓明牵手奔跑 众星演绎别样\u201c穿梭\u201d","commentCount":1,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Thu Jun 24 14:13:20 CST 20171677","aId":"10031208","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/103007.99544797.jpg","status":1},{"imageCount":0,"publishTime":"6小时前","recommendID":"aff97b90f53640f680da88ea75fb7025","dataType":2,"comSpecialObjId":26118306,"publicHeadImage":"http://img5.mtime.cn/mg/2017/11/27/164357.32289936.jpg","title":"2018这些日韩新片哪部会引进？","titlesmall":"10031206","type":51,"content":"死神PK东野圭吾 李沧东改编村上春树","commentCount":0,"isShow":"是","publicName":"映画日韩","recommendType":"articles","time":"Tue May 18 18:53:20 CST 20171677","aId":"10031206","publicId":100043,"img1":"http://img5.mtime.cn/mg/2017/12/21/101004.75432199.jpg","status":2},{"imageCount":0,"publishTime":"8小时前","recommendID":"62b70122e64d4d92bf6d4b18b06befbb","dataType":2,"comSpecialObjId":26118144,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"\"神奇动物2\"杀青 \"奎妮\"发视频","titlesmall":"10031343","type":51,"content":"\"小雀斑\"巴黎街头行色匆匆 雅各布恢复记忆?","commentCount":3,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sat Nov 30 03:20:00 CST 20171675","aId":"10031343","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/084000.37726768.jpg","status":1},{"imageCount":0,"publishTime":"8小时前","recommendID":"b2894bc86c274ede889168d735e5cd28","dataType":1,"comSpecialObjId":26118143,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"\"幻视\"与\"卡魔拉\"发\"复联4\"片场自拍","titlesmall":"10031345","type":51,"content":"饭制海报中\"复联\"成员化身\"正联\"风格","commentCount":3,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Sat Nov 23 21:20:00 CST 20171675","aId":"10031345","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/090001.53713130.jpg","status":0},{"imageCount":0,"publishTime":"9小时前","recommendID":"577465c6e79a479fbe2a4d28ca45eb3b","dataType":1,"comSpecialObjId":26117957,"publicHeadImage":"http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg","title":"\"卢克天行者\"空降《星球大战8》中国首映","titlesmall":"10031337","type":51,"content":"用整部电影致敬\"莱娅\" 调侃蕾伊父女推测 ","commentCount":5,"isShow":"是","publicName":"时光快讯","recommendType":"articles","time":"Mon Aug 20 08:33:20 CST 20171674","aId":"10031337","publicId":100037,"img1":"http://img5.mtime.cn/mg/2017/12/21/080002.39610790.jpg","status":0},{"imageCount":0,"publishTime":"9小时前","recommendID":"704b2ec43eaa4d2b80faaf44822c9c84","dataType":0,"comSpecialObjId":26117956,"publicHeadImage":"http://img5.mtime.cn/mg/2017/11/27/164252.81748979.jpg","title":"《功夫熊猫3》之后，\"东梦\"还有这些大动作","titlesmall":"10031188","type":51,"content":"专访东方梦工厂首席创意官 动画版西藏雪人后年问世 ","commentCount":0,"isShow":"是","publicName":"时光专访","recommendType":"articles","time":"Wed Aug 15 23:00:00 CST 20171674","aId":"10031188","publicId":100039,"img1":"http://img5.mtime.cn/mg/2017/12/21/080026.70535134.jpg","status":1},{"imageCount":0,"publishTime":"18小时前","recommendID":"91fde68ed2bd45898de3dfae15b73ab5","dataType":1,"comSpecialObjId":26115402,"publicHeadImage":"http://img5.mtime.cn/mg/2017/11/27/163929.16566537.jpg","title":"《时代》杂志2017年度十佳电影出炉","titlesmall":"10031163","type":51,"content":"岁末已至，北美的媒体也开始各类评选和盘点，今天，美国《时代》杂志公布了他们评选的2017年度十佳电影，史蒂文·斯皮尔伯格执导的《华盛顿邮报》夺魁，成为最被《时代》杂志推崇的年度电影。或许是因为这部电影讲述了美国媒体的勇气，所以脱颖而出。","commentCount":5,"isShow":"是","publicName":"全球拾趣","recommendType":"articles","time":"Tue Oct 02 22:26:40 CST 20171663","aId":"10031163","publicId":100013,"img1":"http://img5.mtime.cn/mg/2017/12/20/222000.96206091.jpg","status":0}]
         */

        private int count;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * imageCount : 0
             * publishTime : 6小时前
             * recommendID : fa6a105c1ca9416a9aa15dfcf5de17a7
             * dataType : 2
             * comSpecialObjId : 26118627
             * publicHeadImage : http://img5.mtime.cn/mg/2017/06/05/171025.60475309.jpg
             * title : 歌舞片《妈妈咪呀2》杀青原班人马回归
             * titlesmall : 10031363
             * type : 51
             * content : 梅姨、布鲁斯南、阿曼达齐聚 明年暑期上映
             * commentCount : 1
             * isShow : 是
             * publicName : 时光快讯
             * recommendType : articles
             * time : Fri Jan 21 11:20:00 CST 20171678
             * aId : 10031363
             * publicId : 100037
             * img1 : http://img5.mtime.cn/mg/2017/12/21/110004.55998266.jpg
             * status : 0
             */

            private int imageCount;
            private String publishTime;
            private String recommendID;
            private int dataType;
            private int comSpecialObjId;
            private String publicHeadImage;
            private String title;
            private String titlesmall;
            private int type;
            private String content;
            private int commentCount;
            private String isShow;
            private String publicName;
            private String recommendType;
            private String time;
            private String aId;
            private int publicId;
            private String img1;
            private int status;

            public int getImageCount() {
                return imageCount;
            }

            public void setImageCount(int imageCount) {
                this.imageCount = imageCount;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getRecommendID() {
                return recommendID;
            }

            public void setRecommendID(String recommendID) {
                this.recommendID = recommendID;
            }

            public int getDataType() {
                return dataType;
            }

            public void setDataType(int dataType) {
                this.dataType = dataType;
            }

            public int getComSpecialObjId() {
                return comSpecialObjId;
            }

            public void setComSpecialObjId(int comSpecialObjId) {
                this.comSpecialObjId = comSpecialObjId;
            }

            public String getPublicHeadImage() {
                return publicHeadImage;
            }

            public void setPublicHeadImage(String publicHeadImage) {
                this.publicHeadImage = publicHeadImage;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitlesmall() {
                return titlesmall;
            }

            public void setTitlesmall(String titlesmall) {
                this.titlesmall = titlesmall;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public String getIsShow() {
                return isShow;
            }

            public void setIsShow(String isShow) {
                this.isShow = isShow;
            }

            public String getPublicName() {
                return publicName;
            }

            public void setPublicName(String publicName) {
                this.publicName = publicName;
            }

            public String getRecommendType() {
                return recommendType;
            }

            public void setRecommendType(String recommendType) {
                this.recommendType = recommendType;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getAId() {
                return aId;
            }

            public void setAId(String aId) {
                this.aId = aId;
            }

            public int getPublicId() {
                return publicId;
            }

            public void setPublicId(int publicId) {
                this.publicId = publicId;
            }

            public String getImg1() {
                return img1;
            }

            public void setImg1(String img1) {
                this.img1 = img1;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
