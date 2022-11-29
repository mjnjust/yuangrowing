package com.mj.learn.dubbo.spi.jdkspi;

public class ASpiTest implements ISpiTest {
    @Override
    public String hello(String name) {
        return "A:" + name;
    }
}
