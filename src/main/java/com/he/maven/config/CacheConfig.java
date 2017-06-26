//package com.he.maven.config;
//
//import net.sf.ehcache.Cache;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by heyanjing on 2017/5/25 18:22.
// */
//@Configuration
//@EnableCaching
//public class CacheConfig {
//    @Bean(name = "city")
//    public Cache cityCache(EhCacheCacheManager ehCacheCacheManager) {
//        return (Cache) ehCacheCacheManager.getCache("city");
//    }
//
//    @Bean(name = "user")
//    public Cache userCache(EhCacheCacheManager ehCacheCacheManager) {
//        return (Cache) ehCacheCacheManager.getCache("user");
//    }
//}