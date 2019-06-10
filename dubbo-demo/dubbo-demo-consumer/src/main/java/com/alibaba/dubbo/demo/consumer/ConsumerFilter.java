package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
@Activate(group = Constants.CONSUMER)
public class ConsumerFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("custerinvoker.............");
        invocation.getAttachments().put("cust","11111");
        Result rest = invoker.invoke(invocation);
        System.out.println( rest);

        System.out.println( rest.getAttachments().get("cust1"));
        System.out.println(RpcContext.getContext().getAttachment("cust1"));
        return rest;

    }
}
