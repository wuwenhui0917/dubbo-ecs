package com.ai.ecs.dubbo.engin.intf;

import com.ai.ecs.dubbo.common.Token;
import com.ai.ecs.dubbo.node.IEbpsNode;
import com.ai.ecs.dubbo.node.IEbpsflow;
import com.ai.ecs.dubbo.spi.FactoryBean;

import java.sql.Connection;
import java.util.Map;

/**
 * WorkContext 流程上下文
 *
 * @version 1.0
 * @author：wuwh6@asinaifo.com
 * @Sep 15, 2012 5:46:16 PM
 */
public interface IEbpsContext {

    /**
     * 上下文存放变量常量
     */
    public static final String PARAM = "PARAMS";


    /**
     * 输入参数的变量名称
     */
    public static final String INPUT = "INPUT";
    /**
     * 输出变量的名称
     */
    public static final String OUTPUT = "OUTPUT";

    /**
     * 获得脚本引擎
     * getScriptEngine
     *
     * @return ScriptEngine
     * @Exception
     * @author：wuwh@asiainfo-linkage.com
     * @Sep 15, 2012 5:46:53 PM
     * @update:
     * @Sep 15, 2012 5:46:53 PM
     */
    // public ScriptEngine getScriptEngine();

//    /**
//     * getParams 获得所有参数
//     *
//     * @return Map<String,Variable>返回说明
//     * @Exception 异常说明
//     * @author：wuwenhui createDate：Mar 29, 2013 9:59:32 AM
//     * 修改人：
//     * 修改时间：
//     * 修改备注：
//     */
//    public Map<String, Variable> getAllParamsByMap();

    /**
     * 获取所有参数的并转化成Map展示
     * @return
     */
    public Map<String, Map> getAllParams();

    /**
     *
     * getParams 获得所有参数
     * @return
     * @return Map<String,Variable>返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * createDate：Mar 29, 2013 9:59:32 AM
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
//	  public List<Variable> getAllParams();

    /**
     * getbpmName 获得流程名称
     *
     * @return String返回说明
     * @Exception 异常说明
     * @author：wuwenhui createDate：Mar 29, 2013 9:59:53 AM
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public String getEBpsName();


    /**
     * clear 清除上下文内容
     *
     * @return void返回说明
     * @Exception 异常说明
     * @author：wuwenhui createDate：Mar 29, 2013 10:00:18 AM
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public void clear();

    /**
     * getVariable 依据名称获取相应的变量，其中参数包含了 输入，输出，与临时变量
     *
     * @param name
     * @return Variable返回说明
     * @Exception 异常说明
     * @author：wuwenhui createDate：Apr 8, 2013 2:05:07 PM
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public Map getVariable(String name);

    /**
     * getEbpsflow 获得流程实例
     *
     * @return IEbpsflow
     * @Exception
     * @author：LiuQiang
     * @Sep 15, 2012 5:46:11 PM
     * @update:
     * @Sep 15, 2012 5:46:11 PM
     */
    public IEbpsflow getEbpsflow();


    /**
     * initParams 初始化流程变量
     *
     * @param input
     * @return void返回说明
     * @Exception 异常说明
     * @author：wuwenhui createDate：Apr 8, 2013 2:07:00 PM
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public void initParams(Map input);

    /**
     * setEbpsflow 设置流程实例到流程上下文中
     *
     * @param ebps
     * @return void返回说明
     * @Exception 异常说明
     * @author：wuwenhui createDate：Apr 8, 2013 2:29:30 PM
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public void setEbpsflow(IEbpsflow ebps);


    /**
     * getToken(这里用一句话描述这个方法的作用)
     *
     * @return Token返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 8, 2013 11:09:41 AM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public Token getToken();


    /**
     * getIEngine 获得流程引擎.
     *
     * @return IEngine返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 13, 2013 8:18:36 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public IEngine getIEngine();

    /**
     * setToken 设置令牌节点
     *
     * @return Token返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 13, 2013 10:25:37 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public Token setToken(IEbpsNode node);

    /**
     * getInput 获得输入参数.
     *
     * @return Map返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 15, 2013 2:39:33 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public Map getInput();

    /**
     * getOutput 获得输出参数.
     *
     * @return Map返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 15, 2013 2:39:52 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public Map getOutput();

    /**
     * put 方法说明.
     *
     * @return void返回说明
     * @Exception 异常说明dd
     * @author：wuwenhui
     * @create：May 29, 2013 4:02:43 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public void put(String name, Object obj);

    /**
     * get 方法说明.
     *
     * @return Object返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 29, 2013 4:02:49 PM
     * @moduser：
     * @moddate：
     * @remark：
     */
    public Object get(String name);


    /**
     * getConnection 数据库连接
     *
     * @return Connection返回说明
     * @Exception 异常说明
     * @创建人：wuwenhui
     * @创建时间：Jan 8, 2014 5:15:25 PM
     * @修改人：
     * @修改时间：
     * @修改备注：
     */
    public Connection getConnection();

    /**
     * rollback 事物回滚
     *
     * @return void返回说明
     * @Exception 异常说明
     * @创建人：wuwenhui
     * @创建时间：Jan 8, 2014 5:17:07 PM
     * @修改人：
     * @修改时间：
     * @修改备注：
     */
    public void rollback();


    /**
     * commit 事物提交
     *
     * @return void返回说明
     * @Exception 异常说明
     * @创建人：wuwenhui
     * @创建时间：Jan 8, 2014 5:17:40 PM
     * @修改人：
     * @修改时间：
     * @修改备注：
     */
    public void commit();

    /**
     * 获得springAppcontext上线文对象
     *
     * @return
     */
    public FactoryBean getAppContext();

//	 /**
//	  * 
//	  * put 给上下文中放置数据 与getValue匹配使用
//	  * @param key
//	  * @param value
//	  * @return void返回说明
//	  * @Exception 异常说明
//	  * @author：wuwenhui
//	  * @create：Apr 9, 2013 6:04:57 PM 
//	  * @moduser： 
//	  * @moddate：
//	  * @remark：
//	  */
//	 public void put(String key,Object value);


//	 /**
//	  * 
//	  * getValue 
//	  * @param key
//	  * @return
//	  * @return Object返回说明
//	  * @Exception 异常说明
//	  * @author：wuwenhui
//	  * @create：Apr 9, 2013 6:05:25 PM 
//	  * @moduser： 
//	  * @moddate：
//	  * @remark：
//	  */
//	 public Object getValue(String key);

}
