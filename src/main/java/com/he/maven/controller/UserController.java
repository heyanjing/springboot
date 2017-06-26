package com.he.maven.controller;

import com.alibaba.fastjson.JSON;
import com.he.maven.bean.Result;
import com.he.maven.bean.ResultUtil;
import com.he.maven.shiro.util.Shiros;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heyanjing on 2017/5/25 15:34.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("/login")
    public Result login(String userName, String password) {
        userName = "何彦静boot";
        password = "123456";
        Result result = ResultUtil.error();
        if (!Shiros.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);
            try {
                Shiros.login(token);
                result = ResultUtil.success();
                log.info("登陆成功");
                log.warn(JSON.toJSONString(Shiros.getCurrentUser()));
                log.error("{}",Shiros.getSubject().hasRole("user1"));
                log.error("{}",Shiros.getSubject().hasRole("user2"));
                log.error("{}",Shiros.getSubject().hasRole("用户角色"));

            } catch (UnknownAccountException e) {
                result.setMsg("未知用户");
                log.info("未知用户");
            } catch (LockedAccountException e) {
                result.setMsg("用户被锁定");
                log.info("用户被锁定");
            } catch (AuthenticationException e) {
                result.setMsg("用户名密码错误");
                log.info("用户名密码错误");
            }
        }
        return result;
    }

    @RequestMapping(value = {"/logout/", "/logout"})
    public Result logout() {
        Result result = ResultUtil.success();
        Shiros.logout();
        return result;
    }
}
