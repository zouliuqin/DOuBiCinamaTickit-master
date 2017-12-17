package com.liucheng.administrator.doubicinamatickit.module.details_movie.data;

import java.util.List;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public class Review {

    /**
     * code : 1
     * data : {"mini":{"list":[{"commentDate":1513471742,"commentId":45222212,"content":"从来胜利都不在于星火永生不灭，而在于，它的燎原","headImg":"http://img2.mtime.cn/images/default/head.gif","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"xrlx","praiseCount":0,"rating":8.1,"replyCount":0},{"commentDate":1513436757,"commentId":45220144,"content":"一定要当心叛逆期青少年。","headImg":"http://img32.mtime.cn/up/2014/04/19/185840.32777899_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"北京","nickname":"镭姬杀手","praiseCount":0,"rating":0,"replyCount":0},{"commentDate":1513367324,"commentId":45213284,"content":"喜欢剧情走向，然而不够黑暗。某一些元素和法则蜜汁第一次出现在电影中(尽管johann告诉我canon中有)，但是真的像武侠奇幻小说....","headImg":"http://img32.mtime.cn/up/2015/02/16/231724.72573077_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"奥斯陆","nickname":"HanselT","praiseCount":0,"rating":7,"replyCount":0}],"total":82},"plus":{"list":[{"commentDate":1492542480,"commentId":8003015,"content":"\r\n\r\n\r\n现在的问题不是 '你看过《星球大战：最后的绝地武士》预告片了吗？'，而是 ' 你看了多少次？'\n\r\n这支预告片上周五在奥兰多星球大战庆祝活动中公布，随即便令全世界影迷都陷入到了极度的兴奋中。这个先行预告片近乎完美，不仅让我们清楚感觉到了莱恩·约翰逊精心制作的这部电影的基调，同时也向我们展示了几个主要人物--重点是雷伊和卢克，还给了我们一些诱人的情节线索。\n\r\n卢克想要终结绝地武士、我们...","headImg":"http://img32.mtime.cn/up/2013/12/10/195719.16304374_128X128.jpg","isWantSee":false,"locationName":"","nickname":"革角力","rating":0,"replyCount":8,"title":"《星球大战8》预告片:13个彩蛋与秘密你可能错过了"}],"total":5}}
     * msg : 成功
     * showMsg :
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
         * mini : {"list":[{"commentDate":1513471742,"commentId":45222212,"content":"从来胜利都不在于星火永生不灭，而在于，它的燎原","headImg":"http://img2.mtime.cn/images/default/head.gif","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"xrlx","praiseCount":0,"rating":8.1,"replyCount":0},{"commentDate":1513436757,"commentId":45220144,"content":"一定要当心叛逆期青少年。","headImg":"http://img32.mtime.cn/up/2014/04/19/185840.32777899_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"北京","nickname":"镭姬杀手","praiseCount":0,"rating":0,"replyCount":0},{"commentDate":1513367324,"commentId":45213284,"content":"喜欢剧情走向，然而不够黑暗。某一些元素和法则蜜汁第一次出现在电影中(尽管johann告诉我canon中有)，但是真的像武侠奇幻小说....","headImg":"http://img32.mtime.cn/up/2015/02/16/231724.72573077_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"奥斯陆","nickname":"HanselT","praiseCount":0,"rating":7,"replyCount":0}],"total":82}
         * plus : {"list":[{"commentDate":1492542480,"commentId":8003015,"content":"\r\n\r\n\r\n现在的问题不是 '你看过《星球大战：最后的绝地武士》预告片了吗？'，而是 ' 你看了多少次？'\n\r\n这支预告片上周五在奥兰多星球大战庆祝活动中公布，随即便令全世界影迷都陷入到了极度的兴奋中。这个先行预告片近乎完美，不仅让我们清楚感觉到了莱恩·约翰逊精心制作的这部电影的基调，同时也向我们展示了几个主要人物--重点是雷伊和卢克，还给了我们一些诱人的情节线索。\n\r\n卢克想要终结绝地武士、我们...","headImg":"http://img32.mtime.cn/up/2013/12/10/195719.16304374_128X128.jpg","isWantSee":false,"locationName":"","nickname":"革角力","rating":0,"replyCount":8,"title":"《星球大战8》预告片:13个彩蛋与秘密你可能错过了"}],"total":5}
         */

        private MiniBean mini;
        private PlusBean plus;

        public MiniBean getMini() {
            return mini;
        }

        public void setMini(MiniBean mini) {
            this.mini = mini;
        }

        public PlusBean getPlus() {
            return plus;
        }

        public void setPlus(PlusBean plus) {
            this.plus = plus;
        }

        public static class MiniBean {
            /**
             * list : [{"commentDate":1513471742,"commentId":45222212,"content":"从来胜利都不在于星火永生不灭，而在于，它的燎原","headImg":"http://img2.mtime.cn/images/default/head.gif","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"xrlx","praiseCount":0,"rating":8.1,"replyCount":0},{"commentDate":1513436757,"commentId":45220144,"content":"一定要当心叛逆期青少年。","headImg":"http://img32.mtime.cn/up/2014/04/19/185840.32777899_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"北京","nickname":"镭姬杀手","praiseCount":0,"rating":0,"replyCount":0},{"commentDate":1513367324,"commentId":45213284,"content":"喜欢剧情走向，然而不够黑暗。某一些元素和法则蜜汁第一次出现在电影中(尽管johann告诉我canon中有)，但是真的像武侠奇幻小说....","headImg":"http://img32.mtime.cn/up/2015/02/16/231724.72573077_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"奥斯陆","nickname":"HanselT","praiseCount":0,"rating":7,"replyCount":0}]
             * total : 82
             */

            private int total;
            private List<ListBean> list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * commentDate : 1513471742
                 * commentId : 45222212
                 * content : 从来胜利都不在于星火永生不灭，而在于，它的燎原
                 * headImg : http://img2.mtime.cn/images/default/head.gif
                 * img :
                 * isHot : false
                 * isPraise : false
                 * locationName :
                 * nickname : xrlx
                 * praiseCount : 0
                 * rating : 8.1
                 * replyCount : 0
                 */

                private int commentDate;
                private int commentId;
                private String content;
                private String headImg;
                private String img;
                private boolean isHot;
                private boolean isPraise;
                private String locationName;
                private String nickname;
                private int praiseCount;
                private double rating;
                private int replyCount;

                public int getCommentDate() {
                    return commentDate;
                }

                public void setCommentDate(int commentDate) {
                    this.commentDate = commentDate;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHeadImg() {
                    return headImg;
                }

                public void setHeadImg(String headImg) {
                    this.headImg = headImg;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public boolean isIsHot() {
                    return isHot;
                }

                public void setIsHot(boolean isHot) {
                    this.isHot = isHot;
                }

                public boolean isIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(boolean isPraise) {
                    this.isPraise = isPraise;
                }

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getPraiseCount() {
                    return praiseCount;
                }

                public void setPraiseCount(int praiseCount) {
                    this.praiseCount = praiseCount;
                }

                public double getRating() {
                    return rating;
                }

                public void setRating(double rating) {
                    this.rating = rating;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }
        }

        public static class PlusBean {
            /**
             * list : [{"commentDate":1492542480,"commentId":8003015,"content":"\r\n\r\n\r\n现在的问题不是 '你看过《星球大战：最后的绝地武士》预告片了吗？'，而是 ' 你看了多少次？'\n\r\n这支预告片上周五在奥兰多星球大战庆祝活动中公布，随即便令全世界影迷都陷入到了极度的兴奋中。这个先行预告片近乎完美，不仅让我们清楚感觉到了莱恩·约翰逊精心制作的这部电影的基调，同时也向我们展示了几个主要人物--重点是雷伊和卢克，还给了我们一些诱人的情节线索。\n\r\n卢克想要终结绝地武士、我们...","headImg":"http://img32.mtime.cn/up/2013/12/10/195719.16304374_128X128.jpg","isWantSee":false,"locationName":"","nickname":"革角力","rating":0,"replyCount":8,"title":"《星球大战8》预告片:13个彩蛋与秘密你可能错过了"}]
             * total : 5
             */

            private int total;
            private List<ListBeanX> list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                /**
                 * commentDate : 1492542480
                 * commentId : 8003015
                 * content :


                 现在的问题不是 '你看过《星球大战：最后的绝地武士》预告片了吗？'，而是 ' 你看了多少次？'

                 这支预告片上周五在奥兰多星球大战庆祝活动中公布，随即便令全世界影迷都陷入到了极度的兴奋中。这个先行预告片近乎完美，不仅让我们清楚感觉到了莱恩·约翰逊精心制作的这部电影的基调，同时也向我们展示了几个主要人物--重点是雷伊和卢克，还给了我们一些诱人的情节线索。

                 卢克想要终结绝地武士、我们...
                 * headImg : http://img32.mtime.cn/up/2013/12/10/195719.16304374_128X128.jpg
                 * isWantSee : false
                 * locationName :
                 * nickname : 革角力
                 * rating : 0
                 * replyCount : 8
                 * title : 《星球大战8》预告片:13个彩蛋与秘密你可能错过了
                 */

                private int commentDate;
                private int commentId;
                private String content;
                private String headImg;
                private boolean isWantSee;
                private String locationName;
                private String nickname;
                private int rating;
                private int replyCount;
                private String title;

                public int getCommentDate() {
                    return commentDate;
                }

                public void setCommentDate(int commentDate) {
                    this.commentDate = commentDate;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHeadImg() {
                    return headImg;
                }

                public void setHeadImg(String headImg) {
                    this.headImg = headImg;
                }

                public boolean isIsWantSee() {
                    return isWantSee;
                }

                public void setIsWantSee(boolean isWantSee) {
                    this.isWantSee = isWantSee;
                }

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getRating() {
                    return rating;
                }

                public void setRating(int rating) {
                    this.rating = rating;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
