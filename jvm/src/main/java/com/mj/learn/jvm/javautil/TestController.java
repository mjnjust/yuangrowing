package com.mj.learn.jvm.javautil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class TestController {

    public TestController() {
        int a = 0;
    }

    @RequestMapping("/b.do")
    public String a() {
        return "asdfads";
    }
}
