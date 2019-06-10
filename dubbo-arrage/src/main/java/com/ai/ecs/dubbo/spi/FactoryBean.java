package com.ai.ecs.dubbo.spi;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */
public interface FactoryBean {

    public Object getBean(String name);

    public <T> T getBean(Class<T> requiredType);

    public <T> T getBean(Class<T> requiredType,String name);


}
