package com.liucheng.administrator.doubicinamatickit.module.details_movie.data;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class Details {

    /**
     * type : 2
     * id : 1575990
     * title : 如何不失礼貌的拒绝与国王约饭？
     * title2 : 《至暗时刻》新片段展示丘吉尔政治智慧
     * content : <video src="http://vfx.mtime.cn/Video/2017/11/29/mp4/171129104145304260.mp4" width="320" height="240" poster="http://img5.mtime.cn/mg/2017/11/29/110040.56383146.jpg" controls="controls" data-video-type="1" data-video-id="68616"></video><br><br><div>　　<b>时光网讯</b>&nbsp;二战题材佳作《至暗时刻》将于本周五即12月1日正式登陆中国内地各大院线。今日影片发布正片片段“与国王午餐”，加里·奥德曼饰演的丘吉尔“拒绝”国王的每周约见，尽显率真本性。而两位英国实力演员的默契配合更是将首相与国王之间的微妙关系演绎得惟妙惟肖。</div><div><br></div><div>　　《至暗时刻》讲述了英国“战时首相”丘吉尔带领英国度过的最黑暗的时刻：在纳粹军队的强势围剿下，同盟国家相继溃败，丘吉尔一面要顶住欧洲战况，一面要处理与对立党派的政治交锋，还要面对国王乔治六世的质疑。但最终他以强大的领导力和政治手腕稳住了局面，成功促成30万名士兵的敦刻尔克大撤退。</div><div><br></div><div>　　最新片段“与国王午餐”即丘吉尔刚刚任职首相时与国王乔治六世之间的第一次约谈，当时的境地下，哪怕国王对丘吉尔的任职仍有异议，可两人已经成为“命运共同体”，因此必须一起为英国找到出路。在安东尼·麦卡滕深入的剧本、真实感十足的对话下，再加上加里·奥德曼和本·门德尔森两位优秀演员的演绎，首相与国王间既需相互信任但却又明显互不熟悉的状态呼之欲出，有一种微妙的平衡。用导演乔·赖特的话说，“增加了国王和温斯顿对手戏的力度”。</div><div><br></div><div>　　而奥德曼各种动作、神态、情绪的细节处理更是让丘吉尔这一角色具象而立体，仿佛从历史中重回现实。他背着手，略微驼背，说话时因稍稍紧张而左右小幅度摇晃。同时，因为“总工作到很晚”，在国王提出下午4点见面时毫不犹豫地拒绝，“我4点时要小睡”，这也让丘吉尔显得生活气息十足，甚至让人感觉到其性格中那些幽默、率性而为的部分。</div><div><br></div><div>　　Screen Crush的记者称赞奥德曼的表演“摒弃了激烈的长篇大论和痛哭流涕的内心独白，采取了与大多数饰演此类角色的演员都不同的方式，他更注重神韵，发现声音、表情等细小差异”。Collider则在一篇报道里专门提到本·门德尔森的表现，称其在饰演乔治六世时“有一种克制又细致的转变，进一步证明了他作为演员的可塑性”。</div><div><br></div><div>　　《至暗时刻》由乔·赖特执导，安东尼·麦卡滕编剧，主创阵容豪华，包括加里·奥德曼、克里斯汀·斯科特·托马斯、本·门德尔森、莉莉·詹姆斯等一众英国实力派演员与新生代明星。</div><div><br></div><div>　　《至暗时刻》由美国环球影业出品，中国电影集团公司引进，将于12月1日中国内地正式上映。</div>
     * videoList : [{"Img":"http://img5.mtime.cn/mg/2017/11/29/110040.56383146.jpg","VideoPath":"http://vfx.mtime.cn/Video/2017/11/29/mp4/171129104145304260.mp4","VideoId ":68616}]
     * time : 2017-11-29 14:10:40
     * source : Mtime时光网
     * author :
     * editor : Joker
     * url : http://news.mtime.com/2017/11/29/1575990.html
     * wapUrl : http://news.wap.mtime.com/2017/11/29/1575990.html
     * relations : [{"type":1,"id":232987,"name":"至暗时刻","image":"http://img5.mtime.cn/mt/2017/11/07/094706.43314693_1280X720X2.jpg","year":"2017","rating":8.6,"scoreCount":766,"releaseDate":"2017年12月1日","relaseLocation":"中国"},{"type":2,"id":901158,"name":"加里·奥德曼","nameEn":"Gary Oldman","image":"http://img31.mtime.cn/ph/2014/03/14/152409.94920052_1280X720X2.jpg","year":1958,"rating":9.3},{"type":2,"id":951065,"name":"本·门德尔森","nameEn":"Ben Mendelsohn","image":"http://img31.mtime.cn/ph/2016/04/08/100538.43720065_1280X720X2.jpg","year":1969,"rating":8}]
     * previousNewsID : 1575996
     * nextNewsID : 1575992
     * commentCount : 1
     */

    private int type;
    private int id;
    private String title;
    private String title2;
    private String content;
    private String time;
    private String source;
    private String author;
    private String editor;
    private String url;
    private String wapUrl;
    private int previousNewsID;
    private int nextNewsID;
    private int commentCount;
    private List<VideoListBean> videoList;
    private List<RelationsBean> relations;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl;
    }

    public int getPreviousNewsID() {
        return previousNewsID;
    }

    public void setPreviousNewsID(int previousNewsID) {
        this.previousNewsID = previousNewsID;
    }

    public int getNextNewsID() {
        return nextNewsID;
    }

    public void setNextNewsID(int nextNewsID) {
        this.nextNewsID = nextNewsID;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public List<RelationsBean> getRelations() {
        return relations;
    }

    public void setRelations(List<RelationsBean> relations) {
        this.relations = relations;
    }

    public static class VideoListBean {
        /**
         * Img : http://img5.mtime.cn/mg/2017/11/29/110040.56383146.jpg
         * VideoPath : http://vfx.mtime.cn/Video/2017/11/29/mp4/171129104145304260.mp4
         * VideoId  : 68616
         */

        private String Img;
        private String VideoPath;
        private int VideoId;

        public String getImg() {
            return Img;
        }

        public void setImg(String Img) {
            this.Img = Img;
        }

        public String getVideoPath() {
            return VideoPath;
        }

        public void setVideoPath(String VideoPath) {
            this.VideoPath = VideoPath;
        }

        public int getVideoId() {
            return VideoId;
        }

        public void setVideoId(int VideoId) {
            this.VideoId = VideoId;
        }
    }

    public static class RelationsBean {
        /**
         * type : 1
         * id : 232987
         * name : 至暗时刻
         * image : http://img5.mtime.cn/mt/2017/11/07/094706.43314693_1280X720X2.jpg
         * year : 2017
         * rating : 8.6
         * scoreCount : 766
         * releaseDate : 2017年12月1日
         * relaseLocation : 中国
         * nameEn : Gary Oldman
         */

        private int type;
        private int id;
        private String name;
        private String image;
        private String year;
        private double rating;
        private int scoreCount;
        private String releaseDate;
        private String relaseLocation;
        private String nameEn;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getScoreCount() {
            return scoreCount;
        }

        public void setScoreCount(int scoreCount) {
            this.scoreCount = scoreCount;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getRelaseLocation() {
            return relaseLocation;
        }

        public void setRelaseLocation(String relaseLocation) {
            this.relaseLocation = relaseLocation;
        }

        public String getNameEn() {
            return nameEn;
        }

        public void setNameEn(String nameEn) {
            this.nameEn = nameEn;
        }
    }
}
