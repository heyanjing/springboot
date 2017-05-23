package com.he.maven.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by heyanjing on 2017/5/23 16:20.
 * 自定义异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ex extends RuntimeException {
    private  Integer code;


    public Ex(Integer code, String message) {
        super(message);
        this.code=code;
    }

    public Ex(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }

    public Ex(Throwable cause) {
        super(cause);
    }

    protected Ex(Integer code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code=code;
    }
}
