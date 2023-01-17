package com.mj.learn.dubbo.provider.listener;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisProtocolRegister implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        // 获取注册中心
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://117.62.217.89:2181"));
        // 直接注册一个redis服务 不需要有真实的服务提供者
        registry.register(URL.valueOf(
                "redis://117.62.217.89/com.mj.learn.dubbo.api.Icache?category=providers&dynamic=false&db.index=3")
        );
    }
}
