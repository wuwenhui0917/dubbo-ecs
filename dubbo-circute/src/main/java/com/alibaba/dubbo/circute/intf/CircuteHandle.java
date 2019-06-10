package com.alibaba.dubbo.circute.intf;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;

public interface CircuteHandle {
	
	public Result execute(Invoker<?> invoker,Invocation invocation);

}
