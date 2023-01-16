package com.mj.learn.dubbo.consumer.controller;

import com.mj.learn.dubbo.api.ITestFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Reference(protocol = "http")
    @Reference
    private ITestFacade testFacade ;

    @RequestMapping("/test.do")
    public String test() {
        return testFacade.test();
    }
}
