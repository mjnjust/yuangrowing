package com.mj.learn.dubbo.api;

public interface Icache {
    public String get(String key);

    public String set(String key, String value);
}
