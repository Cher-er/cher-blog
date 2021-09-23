package com.cher.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {

    private Integer id;
    private String title;
    private String description;
    private String content;
    private Integer viewCount;
    private String picUrl;
    private Boolean recommend;
    private Boolean appreciate;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer statement;

    private User user;
    private Type type;

    public Blog() {
    }

    public Blog(Integer id, Integer viewCount) {
        this.id = id;
        this.viewCount = viewCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getAppreciate() {
        return appreciate;
    }

    public void setAppreciate(Boolean appreciate) {
        this.appreciate = appreciate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatement() {
        return statement;
    }

    public void setStatement(Integer statement) {
        this.statement = statement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", picUrl='" + picUrl + '\'' +
                ", recommend=" + recommend +
                ", appreciate=" + appreciate +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", statement='" + statement + '\'' +
                ", user=" + user +
                ", type=" + type +
                '}';
    }
}
