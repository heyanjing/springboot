package com.he.maven.config;

import com.he.maven.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by heyanjing on 2017/5/25 14:22.
 */
@Configuration
public class ShiroConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        return shiroRealm;
    }

    @Bean
    public EhCacheManager cacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache/ehcache.xml");
        return em;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(shiroRealm());
        dwsm.setCacheManager(cacheManager());
        return dwsm;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {

        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(securityManager());
        filter.setLoginUrl("/");
        filter.setUnauthorizedUrl("/error/403");
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("/static/**", "anon");
        map.put("/kaptcha/**", "anon");
        map.put("/", "anon");
        map.put("/user/**", "anon");
        map.put("/person/**", "anon");
        map.put("/home/**", "anon");
        map.put("/dog/**", "anon");
        map.put("/page1", "user,roles[user1]");
        map.put("/page2", "roles[user2]");
        map.put("/**", "authc");
        filter.setFilterChainDefinitionMap(map);
        return filter;
    }
}
