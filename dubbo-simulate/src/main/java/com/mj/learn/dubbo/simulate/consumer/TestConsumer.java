package com.mj.learn.dubbo.simulate.consumer;

import com.mj.learn.dubbo.simulate.api.ITest;
import com.mj.learn.dubbo.simulate.framework.invoke.Invocation;
import com.mj.learn.dubbo.simulate.framework.invoke.Invoker;
import com.mj.learn.dubbo.simulate.framework.protocol.http.HttpClient;

public class TestConsumer {
    public static void main(String[] args) {
//        Invocation invocation = new Invocation();
//        invocation.setInterfaceName(ITest.class.getName());
//        invocation.setMethodName("hello");
//        invocation.setParamsType(new Class[]{String.class});
//        invocation.setParams(new Object[]{"毛俊"});
//        new HttpClient().send("localhost",8080,invocation);
        ITest test = Invoker.getProxy(ITest.class);
        test.hello("asdfasdf");
    }
}
