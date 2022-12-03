package com.mj.learn.dubbo.provider.facade;

import com.mj.learn.dubbo.api.ITestFacade;
import com.mj.learn.dubbo.api.ITestFacadeV2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class TestFacadeV2Impl implements ITestFacadeV2 {
    @Override
    public String test() {
        return "asdfsdf1";
    }
}
