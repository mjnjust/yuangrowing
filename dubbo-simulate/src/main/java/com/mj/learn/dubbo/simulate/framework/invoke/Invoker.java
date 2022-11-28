package com.mj.learn.dubbo.simulate.framework.invoke;

import com.mj.learn.dubbo.simulate.framework.protocol.http.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Invoker {
    public static <T> T getProxy(Class<T> tClass) {
        return (T) Proxy.newProxyInstance(Invoker.class.getClassLoader(), new Class[]{ tClass },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Invocation invocation = new Invocation();
                        invocation.setInterfaceName(tClass.getName());
                        invocation.setMethodName(method.getName());
                        invocation.setParamsType(method.getParameterTypes());
                        invocation.setParams(args);
                        HttpClient httpClient = new HttpClient();
                        httpClient.send("localhost",8080,invocation);
                        return null;
                    }
                });
    }
}
