package com.mj.learn.dubbo.spi.jdkspi;

public class ASpiTest implements ISpiTest {

    private ISpiTest bSpiTest;

    @Override
    public String hello(String name) {
        return "A:" + name;
    }

    public void setbSpiTest(ISpiTest bSpiTest) {
        this.bSpiTest = bSpiTest;
    }
}
