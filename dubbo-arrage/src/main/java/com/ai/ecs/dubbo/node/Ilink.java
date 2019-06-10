package com.ai.ecs.dubbo.node;


import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.exception.EBPSException;

/**
 * 
 * Ilink 
 * 指向接口
 * @author：wuwh@asiainfo-linkage.com
 * @Sep 14, 2012 6:11:52 PM 
 * @version 1.0
 */
public interface Ilink  {

	public  EBPS.NodeType nodetype=EBPS.NodeType.LINKER;
	/**
	 * 
	 * getFormNode
	 *
	 * @return String
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 14, 2012 6:11:38 PM 
	 * @update:
	 * @Sep 14, 2012 6:11:38 PM
	 */
	public String getFormNode();
	
	/**
	 * 
	 * getToNode
	 *
	 * @return String
	 * @Exception
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 14, 2012 6:11:45 PM 
	 * @update:
	 * @Sep 14, 2012 6:11:45 PM
	 */
	public String getToNode();
	
	
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
	public  String getName() throws EBPSException;
	
	
	
	
	
	
}
