package com.dxc.blog.pojo.vo;

import com.dxc.blog.pojo.Classify;
import com.dxc.blog.pojo.Label;

import java.util.List;

public class ArticleVo {
    private Integer articleId;
    private String title;
    private Integer viewCount;
    private Integer classifyId;
    private String contextSynopsis;
    private String context;
    private String createTime;
    private String updateTime;
    private List<Label> labels;
    private Classify classify;

    public ArticleVo() {
    }

    public ArticleVo(Integer id, String title, Integer viewCount, Integer classifyId, String contextSynopsis, String context, String createTime, String updateTime, List<Label> labels) {
        this.articleId = id;
        this.title = title;
        this.viewCount = viewCount;
        this.classifyId = classifyId;
        this.contextSynopsis = contextSynopsis;
        this.context = context;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.labels = labels;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

}
