package com.mj.learn.dubbo.consumer.dubbo;

import lombok.Getter;
import lombok.Setter;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;

import java.util.List;

public class TestLoadblance extends AbstractLoadBalance {

    private DiTest diTest;

    public TestLoadblance() {
        int a = 1010;
    }

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> list, URL url, Invocation invocation) {
        diTest.ditest();
        return list.get(0);
    }

    public void setDiTest(DiTest diTest) {
        this.diTest = diTest;
    }
}
