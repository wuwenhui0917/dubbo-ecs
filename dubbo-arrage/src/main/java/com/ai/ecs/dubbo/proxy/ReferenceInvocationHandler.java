package com.ai.ecs.dubbo.proxy;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.lang.reflect.Method;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class ReferenceInvocationHandler implements AopRoundHandle {

    private ReferenceConfig  toReferene ;
    private String toMethod;
    private String[] methods;

    public ReferenceInvocationHandler(String toMethodName,String[] toMethodParams){
        this.toMethod = toMethodName;
        this.methods = toMethodParams;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(toReferene!=null){
            //泛型调用
            if(toReferene.isGeneric()){
                GenericService genericService = (GenericService)toReferene.get();
                genericService.$invoke(toMethod,methods,args);
            }
            else {
                Object t =  toReferene.get();
                return method.invoke(t,args);
            }

        }
        return method.invoke(proxy,args);
    }

    public ReferenceConfig getToReferene() {
        return toReferene;
    }

    public void setToReferene(ReferenceConfig toReferene) {
        this.toReferene = toReferene;
    }
}
