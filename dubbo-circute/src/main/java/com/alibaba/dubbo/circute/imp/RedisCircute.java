package com.alibaba.dubbo.circute.imp;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.circute.hystrix.ExceptionHystrixCommond;
import com.alibaba.dubbo.circute.intf.CircuteHandle;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;

/**
 * 一个redis
 * @author Administrator
 *
 */
public class RedisCircute implements CircuteHandle {
	private static Logger    logger                       = Logger.getLogger(RedisCircute.class);

	public Result execute(Invoker<?> invoker, Invocation invocation) {
		if(logger.isDebugEnabled()){
			logger.debug("进入redis 熔断器处理");
		}
		return invoker.invoke(invocation);
	}


	
	

	

}
