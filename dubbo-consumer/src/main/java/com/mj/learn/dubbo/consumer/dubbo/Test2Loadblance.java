package com.mj.learn.dubbo.consumer.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;

import java.util.List;

public class Test2Loadblance extends AbstractLoadBalance {

    private LoadBalance test1Loadblance;

    public Test2Loadblance() {
        int a = 1010;
    }

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> list, URL url, Invocation invocation) {
        System.out.println("test2 loadblance");
        return this.test1Loadblance.select(list, url, invocation);
    }

    public void setTest1Loadblance(LoadBalance test1Loadblance) {
        this.test1Loadblance = test1Loadblance;
    }
}
