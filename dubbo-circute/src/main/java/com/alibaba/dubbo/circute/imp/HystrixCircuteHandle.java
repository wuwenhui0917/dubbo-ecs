package com.alibaba.dubbo.circute.imp;

import com.alibaba.dubbo.circute.hystrix.ExceptionHystrixCommond;
import com.alibaba.dubbo.circute.intf.CircuteHandle;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;

public class HystrixCircuteHandle implements CircuteHandle {

	public Result execute(Invoker<?> invoker, Invocation invocation) {
		ExceptionHystrixCommond command = new ExceptionHystrixCommond(invoker,invocation);
		return command.execute();
		//return null;
	}

}
