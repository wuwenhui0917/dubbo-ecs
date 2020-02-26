package com.ai.ecs.dubbo.proxy;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class DubboServiceProxy {

    /**
     * 创建代理
     * @param className
     * @param <T>
     * @return
     */
    public static  <T> T createProxy(Class<T> className,Object targat){
        T t=(T)Proxy.newProxyInstance(className.getClassLoader(), new Class[]{className}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行开始了"+method.getName());
                 return method.invoke(targat,args);
            }
        });
        return t;
    }

//    public <T> T Test(Class<T> classname){
//        ServiceConfig<T> service = new ServiceConfig<T>();
//        service.setGeneric();
//        return null;
//
//    }

    private Object invoke(){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setGeneric(true);
        reference.setInterface("interface.");
        reference.setVersion("1.1");
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        //genericService.$invoke()
        return null;
    }
}
