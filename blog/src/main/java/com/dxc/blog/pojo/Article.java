package com.dxc.blog.pojo;

import java.util.Date;
import java.util.List;

public class Article {
    private Integer articleId;
    private String title;
    private Integer viewCount;
    private Integer classifyId;
    private String contextSynopsis;
    private String context;
    private Date createTime;
    private Date updateTime;
    private List<Integer> labelId;

    public Article() {
    }

    public Article(String title, Integer classifyId, String contextSynopsis, String context, Date createTime, Date updateTime, List<Integer> labelId) {
        this.title = title;
        this.classifyId = classifyId;
        this.contextSynopsis = contextSynopsis;
        this.context = context;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.labelId = labelId;
    }

    public Article(Integer articleId, String title, Integer classifyId, String contextSynopsis, String context, Date updateTime, List<Integer> labelId) {
        this.articleId = articleId;
        this.title = title;
        this.classifyId = classifyId;
        this.contextSynopsis = contextSynopsis;
        this.context = context;
        this.updateTime = updateTime;
        this.labelId = labelId;
    }

    public Article(Integer articleId, Integer viewCount) {
        this.articleId = articleId;
        this.viewCount = viewCount;
    }

    public Article(Integer articleId, String title, Integer viewCount, Integer classifyId, String contextSynopsis, String context, Date createTime, Date updateTime, List<Integer> labelId) {
        this.articleId = articleId;
        this.title = title;
        this.viewCount = viewCount;
        this.classifyId = classifyId;
        this.contextSynopsis = contextSynopsis;
        this.context = context;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.labelId = labelId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getContextSynopsis() {
        return contextSynopsis;
    }

    public void setContextSynopsis(String contextSynopsis) {
        this.contextSynopsis = contextSynopsis;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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

    public List<Integer> getLabelId() {
        return labelId;
    }

    public void setLabelId(List<Integer> labelId) {
        this.labelId = labelId;
    }
}
