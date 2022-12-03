package com.mj.learn.dubbo.spi.jdkspi;

public class BSpiTest implements ISpiTest {
    private ISpiTest aSpiTest;

    @Override
    public String hello(String name) {
        return "B:" + name;
    }

    public void setaSpiTest(ISpiTest aSpiTest) {
        this.aSpiTest = aSpiTest;
    }
}
