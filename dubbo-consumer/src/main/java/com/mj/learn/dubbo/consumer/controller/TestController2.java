package com.mj.learn.dubbo.consumer.controller;

import com.mj.learn.dubbo.api.ITestFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class TestController2 {

    /**
     * 通过dubbo协议调用
     */
    @Reference(protocol = "dubbo", mock = "true" , check = false)
    private ITestFacade dubboFacade;

    @RequestMapping("/mock.do")
    public String test() {
        System.out.println(dubboFacade.test());
        return "testOk";
    }

}
