package com.mj.learn.dubbo.simulate.provider;

import com.mj.learn.dubbo.simulate.api.ITest;

public class TestFacade implements ITest {
    @Override
    public String hello(String name) {
        return "hello:" + name;
    }
}
