package com.he.maven.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by heyanjing on 2017/5/23 17:34.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DogServiceTest {
    private static final Logger log = LoggerFactory.getLogger(DogServiceTest.class);
    @Autowired
    DogService dogService;

    //@Autowired
    //EhCacheCacheManager ehCacheCacheManager;
    @Test
    public void findAll() throws Exception {
        log.warn("findAll开始");
        log.info("第一次");
        dogService.findAll();
        log.info("第二次");
        dogService.findAll();
        log.warn("findAll完成");
    }
    @Test
    public void insertDog() throws Exception {
        dogService.insertDog(null);
        log.warn("insertDog完成");
    }
    @Test
    public void findByName() throws Exception {
        log.warn("findByName开始");
        log.info("第一次");
        dogService.findByName("name2017-05-23 15:03:28.568");
        log.info("第二次");
        dogService.findByName("name2017-05-23 15:03:28.568");
        log.warn("findByName结束");

    }

    @After
    public  void after()throws Exception{
        //log.error("", JSON.toJSONString(ehCacheCacheManager));
    }
}