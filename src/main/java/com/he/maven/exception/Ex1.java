package com.he.maven.exception;

/**
 * Created by heyanjing on 2017/5/23 16:20.
 */
public class Ex1 extends Ex {
    public Ex1(Integer code, String message) {
        super(code, message);
    }

    public Ex1(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public Ex1(Throwable cause) {
        super(cause);
    }

    protected Ex1(Integer code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
