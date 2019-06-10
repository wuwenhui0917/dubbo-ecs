package com.ai.ecs.dubbo.spi;

import org.springframework.context.ApplicationContext;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */

public class SpringFacotryBean implements FactoryBean {

    public  ApplicationContext context = null;
    public SpringFacotryBean(ApplicationContext context){
        this.context = context;
    }
    @Override
    public Object getBean(String name) {
        return this.context.getBean(name);
    }

    public <T> T getBean(Class<T> requiredType){
        return this.context.getBean(requiredType);
    }

    public <T> T getBean(Class<T> requiredType,String name){
        return this.context.getBean(name,requiredType);
    }

}
