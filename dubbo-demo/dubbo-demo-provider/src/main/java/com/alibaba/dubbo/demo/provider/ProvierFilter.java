package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
@Activate(group = Constants.PROVIDER)
public class ProvierFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("PROVIDER invoker.............");
        System.out.println(invocation.getAttachment("cust"));

        Result  result = invoker.invoke(invocation);
        System.out.println(result);
        RpcContext.getContext().setAttachment("cust1","12344");
        result.getAttachments().put("cust1","2222");
        return result;

    }
}
