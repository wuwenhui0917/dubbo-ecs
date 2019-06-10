package com.ai.ecs.dubbo.node;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.common.Variable;

import java.util.Map;


/**
 * 
 *
 * ISubProcessNode 
 * 子流程类
 * @author：wuwenhui 
 * @Sep：Mar 22, 2013 11:08:46 AM 
 * @version 1.0
 */
public interface ISubProcessNode  extends IEbpsNode{
	
	public final EBPS.NodeType nodetype=EBPS.NodeType.SUBPROCESS;
	/**
	 * 
	 * getInputParam 输入参数
	 * @return 
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * 创建时间：Mar 22, 2013 11:09:07 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public String getInputParam();
	
	/**
	 * 
	 * getOutputParam(这里用一句话描述这个方法的作用)
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * 创建时间：Mar 22, 2013 11:09:35 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public String getOutputParam();
	
	/**
	 * 
	 * getSubProcessName(子流程名称)
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * createDate：Mar 22, 2013 11:43:06 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public String getSubProcessName();
	
	/**
	 * 
	 * execute 子流程执行
	 * @param input
	 * @return
	 * @return Map<String,Variable>返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * createDate：Mar 22, 2013 11:43:50 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public Map<String, Variable>  execute(Object input);
	
	/**
	 * 
	 * getNextLink 获得下一个节点
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * createDate：Mar 22, 2013 12:04:28 PM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public Ilink getNextLink();
	
	/**
	 * 
	 * setNodeId 设置NODEID
	 * @param nodeId
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * createDate：Apr 8, 2013 9:30:03 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public void setNodeId(String nodeId);

}
