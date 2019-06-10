package com.ai.ecs.dubbo.configure;

import com.ai.ecs.dubbo.node.IEbpsflow;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface Configure {

    /**
     * 加载资源为资源对象
     * @param filename
     * @return
     */
    public IEbpsflow  init(String filename);

}
