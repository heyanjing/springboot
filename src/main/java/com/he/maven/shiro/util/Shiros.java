package com.he.maven.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

public class Shiros {
    private static final Logger log = LoggerFactory.getLogger(Shiros.class);

    private Shiros() {
    }

    /**
     * 获取当前用户
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * @return 是否已登陆认证
     */
    public static boolean isAuthenticated() {
        return getSubject().isAuthenticated();
    }

    public static boolean isRemembered() {
        return getSubject().isRemembered();
    }

    public static void login(AuthenticationToken token) throws AuthenticationException {
        getSubject().login(token);
    }

    /**
     * 获取当前用户
     */
    public static Object getCurrentUser() {
        return getSubject().getPrincipal();
    }

    /**
     * 登出
     */
    public static void logout() {
        Subject currentUser = getSubject();
        if (currentUser != null) {
            currentUser.logout();
        }
    }

    /**
     * 获取Session
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 获取Session
     */
    public static Session getSession(boolean create) {
        return getSubject().getSession(create);
    }


    public static Serializable getSessionId() {
        return getSession().getId();
    }

    public static String getHost() {
        return getSession().getHost();
    }

    public static String getIP() {
        return getHost();
    }

    public static Date getStartTimestamp() {
        return getSession().getStartTimestamp();
    }

    public static Date getLastAccessTime() {
        return getSession().getLastAccessTime();
    }

    /**
     * 是否登陆
     */
    public static boolean isLogin() {
        return getCurrentUser() != null;
    }

    /**
     * 检查角色
     */
    public static boolean hasRole(String role) {
        return getSubject().hasRole(role);
    }

    /**
     * 检查权限
     */
    public static boolean isPermitted(String permission) {
        return getSubject().isPermitted(permission);
    }

    /**
     * 打印Session相关信息
     */
    public static void printSession() {
        log.info("SESSION");
        log.info("",getSession().getId());
        log.info(getSession().getHost());
        log.info("",getSession().getTimeout());
        log.info("",getSession().getLastAccessTime());
    }
}
