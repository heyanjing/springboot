package com.he.maven.handler;

import com.alibaba.fastjson.JSON;
import com.he.maven.aspect.ContextHolder;
import com.he.maven.bean.Result;
import com.he.maven.bean.ResultUtil;
import com.he.maven.exception.Ex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by heyanjing on 2017/5/23 16:11.
 * 统一异常处理
 */
@ControllerAdvice
@RestController
public class GlobleExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobleExceptionHandler.class);


    /**
     *自定义异常处理
     */
    @ExceptionHandler(value = {Ex.class})
    public Result handle(Ex e) {
        logError(e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }
    /**
     *运行时异常处理
     */
    @ExceptionHandler(value = {RuntimeException.class})
    public Result handle(RuntimeException e) {
        logError(e);
        return ResultUtil.error();
    }
    /**
     *其他异常处理
     */
    @ExceptionHandler(value = {Exception.class})
    public Result handle(Exception e) {
        logError(e);
        return ResultUtil.error();
    }

    /**
     * 打印请求地址、请求参数、异常等信息
     * @param e 异常
     */
    private void logError(Exception e) {
        HttpServletRequest request = ContextHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.error("\n\n 请求地址：{}\n 请求参数：{} \n 异常信息:{}\n ", requestURL, JSON.toJSONString(parameterMap), e.getMessage(), e);
        log.error("-----------------------------------------------------------异常结束-----------------------------------------------------------");
    }
}
