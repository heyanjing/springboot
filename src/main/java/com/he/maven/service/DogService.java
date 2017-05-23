package com.he.maven.service;

import com.alibaba.fastjson.JSON;
import com.he.maven.dao.DogDao;
import com.he.maven.entity.Dog;
import com.he.maven.enums.ExEnum;
import com.he.maven.exception.Ex1;
import com.he.maven.exception.Ex2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by heyanjing on 2017/5/23 11:48.
 */
@Service
public class DogService {

    @Autowired
    private DogDao dogDao;
    Integer i = 0;

    @Transactional
    public void insertDog(Dog dog) throws Exception {

        int j = i % 4;
        i++;
        if (j == 0) {
            throw new RuntimeException(ExEnum.ex99.getMsg());
        } else if (j == 1) {
            throw new Ex1(ExEnum.ex1.getCode(), ExEnum.ex1.getMsg());
        } else if (j == 2) {
            throw new Ex2(ExEnum.ex2.getCode(), ExEnum.ex2.getMsg());
        } else if (j == 3) {
            throw new Exception(ExEnum.ex100.getMsg());
        }

        if (dog == null) {
            dog= new Dog("name" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), 12);
        }
        Dog save = dogDao.save(dog);
        System.err.println(JSON.toJSONString(save));
    }

    @Transactional
    public List<Dog> findAll() {
        return this.dogDao.findAll();
    }
}
