package com.mj.learn.dubbo.provider.facade;

import com.mj.learn.dubbo.api.ITestFacade;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class TestFacadeImpl implements ITestFacade {
    @Override
    public String test() {
        return "asdfsdf1";
    }
}
