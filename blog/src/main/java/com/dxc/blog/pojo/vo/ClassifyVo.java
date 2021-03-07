package com.dxc.blog.pojo.vo;

import com.dxc.blog.pojo.Article;

import java.util.List;

public class ClassifyVo {
    private Integer classId;
    private String className;
    private List<ArticleVo> articles;

    public ClassifyVo(Integer classId, String className, List<ArticleVo> articles) {
        this.classId = classId;
        this.className = className;
        this.articles = articles;
    }

    public ClassifyVo() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ArticleVo> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleVo> articles) {
        this.articles = articles;
    }
}
