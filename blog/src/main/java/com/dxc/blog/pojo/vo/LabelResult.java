package com.dxc.blog.pojo.vo;


public class LabelResult {
    private Integer labelId;
    private String labelName;
    private String labelType;
    private Integer articleTotal;

    public LabelResult(Integer labelId, String labelName, String labelType, Integer articleTotal) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.labelType = labelType;
        this.articleTotal = articleTotal;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    public Integer getArticleTotal() {
        return articleTotal;
    }

    public void setArticleTotal(Integer articleTotal) {
        this.articleTotal = articleTotal;
    }
}
