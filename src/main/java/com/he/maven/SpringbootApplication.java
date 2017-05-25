package com.he.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这三个注解等同于 @SpringBootApplication
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
