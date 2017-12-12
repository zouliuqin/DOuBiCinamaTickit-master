package com.liucheng.administrator.doubicinamatickit.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class Location {

    private List<PBean> p;

    @Override
    public String toString() {
        return "Location{" +
                "p=" + p +
                '}';
    }

    public List<PBean> getP() {
        return p;
    }

    public void setP(List<PBean> p) {
        this.p = p;
    }

    public static class PBean {
        /**
         * count : 248
         * id : 292
         * n : 上海
         * pinyinFull : Shanghai
         * pinyinShort : sh
         */

        private int count;
        private int id;
        private String n;
        private String pinyinFull;
        private String pinyinShort;

        @Override
        public String toString() {
            return "PBean{" +
                    "count=" + count +
                    ", id=" + id +
                    ", n='" + n + '\'' +
                    ", pinyinFull='" + pinyinFull + '\'' +
                    ", pinyinShort='" + pinyinShort + '\'' +
                    '}';
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public String getPinyinFull() {
            return pinyinFull;
        }

        public void setPinyinFull(String pinyinFull) {
            this.pinyinFull = pinyinFull;
        }

        public String getPinyinShort() {
            return pinyinShort;
        }

        public void setPinyinShort(String pinyinShort) {
            this.pinyinShort = pinyinShort;
        }
    }
}
