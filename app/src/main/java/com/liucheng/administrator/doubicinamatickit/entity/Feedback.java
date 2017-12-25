package com.liucheng.administrator.doubicinamatickit.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by 邹柳钦 on 2017/12/24 0024.
 * 用户问题反馈
 */

public class Feedback  extends BmobObject{

    /**
     * 反馈问题的用户信息
     */
    private  User user;

    /**
     * 反馈问题描述
     */
    private String  describe;
    /**
     * 反馈图片
     */
    private  String img;
    /**
     * 反馈人联系方式
     */
    private String contact;

    public Feedback(User user, String describe, String img, String contact) {
        this.user = user;
        this.describe = describe;
        this.img = img;
        this.contact = contact;
    }

    public Feedback() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
