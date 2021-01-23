package com.dxc.blog.pojo;

public class Classify {
    private Integer classId;
    private String className;

    public Classify() {
    }

    public Classify(Integer id, String class_name) {
        this.classId = id;
        this.className = class_name;
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
}
