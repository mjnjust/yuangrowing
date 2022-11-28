package com.mj.learn.dubbo.simulate.framework.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalRegister {
    private static Map<String, Class> cache = new ConcurrentHashMap<>();

    public static void register(String interfaceName, Class target) {
        cache.put(interfaceName, target);
    }

    public static Class get(String interfaceName) {
        return cache.get(interfaceName);
    }
}
