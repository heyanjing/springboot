package com.he.maven.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by heyanjing on 2017/5/23 15:04.
 */
@Component
@Aspect
public class DogAspect {
    private static final Logger log = LoggerFactory.getLogger(DogAspect.class);

    @Pointcut("execution(* com.he.maven.controller..*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest request = ContextHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        String localAddr = request.getLocalAddr();
        System.out.println(localAddr);
        String method = request.getMethod();
        System.out.println(method);

        System.err.println("before");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.err.println("after");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        System.err.println("afterReturning");
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.err.println("afterThrowing");
    }
}
