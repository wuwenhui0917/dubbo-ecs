package com.ai.ecs.dubbo.dbtrans;

/**
 * Created by wuwenhui on 2018/6/28.
 * since
 * 调用接口申明
 * @version 1.0
 */
public interface Invoker {

    void doInvoker(String transId, params);
}
