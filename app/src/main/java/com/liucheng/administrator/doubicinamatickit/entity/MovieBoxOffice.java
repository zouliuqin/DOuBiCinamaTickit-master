package com.liucheng.administrator.doubicinamatickit.entity;

import java.util.List;

/**
 * Created by 邹柳钦 on 2017/11/30 0030.
 */

public class MovieBoxOffice {




    /**票房榜数据
     * 神射手api
     * 请求地址：http://api.shenjian.io/?appid=64f3dae56d5e2b86655c5b7d6dbf121a
     *
     * error_code : 0
     * data : [{"Irank":"1","MovieName":"寻梦环游记","BoxOffice":"1811.89","sumBoxOffice":"20181.77","movieDay":"7","boxPer":"50.33","time":"2017-11-30 18:51:48"},{"Irank":"2","MovieName":"正义联盟","BoxOffice":"616.30","sumBoxOffice":"59377.50","movieDay":"14","boxPer":"17.12","time":"2017-11-30 18:51:48"},{"Irank":"3","MovieName":"追捕","BoxOffice":"314.15","sumBoxOffice":"9603.68","movieDay":"7","boxPer":"8.73","time":"2017-11-30 18:51:48"},{"Irank":"4","MovieName":"引爆者","BoxOffice":"193.12","sumBoxOffice":"4529.73","movieDay":"7","boxPer":"5.36","time":"2017-11-30 18:51:48"},{"Irank":"5","MovieName":"嘉年华","BoxOffice":"102.91","sumBoxOffice":"1905.48","movieDay":"7","boxPer":"2.86","time":"2017-11-30 18:51:48"},{"Irank":"6","MovieName":"你在哪","BoxOffice":"87.99","sumBoxOffice":"96.20","movieDay":"1","boxPer":"2.44","time":"2017-11-30 18:51:48"},{"Irank":"7","MovieName":"雷神3：诸神黄昏","BoxOffice":"76.70","sumBoxOffice":"74044.31","movieDay":"28","boxPer":"2.13","time":"2017-11-30 18:51:48"},{"Irank":"8","MovieName":"东方快车谋杀案","BoxOffice":"62.43","sumBoxOffice":"22500.96","movieDay":"21","boxPer":"1.73","time":"2017-11-30 18:51:48"},{"Irank":"9","MovieName":"降魔传","BoxOffice":"50.45","sumBoxOffice":"8857.35","movieDay":"14","boxPer":"1.40","time":"2017-11-30 18:51:48"},{"Irank":"10","MovieName":"七十七天","BoxOffice":"37.26","sumBoxOffice":"8441.20","movieDay":"28","boxPer":"1.04","time":"2017-11-30 18:51:48"},{"Irank":"11","MovieName":"其它","BoxOffice":"246.79","sumBoxOffice":"0.00","movieDay":"0","boxPer":"1.00","time":"2017-11-30 18:51:48"}]
     * reason : success
     *
     **/

    private int error_code;
    private String reason;
    private List<DataBean> data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Irank : 1
         * MovieName : 寻梦环游记
         * BoxOffice : 1811.89
         * sumBoxOffice : 20181.77
         * movieDay : 7
         * boxPer : 50.33
         * time : 2017-11-30 18:51:48
         */

        private String Irank;
        private String MovieName;
        private String BoxOffice;
        private String sumBoxOffice;
        private String movieDay;
        private String boxPer;
        private String time;

        public String getIrank() {
            return Irank;
        }

        public void setIrank(String Irank) {
            this.Irank = Irank;
        }

        public String getMovieName() {
            return MovieName;
        }

        public void setMovieName(String MovieName) {
            this.MovieName = MovieName;
        }

        public String getBoxOffice() {
            return BoxOffice;
        }

        public void setBoxOffice(String BoxOffice) {
            this.BoxOffice = BoxOffice;
        }

        public String getSumBoxOffice() {
            return sumBoxOffice;
        }

        public void setSumBoxOffice(String sumBoxOffice) {
            this.sumBoxOffice = sumBoxOffice;
        }

        public String getMovieDay() {
            return movieDay;
        }

        public void setMovieDay(String movieDay) {
            this.movieDay = movieDay;
        }

        public String getBoxPer() {
            return boxPer;
        }

        public void setBoxPer(String boxPer) {
            this.boxPer = boxPer;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
