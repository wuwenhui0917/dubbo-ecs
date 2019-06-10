package com.alibaba.dubbo.circute.filter;

import com.alibaba.dubbo.circute.intf.CircuteFacedeFactory;
import com.alibaba.dubbo.circute.intf.CircuteHandle;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;


@Activate(group = { Constants.CONSUMER, Constants.PROVIDER }, value = Constants.CIR_KEY, order = 10000)
public class CircuteFilter implements Filter{
	
	
	private CircuteFacedeFactory circuteFactory;
	

	public CircuteFacedeFactory getCircuteFactory() {
		return circuteFactory;
	}


	public void setCircuteFactory(CircuteFacedeFactory circuteFactory) {
		this.circuteFactory = circuteFactory;
	}


	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		CircuteHandle cirle = this.circuteFactory.getCircuteHandle(invoker.getUrl());
		return cirle.execute(invoker, invocation);
	}

}
