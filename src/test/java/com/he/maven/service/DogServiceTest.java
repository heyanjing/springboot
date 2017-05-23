package com.he.maven.service;

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
    @Test
    public void findAll() throws Exception {
        dogService.findAll();
        log.warn("findAll完成");
    }
    @Test
    public void insertDog() throws Exception {
        dogService.insertDog(null);
        log.warn("insertDog完成");
    }


}