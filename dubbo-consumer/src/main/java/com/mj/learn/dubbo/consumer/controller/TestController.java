package com.mj.learn.dubbo.consumer.controller;

import com.mj.learn.dubbo.api.ITestFacade;
import com.mj.learn.dubbo.api.Icache;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private volatile boolean redisRegister = false;

    /**
     * 通过http协议调用
     */
    @Reference(protocol = "http", check = false)
    private ITestFacade httpFacade;

    /**
     * 通过dubbo协议调用
     */
    @Reference(protocol = "dubbo", check = false)
    private ITestFacade dubboFacade;

    @RequestMapping("/test.do")
    public String test() {
        System.out.println(httpFacade.test());
        System.out.println(dubboFacade.test());
        return "testOk";
    }

    @RequestMapping("/test2.do")
    public String test2() {
        RpcContext.getContext().setAttachment("hello", String.valueOf(System.currentTimeMillis()));
        System.out.println(dubboFacade.test());
        return "testOk";
    }

    @Reference(protocol = "redis", check = false)
    private Icache icache;

    /**
     * redis协议的使用
     *
     * @return
     */
    @RequestMapping("/redis_test.do")
    public String redisProtocolTest() {
        icache.set("a", String.valueOf(System.currentTimeMillis()));
        System.out.println(icache.get("a"));
        return "redis test ok";
    }
}
