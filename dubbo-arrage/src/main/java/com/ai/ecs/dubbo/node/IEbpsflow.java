package com.ai.ecs.dubbo.node;

import com.ai.ecs.dubbo.common.Variable;
import com.ai.ecs.dubbo.exception.EBPSException;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.Map;


/**
 * 
 *
 * IEbpsflow 
 * 流程接口
 * @author：wuwenhui 
 * @version 1.0
 */
public interface IEbpsflow extends Serializable {
	
	
	public static Logger log = Logger.getLogger(IEbpsflow.class);


	
	/**
	 * 
	 * init 初始化workflow
	 *

	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 15, 2012 10:39:35 AM 
	 * @update:
	 * @Sep 15, 2012 10:39:35 AM
	 */
	public void init(String xml) throws Exception;
	
	
	/**
	 * 
	 * deloyBpm 发布workflow
	 *
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 15, 2012 10:40:19 AM 
	 * @update:
	 * @Sep 15, 2012 10:40:19 AM
	 */
	public void deloyBpm() throws EBPSException;
	
	
	/**
	 * 
	 * getLink 通过指针名称获得指针实例
	 *
	 * @param linkName
	 * @return
	 * @throws EBPSException Ilink
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 15, 2012 11:00:10 AM 
	 * @update:
	 * @Sep 15, 2012 11:00:10 AM
	 */
	public Ilink getLink(String linkName) throws EBPSException;
	
	
	/**
	 * 依据线获得节点.
	 * @param link 线
	 * @return IEbpsNode 流程节点
	 * @author：wuwh@asiainfo-linkage.com
	 * @throws EBPSException
	 */
	public IEbpsNode getToNodeByLink(Ilink link) throws EBPSException;
	
	/**
	 * getNodeByName 更加节点名称找节点.
	 * @param nodeName 节点名称
	 * @return 节点
	 * @throws EBPSException
	 * @author：liuzhi
	 * @create：2013-5-14 下午4:39:57
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public IEbpsNode getNodeByName(String nodeName) ;

	/**
	 * 依据node节点获取Linke
	 * @param fromName
	 * @return
	 */
	public Ilink getLinkByFrom(String fromName);
	
	
	/**
	 * 
	 * getStartNode( 获得开始节点)
	 * @return
	 * @return IStartNode返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * 创建时间：Mar 22, 2013 10:54:30 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public IEbpsNode getStartNode();
	
	

	
	/**
	 * 
	 * getVariable 获得参数
	 *
	 * @param name
	 * @return Variable
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 15, 2012 11:02:28 AM 
	 * @update:
	 * @Sep 15, 2012 11:02:28 AM
	 */
	//public Variable getVariable(String name);
	
	/**
	 * 
	 * getFlowName 获取流程名称
	 *
	 * @return String
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 15, 2012 11:21:22 AM 
	 * @update:
	 * @Sep 15, 2012 11:21:22 AM
	 */
	public String getFlowName();

	/**
	 * 清空流程上下文
	 */
	public void clear();
	
	/**
	 * 
	 * getParamInfos 获得流程的 参数信息
	 * @return
	 * @return Map<String,Variable>返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * 创建时间：Mar 22, 2013 10:53:45 AM 
	 * 修改人： 
	 * 修改时间：
	 * 修改备注：
	 */
	public Map<String,Variable>  getParamInfos();
	
	
	
    
	/**
	 * 
	 * getUpdateDate 获得更新时间
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：Apr 8, 2013 4:19:52 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public String getUpdateDate();
	
	/**
	 * 
	 * getCreator 获得创建人
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：Apr 8, 2013 4:20:02 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public String getCreator();
	
	/**
	 * getVersion 方法说明.
	 * @param 
	 * @return String 返回版本号
	 * @author：wuwenhui
	 * @create：May 10, 2013 9:44:48 AM
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public String getVersion();
	
	
	/**
	 * 
	 * getEbpsManager(这里用一句话描述这个方法的作用)
	 * @return
	 * @return EbpsManager返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @date：Feb 19, 2014 12:01:48 PM 
	 * @modUser： 
	 * @modeDate：Feb 19, 2014 12:01:48 PM 
	 * @remark：
	 */
//	public EbpsManager getEbpsManager();
	
	
	
	
	
	
	
}
