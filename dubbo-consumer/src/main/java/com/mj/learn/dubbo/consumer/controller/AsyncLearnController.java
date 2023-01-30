package com.mj.learn.dubbo.consumer.controller;

import com.mj.learn.dubbo.api.ITestFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
public class AsyncLearnController {
    @Reference(protocol = "dubbo", async = true, check = false)
    private ITestFacade dubboFacade;

    @RequestMapping("/test.do")
    public String test() {
        System.out.println(dubboFacade.test());
        Object result = null;
        try {
            result = RpcContext.getContext().getFuture().get();
            System.out.println(result);
            System.out.println("after async get result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "testOk";
    }

    @RequestMapping("/test2.do")
    public String realsyncTest() {
        try {
            System.out.println(dubboFacade.test());
            CompletableFuture<String> responseFuture = RpcContext.getContext().getCompletableFuture();
            responseFuture.whenComplete((s, throwable) -> System.out.println(s));
            System.out.println("after async get result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "testOk";
    }
}
