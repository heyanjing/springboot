package com.he.maven.enums;

/**
 * Created by heyanjing on 2017/5/23 16:43.
 *
 * 异常枚举
 */
public enum ExEnum {
    ex1(100, "ex1"),
    ex2(200, "ex2"),
    ex3(300, "ex3"),
    ex99(9900, "程序异常"),
    ex100(10000, "未知异常")
    ;
    private Integer code;
    private String  msg;

    ExEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
