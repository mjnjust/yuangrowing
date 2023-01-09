package com.mj.learn.dubbo.provider.listener;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.listener.ExporterListenerAdapter;

//@Adaptive
public class MjExportListener extends ExporterListenerAdapter {

    public MjExportListener() {
        int a = 1 ;
    }

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("export url: " + exporter.getInvoker().getUrl());
    }
}
