package com.liucheng.administrator.doubicinamatickit.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;


public class User extends BmobUser {


    private  String  phoneNumber;
    private String nickname;

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
