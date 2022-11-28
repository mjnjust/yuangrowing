package com.mj.learn.dubbo.simulate.framework.protocol.http;

import com.mj.learn.dubbo.simulate.framework.invoke.Invocation;
import com.mj.learn.dubbo.simulate.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handle(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
            Class target = LocalRegister.get(invocation.getInterfaceName());

            Method method = target.getMethod(invocation.getMethodName(), invocation.getParamsType());
            var result = method.invoke(target.newInstance(), invocation.getParams());
            IOUtils.write(result.toString(), resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
