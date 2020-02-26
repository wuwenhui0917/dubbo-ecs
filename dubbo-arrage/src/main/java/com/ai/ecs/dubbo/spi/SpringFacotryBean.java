package com.ai.ecs.dubbo.spi;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */

public class SpringFacotryBean implements FactoryBean,ApplicationContextAware {

    public  ApplicationContext context = null;

    public SpringFacotryBean(){

    }
    public SpringFacotryBean(ApplicationContext context){
        this.context = context;
    }
    @Override
    public Object getBean(String name) {
        return this.context.getBean(name);
    }

    @Override
    public <T> T getBean(Class<T> requiredType){
        return this.context.getBean(requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType, String name){
        return this.context.getBean(name,requiredType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.context =applicationContext;
    }
}
