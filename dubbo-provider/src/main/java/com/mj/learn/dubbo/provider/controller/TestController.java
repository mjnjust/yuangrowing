package com.mj.learn.dubbo.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private volatile boolean a = false;

    @RequestMapping("/test.do")
    public String test() {
        return "asdfasdfad";
    }
}