package com.alibaba.dubbo.circute.intf;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;


/**
 * 熔断器蒙面模式
 * @author Administrator
 *
 */

@SPI("hystrix")
public interface CircuteFacedeFactory {
	
	   @Adaptive(Constants.CIR_KEY)
	   CircuteHandle getCircuteHandle(URL url);
	
	

}
