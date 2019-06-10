package com.ai.ecs.dubbo.node;
import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.exception.EBPSException;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * IWorkNode 
 * 节点接口流程中每个节点类
 * @author：wuwh@asiainfo-linkage.com
 * @Sep 14, 2012 5:56:41 PM 
 * @version 1.0
 */
public interface IEbpsNode extends Serializable {
	/**
	 * 
	 * execute 流程执行方法
	 *
	 * @param context 流程上下文
	 * @throws EWorkflowException 流程异常
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 14, 2012 6:05:02 PM 
	 * @update:
	 * @Sep 14, 2012 6:05:02 PM
	 */
	public  Ilink execute(IEbpsContext context) throws EBPSException;
	
	/**
	 * 
	 * getName 获取流程名称
	 *
	 * @return String 流程名
	 * @Exception EWorkflowException 流程异常
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 14, 2012 6:00:07 PM 
	 * @update:
	 * @Sep 14, 2012 6:00:07 PM
	 */
	public  String getName();

	
	/**
	 * 
	 * getNodeType 获得节点的类型
	 *
	 * @return EWrokflow.NodeType
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 15, 2012 10:33:31 AM 
	 * @update:
	 * @Sep 15, 2012 10:33:31 AM
	 */
	public EBPS.NodeType getNodeType();
	/**
	 * 
	 * init 初始需要的东西
	 * @throws EBPSException
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：Apr 9, 2013 1:46:42 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public void init() throws EBPSException;
	
	/**
	 * 
	 * getNextLink 获得下一个节点的名称
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：Apr 10, 2013 5:01:57 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public Ilink getNextLink();
	
	
	/**
	 * 
	 * setAttr 设置属性值
	 * @param name 属性名称
	 * @param value 属性值
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 9:21:35 AM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public void setAttr(String name, String value);
	
	/**
	 * 
	 * setAttr 设置属性值
	 * @param name 属性名称
	 * @param value 设置的对象
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 9:21:35 AM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public void setAttr(String name, Object value);
	
	/**
	 * 
	 * getAttr 获得
	 * @param name
	 * @return Object 返回对象
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 9:23:14 AM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public Object getAttrValue(String name);
	
	
	/**
	 * 
	 * getAttr 获得
	 * @param name
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 9:23:14 AM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public String getAttr(String name);
	
	
	/**
	 * getAttrKey 获得.
	 * @param param
	 * @return Set返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 16, 2013 11:00:42 AM
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public Set getAttrKey();


}
