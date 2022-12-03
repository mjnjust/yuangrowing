package com.mj.learn.dubbo.consumer.dubbo;

import org.springframework.stereotype.Component;

@Component
public class DiTest {

    public DiTest(){
        int a = 001;
    }

    public String ditest() {
        return "ditest";
    }
}
