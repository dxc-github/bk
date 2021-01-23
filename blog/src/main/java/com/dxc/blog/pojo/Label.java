package com.dxc.blog.pojo;

public class Label {
    private Integer labelId;
    private String labelName;
    private String labelType;

    public Label() {
    }

    public Label(Integer labelId, String labelName, String labelType) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.labelType = labelType;
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
}
