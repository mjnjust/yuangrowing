package com.mj.learn.dubbo.spi.learn;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.RpcException;

public class T1Protocol implements Protocol {

    private Protocol myprotocol;

    public T1Protocol() {
        int a = 0;
    }

    @Override
    public int getDefaultPort() {
        return 10086;
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        return null;
    }

    @Override
    public <T> Invoker<T> refer(Class<T> aClass, URL url) throws RpcException {
        return null;
    }

    @Override
    public void destroy() {

    }

    public void setMyprotocol(Protocol myprotocol) {
        this.myprotocol = myprotocol;
    }
}
