package com.mj.learn.jvm.javautil;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        var x = context.getBean("test");
//        System.out.println(x.hashCode());
        System.out.println(BigDecimal.valueOf(10300000000l).divide(BigDecimal.valueOf((1024 * 1024 * 1024))).doubleValue());
    }
}
