package com.dxc.blog.result;

public enum StatusCode {
    SUCCESS(200,"成功"),
    FALL(500,"失败"),
    REQUEST_PARAM_ERROR(501, "请求参数错误"),
    TOKEN_ERROR(505, "token错误");
    private int code;
    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
