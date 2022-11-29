package com.mj.learn.dubbo.spi.jdkspi;

public class BSpiTest implements ISpiTest {
    @Override
    public String hello(String name) {
        return "B:" + name;
    }
}
