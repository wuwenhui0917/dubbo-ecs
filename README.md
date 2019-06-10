# 对dubbo进行了一些简单的扩展和修改
## 扩展如下：
### 服务的熔断机制 
    添加熔断器
#### 熔断器使用方式如下：
     添加熔断器配置：
     <bean id="demoService" class="com.alibaba.dubbo.demo.provider.DemoServiceImpl" />
	
	<dubbo:service interface="com.alibaba.dubbo.demo.DemoService" ref="demoService"  circuitName="redis" >
	
	</dubbo:service>
    参数 circuitName :熔断器名称
    目前实现了两个熔断器：hystrix 和redis熔断机制两种，默认是hystrix熔断器
 #### 熔断器扩展
     1. 实现 CircuteFacedeFactory  接口
        如：public class HystrixCricuteFacotory implements CircuteFacedeFactory
     2. 配置：META-INF/dubbo/internal/com.alibaba.dubbo.circute.intf.CircuteFacedeFactory的文件
        如：
           hystrix=com.alibaba.dubbo.circute.imp.HystrixCricuteFacotory
           redis=com.alibaba.dubbo.circute.imp.RedisCricuteFactory
     
### 2.dubbo服务的编排
      1.服务编排引擎处理：
         流程引擎的模块可以单独使用 模块为：dubbo-arrage
            1.支持：自动调用远程dubbo服务，
            2.支持赋值节点：可以在赋值节点上动态修改返回值，方便后续调用
            3.支持判断脚本（通过判断节点进行流程的switch）
          
         调用方式如下：
           EbpsEngine eng = new EbpsEngine();
                 try {
                     Map info =new HashMap();
                     info.put("name","wuwenhui");
         
                     CallBean returnbean = eng.executeEbpsflow("D:\\temp\\flow.json",info,CallBean.class,null);
                     System.out.println("返回值是："+returnbean);
                 } catch (EBPSException e) {
                     e.printStackTrace();
                 }
      
      2.服务编排编辑器：
            提供了js版本的流程编辑器：编辑器模块为arrag-edit
      3.服务编排流程文件：格式如下：
            支持json的服务编排文件：文件格式如下：
         {"links":[{"from":"param","name":"line1","to":"node1"},{"from":"c1","name":"line2","to":"end"},{"from":"node1","name":"line3","to":"c1"},{"from":"start","name":"line4","to":"param"}],"nodes":[{"name":"start","type":"start"},{"name":"end","type":"END"},{"interface":"com.alibaba.dubbo.demo.ExecuteIntf","method":"helloFlow(com.alibaba.dubbo.demo.CallBean)","name":"node1","servicename":"executeFlow","type":"action"},{"condition":"name=='wuwenhui'","else":"line2","method":"helloFlow","name":"c1","sucessful":"line2","type":"SWITCH"},{"name":"param","statement":"input.param='1234';output=#{}","type":"PARAMNODE"}]}
      待补充
      
      
### 3.扩展dubbo远程调用安全校验
      1.扩展了remoting-ext模块：主要实现客户端调用的IP白名单校验机制。
      使用方式如下：
          <dubbo:protocol name="dubbo" transporter="extnetty"></dubbo:protocol>
### 4.新增一些filter
      待补充
 
