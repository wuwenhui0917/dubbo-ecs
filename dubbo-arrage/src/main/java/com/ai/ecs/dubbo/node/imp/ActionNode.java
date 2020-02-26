package com.ai.ecs.dubbo.node.imp;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.mapper.ObjectMapper;
import com.ai.ecs.dubbo.node.AbstractNode;
import com.ai.ecs.dubbo.node.Ilink;
import com.ai.ecs.dubbo.spi.FactoryBean;
import com.ai.ecs.dubbo.util.MethodUtil;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by wuwh on 2017/8/4.
 */
public class ActionNode extends AbstractNode {

    /**服务名*/
    public static final String EIELD_SERVICE_NAME="servicename";
    public static final String FIELD_INTFACE_NAME="interface";
    public static final String FIELD_METHOD="method";
    private Class interface_calss=null;
    private String method=null;
    private Class[] paramType=null;
    private Method obj_method=null;
    private Class returnType=null;

    public ActionNode(EBPS.NodeType nodeType) {
        super(nodeType);
    }
    public ActionNode(){
        this(EBPS.NodeType.ACTION);
    }

    public Ilink execute(IEbpsContext context) throws EBPSException {
//        ExtensionLoader<BeanFacotory>    extender = ExtensionLoader.getExtensionLoader(BeanFacotory.class );
//        BeanFacotory facotory =  extender.getDefaultExtension();
        if(loger.isDebugEnabled()){
            loger.debug("开始进入动作节点：");
            loger.debug("输入参数为——————>"+context.getInput());

        }
        FactoryBean app = context.getAppContext();
        Object obj = app.getBean(this.interface_calss);
        if(loger.isDebugEnabled()){
            loger.debug(">>>>>>>>>>>>>>>>>"+this.interface_calss+":"+obj);
        }
       // Object obj = app.getBean(this.getAttr(EIELD_SERVICE_NAME));
        if(paramType!=null){
            Object[] params = new Object[paramType.length];

            for(int i =0;i<paramType.length;i++){
                Class type = paramType[i];
                Map info = context.getInput();
                Object paramObject = ObjectMapper.createConverObject(info,type);
                params[i]=paramObject;

            }
            if(this.obj_method!=null){
                try {
                    Object result =this.obj_method.invoke(obj,params);
                    if(loger.isDebugEnabled()){
                        loger.debug("处理结果："+result);


                    }

                    Map returnMap = ObjectMapper.converMap(result);
                    context.getOutput().putAll(returnMap);
                } catch (Exception e) {
                    new EBPSException();
                }
            }
        }
        else {
            if(this.obj_method!=null){
                try {
                    Object result =this.obj_method.invoke(obj);
                    if(loger.isDebugEnabled()){
                        loger.debug("处理结果："+result);


                    }
                    Map returnMap = ObjectMapper.converMap(result);
                    context.getOutput().putAll(returnMap);
                } catch (Exception e) {
                    new EBPSException();
                }
            }

        }
        if(loger.isDebugEnabled()){
            loger.debug("动作节点执行结束：");
            loger.debug("执行结果——————>"+context.getOutput());

        }

        return context.getEbpsflow().getLinkByFrom(this.getName());
    }

    public void init() throws EBPSException {
        String interfacestr = this.getAttr(FIELD_INTFACE_NAME);
        this.method = this.getAttr(FIELD_METHOD);
        try {
            interface_calss = Class.forName(interfacestr);
            try {

//                 = interface_calss.getMethod(this.method);
                this.obj_method= MethodUtil.parseMethod(interface_calss,this.method);
                paramType = obj_method.getParameterTypes();
                returnType = this.obj_method.getReturnType();
            } catch (NoSuchMethodException e) {
                throw  new EBPSException(30011,"方法："+method+"不存在");
            }
        } catch (ClassNotFoundException e) {
            throw  new EBPSException(30010,"接口："+interfacestr+"不存在");
        }
    }

    public Ilink getNextLink() {
        return null;

    }

    public static void main(String[] a){
        ActionNode node = new ActionNode(EBPS.NodeType.ACTION);
        node.setAttr("SERVICENAME","");

    }
}
