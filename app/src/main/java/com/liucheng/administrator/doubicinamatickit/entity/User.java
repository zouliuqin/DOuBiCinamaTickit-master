package com.liucheng.administrator.doubicinamatickit.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;


public class User extends BmobUser {


    private  String  phoneNumber;
    private String nickname;
    /**
     * 性别
     */
    private  String gender;



    /**
     * 用户头像
     */
    private String headPortrait;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
