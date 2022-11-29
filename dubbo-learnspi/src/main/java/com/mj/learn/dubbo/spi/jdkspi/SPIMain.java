package com.mj.learn.dubbo.spi.jdkspi;

import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<ISpiTest> spiTests = ServiceLoader.load(ISpiTest.class);
        for(ISpiTest spiTest:spiTests){
            System.out.println(spiTest.hello("asf"));
        }
    }
}
