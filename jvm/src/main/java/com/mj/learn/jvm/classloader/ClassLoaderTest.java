package com.mj.learn.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader();
        Class x = loader.loadClass("com.mj.learn.jvm.classloader.Asc");
        IAsc xx = (IAsc) x.getConstructor().newInstance();
        xx.action();
    }
}

class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 一个实现了IAsc 接口的class类文件
            FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\snwa\\Desktop\\Asc.class"));
            byte[] content = inputStream.readAllBytes();
            return defineClass(name, content, 0, content.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
