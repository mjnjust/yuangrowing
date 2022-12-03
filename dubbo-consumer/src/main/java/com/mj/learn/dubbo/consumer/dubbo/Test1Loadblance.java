package com.mj.learn.dubbo.consumer.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;

import java.util.List;

public class Test1Loadblance extends AbstractLoadBalance {

    private LoadBalance test2Loadblance;

    public Test1Loadblance() {
        int a = 1010;
    }

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> list, URL url, Invocation invocation) {
        System.out.println("test1 loadblance");
        return list.get(0);
    }

    public void setTest2Loadblance(LoadBalance test2Loadblance) {
        this.test2Loadblance = test2Loadblance;
    }
}
