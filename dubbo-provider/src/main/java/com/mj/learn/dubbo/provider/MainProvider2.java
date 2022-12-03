package com.mj.learn.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MainProvider2 {
    public static void main(String[] args) {
        SpringApplication.run(MainProvider2.class);
    }
}
