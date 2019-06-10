package com.alibaba.dubbo.circute.imp;

import com.alibaba.dubbo.circute.intf.CircuteFacedeFactory;
import com.alibaba.dubbo.circute.intf.CircuteHandle;
import com.alibaba.dubbo.common.URL;

public class RedisCricuteFactory implements CircuteFacedeFactory {

	public CircuteHandle getCircuteHandle(URL url) {
		return new RedisCircute();
	}

}
