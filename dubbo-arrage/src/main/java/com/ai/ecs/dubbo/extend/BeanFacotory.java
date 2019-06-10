package com.ai.ecs.dubbo.extend;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * Created by Administrator on 2017/8/4.
 */
@SPI("spring")
public interface BeanFacotory {

    public Object getBean(String serverName);
}
