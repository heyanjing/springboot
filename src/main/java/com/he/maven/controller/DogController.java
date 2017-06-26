package com.he.maven.controller;

import com.alibaba.fastjson.JSON;
import com.he.maven.bean.Result;
import com.he.maven.entity.Dog;
import com.he.maven.service.DogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by heyanjing on 2017/5/23 11:55.
 */
@RestController
@RequestMapping("/dog")
public class DogController {
    private static final Logger log = LoggerFactory.getLogger(DogController.class);
    @Autowired
    private DogService dogService;

    @RequestMapping("/insertDog")
    public void insertDog(@Valid Dog dog, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            log.info(JSON.toJSONString(br));
        }
        dogService.insertDog(dog);
    }

    @RequestMapping("/findAll")
    public Result<List<Dog>> findAll() {
        return new Result<>(1, "成功", dogService.findAll());
    }

    @RequestMapping("/findByName")
    public Result<List<Dog>> findByName() {
        dogService.findByName("name2017-05-23 15:03:28.568");
        return new Result<>(1, "成功", dogService.findByName("name2017-05-23 15:03:28.568"));
    }
}
