package com.he.maven.controller;

import com.he.maven.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by heyanjing on 2017/5/22 15:51.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${proVal1}")
    private boolean proVal1;
    @Value("${proVal2}")
    private String  proVal2;
    @Value("${proVal3}")
    private Integer proVal3;
    @Value("${proVal4}")
    private String  proVal4;
    @Value("${env}")
    private String  env;

    @Autowired
    private Person person;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index()throws  Exception {
        System.out.println(proVal1);
        System.out.println(proVal2);
        System.out.println(proVal3);
        System.out.println(proVal4);

        System.out.println(person.getAge());
        System.out.println(person.getName());

        System.err.println(env );
        return "我操"+env;
    }
    //@RequestMapping(value = "/say/{word}", method = RequestMethod.GET)
    @GetMapping("/say/{word}")
    public String say(@PathVariable("word") String word ) {
        return "hexllo"+word;
    }
}
