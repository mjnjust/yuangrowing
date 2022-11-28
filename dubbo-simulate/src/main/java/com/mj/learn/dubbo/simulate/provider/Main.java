package com.mj.learn.dubbo.simulate.provider;

import com.mj.learn.dubbo.simulate.api.ITest;
import com.mj.learn.dubbo.simulate.framework.protocol.http.HttpServer;
import com.mj.learn.dubbo.simulate.framework.register.LocalRegister;

public class Main {
    public static void main(String[] args) {
        LocalRegister.register(ITest.class.getName(), TestFacade.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }
}
