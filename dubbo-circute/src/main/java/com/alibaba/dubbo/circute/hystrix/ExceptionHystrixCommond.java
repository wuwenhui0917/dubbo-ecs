package com.alibaba.dubbo.circute.hystrix;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class ExceptionHystrixCommond  extends HystrixCommand<Result>{

	private  Invoker<?> invoker;
	private  Invocation invocation ;
	private static Logger    logger                       = Logger.getLogger(ExceptionHystrixCommond.class);
	//核心线程数
    private static final int DEFAULT_THREADPOOL_CORE_SIZE = 30;
   //错误百分比
    private static final int DEFAULT_ERROR_CORE_SIZE = 50;
    
    private String key=null;
    
    
 
	@Override
	protected Result getFallback() {
		logger.error("服务:["+this.key+"] 进入熔断处理方法");;
		return super.getFallback();
		
		
	}

	public ExceptionHystrixCommond(Invoker<?> invoker,Invocation invocation) {
		 super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(invoker.getInterface().getName()))
				 //安方法为可以进行熔断
                 .andCommandKey(HystrixCommandKey.Factory.asKey(String.format("%s_%d", invocation.getMethodName(),
                  invocation.getArguments() == null ? 0 : invocation.getArguments().length)))        
                // HystrixThreadPoolProperties.Setter
           .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                         .withCircuitBreakerRequestVolumeThreshold(20)//10秒钟内至少19此请求失败，熔断器才发挥起作用
                                         .withCircuitBreakerSleepWindowInMilliseconds(30000)//熔断器中断请求30秒后会进入半打开状态,放部分流量过去重试
                                         .withCircuitBreakerErrorThresholdPercentage(getErrorPrencent(invoker.getUrl()))//错误率达到50开启熔断保护
                                         )
                                         //使用dubbo的超时，禁用这里的超时
           
           .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(getThreadPoolCoreSize(invoker.getUrl()))));//线程池为30
		 //serviceid
		 this.key = String.format("%s_%d", invocation.getMethodName(),
                 invocation.getArguments() == null ? 0 : invocation.getArguments().length);
    
     this.invoker=invoker;
     this.invocation=invocation;
		
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	private static int getErrorPrencent(URL url){
		if(url!=null){
			return url.getParameter("error_rate", DEFAULT_ERROR_CORE_SIZE);
		}
		return DEFAULT_ERROR_CORE_SIZE;
		
	}
	
	
	
	
	 private  static  int getThreadPoolCoreSize(URL url) {
	        if (url != null) {
	            int size = url.getParameter("ThreadPoolCoreSize", DEFAULT_THREADPOOL_CORE_SIZE);
	            
	            return size;
	        }
	        return DEFAULT_THREADPOOL_CORE_SIZE;

	    }

	@Override
	protected Result run() throws Exception {
		
		logger.info("进入熔断器内部处理");
		return this.invoker.invoke(this.invocation);
		
	}

}
