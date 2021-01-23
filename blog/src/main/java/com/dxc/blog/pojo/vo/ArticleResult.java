package com.dxc.blog.pojo.vo;

import java.util.List;

public class ArticleResult {
    private List<ArticleVo> articleVoList;
    private Integer total;
    private Integer pages;

    public ArticleResult(List<ArticleVo> articleVoList, Integer total, Integer pages) {
        this.articleVoList = articleVoList;
        this.total = total;
        this.pages = pages;
    }

    public List<ArticleVo> getArticleVoList() {
        return articleVoList;
    }

    public void setArticleVoList(List<ArticleVo> articleVoList) {
        this.articleVoList = articleVoList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
