package com.mj.learn.dubbo.spi.learn;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;

public class MyMain {
    public static void main(String[] args) {
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class)
                                    .getExtension("myprotocol");
        System.out.println(protocol.getDefaultPort());
    }
}
