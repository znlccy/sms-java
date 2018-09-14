package com.znlccy.sms.common.model;

/**
 * @Author: Administrator
 * @Datetime: 2018/9/14-17:32
 * @Version: v1.0.0
 * @Comment: 
 */
public class User {

    private Integer uid;

    private String username;

    private String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
