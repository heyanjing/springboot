package com.he.maven.controller;

import com.he.maven.bean.Result;
import com.he.maven.entity.Dog;
import com.he.maven.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by heyanjing on 2017/5/23 11:55.
 */
@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @RequestMapping("/insertDog")
    public void insertDog(Dog dog) throws Exception {
        dogService.insertDog(dog);
    }

    @RequestMapping("/findAll")
    public Result<List<Dog>> findAll() {
        return new Result<>(1,"成功",dogService.findAll());
    }
}
