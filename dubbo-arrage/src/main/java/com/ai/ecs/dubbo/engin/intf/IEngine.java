package com.ai.ecs.dubbo.engin.intf;

import com.ai.ecs.dubbo.common.Variable;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.node.IEbpsflow;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @version 1.0
 * @author：wuwenhui
 * @Sep：May 8, 2013 3:18:15 PM
 * @since 0.0
 * IEngine
 */

public interface IEngine {


    /**
     * executeFlow这里用一句话描述这个方法的作用.
     *
     * @param context 上下文
     * @return Map 返回说明.
     * @throws EBPSException ebps异常
     * @author：wuwenhui.
     * @create：May 8, 2013 3:23:57 PM.
     * @remark：
     */
    Map<String, Variable> executeFlow(IEbpsContext context)
            throws EBPSException;

    /**
     * getExecuteFlowResult(这里用一句话描述这个方法的作用).
     *
     * @param context
     * @return Object返回说明
     * @throws EBPSException
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 8, 2013 3:27:18 PM
     * @moduser:
     * @moddate：
     * @remark：
     */
    Map getExecuteFlowResult(IEbpsContext context) throws EBPSException;


    /**
     * executeEbpsflow(这里用一句话描述这个方法的作用)
     *
     * @param ebpsName
     * @param input
     * @return Object返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 8, 2013 3:42:13 PM
     * @moduser
     * @moddate：
     * @remark：
     */
//    Map executeEbpsflow(final String ebpsName, final Map input) throws EBPSException;


    /**
     * 执行流程对象
     * @param flowcontent 流程内容
     * @param input 输入参数
     * @param resultClass 返回结果类型
     * @param container 执行的容器
     * @param <T> 返回对象
     * @throws EBPSException
     */


    <T> T executeEbpsflow(final String flowcontent, final Object input, Class<T> resultClass, ApplicationContext container) throws EBPSException;


    /**
     * 执行流程对象
     * @param flow 流程对象
     * @param input 输入
     * @param resultClass 返回类型
     * @param container
     * @param <T>
     * @return
     * @throws EBPSException
     */
    <T> T executeEbpsflow(IEbpsflow flow, final Object input, Class<T> resultClass, ApplicationContext container) throws EBPSException;

    /**
     * 执行流程对象
     * @param context 流程文件内容
     * @param input 输入
     * @param resultClass 返回类型
     * @param container
     * @param <T>
     * @return
     * @throws EBPSException
     */
    <T> T executeEbpsflowByContext(final String context, final Object input, Class<T> resultClass, ApplicationContext container) throws EBPSException;


    /**
     * nextStep(这里用一句话描述这个方法的作用)
     *
     * @return void返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 8, 2013 3:43:28 PM
     * @moduser:
     * @moddate:
     * @remark：
     */
    void nextStep() throws EBPSException;

    /**
     * getstepValue(这里用一句话描述这个方法的作用)
     *
     * @return IEbpsContext返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 8, 2013 3:44:21 PM
     * @moduser:
     * @moddate：
     * @remark：
     */
    IEbpsContext getstepValue();

    /**
     * close 关闭引擎.
     *
     * @return void返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 16, 2013 4:52:39 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    void close();

    /**
     * close 初始化流程管理容器.
     *
     * @return void返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 16, 2013 4:52:39 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    void initFlowManager();


/**
 *
 * getEbpsManager 获得流程管理容器
 * @return EbpsManager 流程容器
 * @Exception 异常说明
 * @author：wuwenhui
 * @date：Feb 19, 2014 11:47:24 AM 
 * @modUser：
 * @modeDate：Feb 19, 2014 11:47:24 AM 
 * @remark：
 */
//EbpsManager getEbpsManager();


}
