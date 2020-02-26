package com.ai.ecs.dubbo.engin;

import com.ai.ecs.dubbo.common.Variable;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.engin.intf.IEngine;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.mapper.ObjectMapper;
import com.ai.ecs.dubbo.node.IEbpsNode;
import com.ai.ecs.dubbo.node.IEbpsflow;
import com.ai.ecs.dubbo.node.Ilink;
import com.ai.ecs.dubbo.node.imp.JSONEbpsFlow;
import com.ai.ecs.dubbo.util.FileUtil;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
public class EbpsEngine implements IEngine{

    private static Logger log = LoggerFactory.getLogger(EbpsEngine.class);

    @Override
    public Map<String, Variable> executeFlow(IEbpsContext context) throws EBPSException {
        IEbpsflow flow = context.getEbpsflow();
        IEbpsNode node = flow.getStartNode();
        try{
            while(true){
                Ilink linke =  node.execute(context);
                if(linke==null) break;
                node = flow.getToNodeByLink(linke);
                if(node==null) break;

            }
        }catch(Exception e){
            throw  new EBPSException("处理失败"+e);
        }


        return null;
    }

    @Override
    public Map getExecuteFlowResult(IEbpsContext context) throws EBPSException {

        return null;
    }



    @Override
    public <T> T executeEbpsflow(String flowcontent, Object input, Class<T> resultClass, ApplicationContext container) throws EBPSException {
        IEbpsContext context = new EbpsContext();
        context.initParams((Map)input);

        JSONEbpsFlow flow = new JSONEbpsFlow();
        try {
            flow.init(flowcontent);
            return executeEbpsflow(flow,input,resultClass,container);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;



    }

    @Override
    public <T> T executeEbpsflow(IEbpsflow flow, Object input, Class<T> resultClass, ApplicationContext container) throws EBPSException {
        EbpsContext context = new EbpsContext();
        context.setApplicationContext(container);
        context.initParams((Map)input);
        try {
            context.setEbpsflow(flow);
            IEbpsNode node = flow.getStartNode();
            while(true){
                Ilink linke =  node.execute(context);
                if(linke==null) break;
                node = flow.getToNodeByLink(linke);
                if(node==null) break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map output = context.getOutput();

        if(log.isDebugEnabled()){
            log.debug("流程处理完成，处理结果为："+output);
        }
        //对象自动装配，将map转化成对应的bean对象
        if(resultClass!=null){
            return  ObjectMapper.createConverObject(output,resultClass);
        }
        return null;
    }

    @Override
    public <T> T executeEbpsflowByContext(String filecontext, Object input, Class<T> resultClass, ApplicationContext container) throws EBPSException {
        IEbpsContext context = new EbpsContext();
        context.initParams((Map)input);
        JSONEbpsFlow flow = new JSONEbpsFlow();
        try {
            flow.init(filecontext);
            context.setEbpsflow(flow);
            IEbpsNode node = flow.getStartNode();
            while(true){
                Ilink linke =  node.execute(context);
                if(linke==null) break;
                node = flow.getToNodeByLink(linke);
                if(node==null) break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map output = context.getOutput();

        if(log.isDebugEnabled()){
            log.debug("流程处理完成，处理结果为："+output);
        }
        //对象自动装配，将map转化成对应的bean对象
        if(resultClass!=null){

            return  ObjectMapper.createConverObject(output,resultClass);
        }

        return (T)output;

    }


    @Override
    public void nextStep() throws EBPSException {

    }

    @Override
    public IEbpsContext getstepValue() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void initFlowManager() {

    }
}
