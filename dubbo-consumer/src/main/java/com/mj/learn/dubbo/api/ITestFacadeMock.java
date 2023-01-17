package com.mj.learn.dubbo.api;

public class ITestFacadeMock implements ITestFacade {
    @Override
    public String test() {
        return "mock value";
    }
}
