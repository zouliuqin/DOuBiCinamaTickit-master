package com.liucheng.administrator.doubicinamatickit.entity;


import java.util.List;

/**
 * Created by 邹柳钦 on 2017/12/17 0017.
 */

public class Cinema {


    private List<CinemaBean> cinema;

    public List<CinemaBean> getCinema() {
        return cinema;
    }

    public void setCinema(List<CinemaBean> cinema) {
        this.cinema = cinema;
    }



    public static class CinemaBean {
        /**
         * address : 上海市虹口区西江湾路388号凯德龙之梦B座6F-7F
         * baiduLatitude : 31.276552
         * baiduLongitude : 121.48349
         * cinameName : 龙之梦金逸影城
         * cinemaId : 3206
         * couponActivityList : []
         * districtID : 1569
         * feature : {"has3D":0,"hasFeature4D":0,"hasFeature4K":0,"hasFeatureDolby":0,"hasFeatureHuge":0,"hasIMAX":0,"hasLoveseat":0,"hasPark":0,"hasServiceTicket":0,"hasVIP":0,"hasWifi":0}
         * isETicket : true
         * isTicket : true
         * latitude : 31.271248
         * longitude : 121.47867
         * minPrice : 4400
         * movieCount : 17
         * ratingFinal : 6.503255
         * showtimeCount : 162
         */

        private String address;
        private double baiduLatitude;
        private double baiduLongitude;
        private String cinameName;
        private int cinemaId;
        private int districtID;
        private FeatureBean feature;
        private boolean isETicket;
        private boolean isTicket;
        private double latitude;
        private double longitude;
        private int minPrice;
        private int movieCount;
        private double ratingFinal;
        private int showtimeCount;
        private List<?> couponActivityList;

        @Override
        public String toString() {
            return "CinemaBean{" +
                    "address='" + address + '\'' +
                    ", baiduLatitude=" + baiduLatitude +
                    ", baiduLongitude=" + baiduLongitude +
                    ", cinameName='" + cinameName + '\'' +
                    ", cinemaId=" + cinemaId +
                    ", districtID=" + districtID +
                    ", feature=" + feature +
                    ", isETicket=" + isETicket +
                    ", isTicket=" + isTicket +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", minPrice=" + minPrice +
                    ", movieCount=" + movieCount +
                    ", ratingFinal=" + ratingFinal +
                    ", showtimeCount=" + showtimeCount +
                    ", couponActivityList=" + couponActivityList +
                    '}';
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getBaiduLatitude() {
            return baiduLatitude;
        }

        public void setBaiduLatitude(double baiduLatitude) {
            this.baiduLatitude = baiduLatitude;
        }

        public double getBaiduLongitude() {
            return baiduLongitude;
        }

        public void setBaiduLongitude(double baiduLongitude) {
            this.baiduLongitude = baiduLongitude;
        }

        public String getCinameName() {
            return cinameName;
        }

        public void setCinameName(String cinameName) {
            this.cinameName = cinameName;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public int getDistrictID() {
            return districtID;
        }

        public void setDistrictID(int districtID) {
            this.districtID = districtID;
        }

        public FeatureBean getFeature() {
            return feature;
        }

        public void setFeature(FeatureBean feature) {
            this.feature = feature;
        }

        public boolean isIsETicket() {
            return isETicket;
        }

        public void setIsETicket(boolean isETicket) {
            this.isETicket = isETicket;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getMovieCount() {
            return movieCount;
        }

        public void setMovieCount(int movieCount) {
            this.movieCount = movieCount;
        }

        public double getRatingFinal() {
            return ratingFinal;
        }

        public void setRatingFinal(double ratingFinal) {
            this.ratingFinal = ratingFinal;
        }

        public int getShowtimeCount() {
            return showtimeCount;
        }

        public void setShowtimeCount(int showtimeCount) {
            this.showtimeCount = showtimeCount;
        }

        public List<?> getCouponActivityList() {
            return couponActivityList;
        }

        public void setCouponActivityList(List<?> couponActivityList) {
            this.couponActivityList = couponActivityList;
        }

        public static class FeatureBean {
            /**
             * has3D : 0
             * hasFeature4D : 0
             * hasFeature4K : 0
             * hasFeatureDolby : 0
             * hasFeatureHuge : 0
             * hasIMAX : 0
             * hasLoveseat : 0
             * hasPark : 0
             * hasServiceTicket : 0
             * hasVIP : 0
             * hasWifi : 0
             */

            private int has3D;
            private int hasFeature4D;
            private int hasFeature4K;
            private int hasFeatureDolby;
            private int hasFeatureHuge;
            private int hasIMAX;
            private int hasLoveseat;
            private int hasPark;
            private int hasServiceTicket;
            private int hasVIP;
            private int hasWifi;

            public int getHas3D() {
                return has3D;
            }

            public void setHas3D(int has3D) {
                this.has3D = has3D;
            }

            public int getHasFeature4D() {
                return hasFeature4D;
            }

            public void setHasFeature4D(int hasFeature4D) {
                this.hasFeature4D = hasFeature4D;
            }

            public int getHasFeature4K() {
                return hasFeature4K;
            }

            public void setHasFeature4K(int hasFeature4K) {
                this.hasFeature4K = hasFeature4K;
            }

            public int getHasFeatureDolby() {
                return hasFeatureDolby;
            }

            public void setHasFeatureDolby(int hasFeatureDolby) {
                this.hasFeatureDolby = hasFeatureDolby;
            }

            public int getHasFeatureHuge() {
                return hasFeatureHuge;
            }

            public void setHasFeatureHuge(int hasFeatureHuge) {
                this.hasFeatureHuge = hasFeatureHuge;
            }

            public int getHasIMAX() {
                return hasIMAX;
            }

            public void setHasIMAX(int hasIMAX) {
                this.hasIMAX = hasIMAX;
            }

            public int getHasLoveseat() {
                return hasLoveseat;
            }

            public void setHasLoveseat(int hasLoveseat) {
                this.hasLoveseat = hasLoveseat;
            }

            public int getHasPark() {
                return hasPark;
            }

            public void setHasPark(int hasPark) {
                this.hasPark = hasPark;
            }

            public int getHasServiceTicket() {
                return hasServiceTicket;
            }

            public void setHasServiceTicket(int hasServiceTicket) {
                this.hasServiceTicket = hasServiceTicket;
            }

            public int getHasVIP() {
                return hasVIP;
            }

            public void setHasVIP(int hasVIP) {
                this.hasVIP = hasVIP;
            }

            public int getHasWifi() {
                return hasWifi;
            }

            public void setHasWifi(int hasWifi) {
                this.hasWifi = hasWifi;
            }
        }
    }
}
