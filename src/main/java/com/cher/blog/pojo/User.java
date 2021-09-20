package com.cher.blog.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Integer power;
    private String email;
    private String phone;
    private String qq;
    private String wechat;
    private String github;
    private String awatarUrl;
    private String qqQrcodeUrl;
    private String wechatQrcodeUrl;
    private String wechatCollectionCodeUrl;
    private String aplipayCollectionCodeUrl;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getAwatarUrl() {
        return awatarUrl;
    }

    public void setAwatarUrl(String awatarUrl) {
        this.awatarUrl = awatarUrl;
    }

    public String getQqQrcodeUrl() {
        return qqQrcodeUrl;
    }

    public void setQqQrcodeUrl(String qqQrcodeUrl) {
        this.qqQrcodeUrl = qqQrcodeUrl;
    }

    public String getWechatQrcodeUrl() {
        return wechatQrcodeUrl;
    }

    public void setWechatQrcodeUrl(String wechatQrcodeUrl) {
        this.wechatQrcodeUrl = wechatQrcodeUrl;
    }

    public String getWechatCollectionCodeUrl() {
        return wechatCollectionCodeUrl;
    }

    public void setWechatCollectionCodeUrl(String wechatCollectionCodeUrl) {
        this.wechatCollectionCodeUrl = wechatCollectionCodeUrl;
    }

    public String getAplipayCollectionCodeUrl() {
        return aplipayCollectionCodeUrl;
    }

    public void setAplipayCollectionCodeUrl(String aplipayCollectionCodeUrl) {
        this.aplipayCollectionCodeUrl = aplipayCollectionCodeUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", power=" + power +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", github='" + github + '\'' +
                ", awatarUrl='" + awatarUrl + '\'' +
                ", qqQrcodeUrl='" + qqQrcodeUrl + '\'' +
                ", wechatQrcodeUrl='" + wechatQrcodeUrl + '\'' +
                ", wechatCollectionCodeUrl='" + wechatCollectionCodeUrl + '\'' +
                ", aplipayCollectionCodeUrl='" + aplipayCollectionCodeUrl + '\'' +
                '}';
    }
}
