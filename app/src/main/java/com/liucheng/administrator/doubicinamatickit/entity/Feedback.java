package com.liucheng.administrator.doubicinamatickit.entity;

import android.widget.ImageView;

import java.util.List;

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
    private List<String>  img;
    /**
     * 反馈人联系方式
     */
    private String contact;

    public Feedback(User user, String describe, List<String> img, String contact) {
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


    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
