package com.mj.learn.dubbo.simulate.api;

import java.io.File;
import java.io.FileInputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader();
        Class x = loader.loadClass("com.mj.learn.dubbo.simulate.api.Asc");
        IAsc xx = (IAsc) x.getConstructor().newInstance();
        xx.action();
    }
}

class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\snwa\\Desktop\\Asc.class"));
            byte[] content = inputStream.readAllBytes();
            return defineClass(name, content, 0, content.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
