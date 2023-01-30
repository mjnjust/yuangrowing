package com.mj.learn.dubbo.provider.facade;

import com.mj.learn.dubbo.api.ITestFacade;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;

@Service(listener = "mjExportListener")
@Component
public class TestFacadeImpl implements ITestFacade {
    public TestFacadeImpl() {
        int a = 1;
    }

    @Override
    public String test() {
        System.out.println(RpcContext.getContext().getAttachment("hello"));
        return "asdfsdf1";
    }
}
