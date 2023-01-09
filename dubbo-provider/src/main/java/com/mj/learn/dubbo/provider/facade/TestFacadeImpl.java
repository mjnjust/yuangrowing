package com.mj.learn.dubbo.provider.facade;

import com.mj.learn.dubbo.api.ITestFacade;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(listener = "mjExportListener")
@Component
public class TestFacadeImpl implements ITestFacade {
    public TestFacadeImpl(){
        int a = 1;
    }
    @Override
    public String test() {
        return "asdfsdf1";
    }
}
