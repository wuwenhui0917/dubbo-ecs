package com.ai.ecs.dubbo.proxy;


import com.alibaba.dubbo.config.*;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class DubboServiceProxyTest {


    public static void init(){
        ApplicationConfig app = new ApplicationConfig("app");
        ProtocolConfig protocolConfig = new ProtocolConfig();
 //       protocolConfig.setName("mockprotocol2");
        protocolConfig.setName("dubbo");
        ProviderConfig provider = new ProviderConfig();

       // provider.setProtocol(protocolConfig);

        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("zookeeper://localhost:2181");

        ServiceConfig server = new ServiceConfig();
        server.setInterface(TestInterface.class);
        server.setProvider(provider);
        server.setRegistry(registry);
//        server.setRef(DubboServiceProxy.createProxy(TestInterface.class));
        server.setRef(new TestInterfaceImp());
        server.setApplication(app);
        server.export();

    }

    public static void main(String[] a){
        TestInterface testInterface = DubboServiceProxy.createProxy(TestInterface.class);
        testInterface.test();
        init();
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}