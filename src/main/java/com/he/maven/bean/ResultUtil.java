package com.he.maven.bean;

/**
 * Created by heyanjing on 2017/5/23 15:46.
 */
public class ResultUtil {

    public static Result success(Object data){
        return new Result<>(1,"成功",data);
    }
    public static Result success(){
        return new Result<>(1,"成功",null);
    }
    public static Result error(){
        return error(0,"失败");
    }
    public static Result error(Integer code,String msg){
        return new Result<>(code,msg,null);
    }
}
