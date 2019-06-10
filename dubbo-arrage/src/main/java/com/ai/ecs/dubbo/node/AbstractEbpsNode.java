package com.ai.ecs.dubbo.node;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.exception.EBPSException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.ai.ecs.dubbo.EBPS.NodeType;


/**
 * 
 *
 * AbstractEbpsNode 
 * 节点抽象类
 * @author：wuwenhui 
 * @Sep：Apr 10, 2013 10:33:42 AM 
 * @version 1.0
 */
public abstract class AbstractEbpsNode  implements IEbpsNode{

	//节点名称
	private String name;
	//下一个节点ID
	private String nodeDes;
	
	//下一个节点
	private List<Ilink> nextLink;
	
	/** EBPS流程中所有的连线  */
	private List<Ilink> allLinks;
	
	//节点属性
	private Map<String,Object> attr = new HashMap<String,Object>();
	
	/*流程名称*/
	private String flowname;
	
	public Object getAttrValue(String name){
		return this.attr.get(name);
	}
	public void setAttr(String name,Object value){
		this.attr.put(name, value);
	}
	
	
	public Ilink getNextLink() {
		// TODO Auto-generated method stub
		return this.nextLink.get(0);
	}
	
	public List<Ilink> getLinks(){
		return this.nextLink;
	}
	
	

	//节点类型
	private  EBPS.NodeType nodetype;
	public void setName(String name) {
		this.name = name;
	}
	
	
	public AbstractEbpsNode(EBPS.NodeType type){
		this.nodetype=type;
	}

	public void setNodetype(EBPS.NodeType nodetype) {
		this.nodetype = nodetype;
	}
	
	public String getName()  {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public String getNodeDes() throws EBPSException {
		// TODO Auto-generated method stub
		return this.nodeDes;
	}

	
	public NodeType getNodeType() {
		// TODO Auto-generated method stub
		return this.nodetype;
	}

	public void setNodeDes(String nodeDes) {
		this.nodeDes = nodeDes;
	}

	
	/** setNextLinks 设置节点的线.
	 * @param nextLink 线集合
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 10, 2013 11:16:51 AM
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public void setNextLinks(List<Ilink> nextLink) throws EBPSException {
		if(this.nodetype==EBPS.NodeType.END){
			if(nextLink.size()>0) throw new EBPSException("节点"+this.name+"是结束节点但是 向下指向了线，流程文件解析错误");
		}
		else if(this.nodetype!=EBPS.NodeType.SWITCH){
			if(nextLink.size()!=1) throw new EBPSException("节点"+this.name+" 向下指向多个线或者为指向线，流程文件解析错误");
		}
		
		this.nextLink = nextLink;
	}
	
	
	/**
	 * allEBPSLinks.
	 * @return the allEBPSLinks
	 * @since Ver 1.0
	 */
	public List<Ilink> getAllLinks() {
		return allLinks;
	}

	/**
	 */
	public void setAllLinks(List<Ilink> allLinks) {
		this.allLinks = allLinks;
	}

	public void setAttr(String name,String value){
		this.attr.put(name, value);
		
	}
	
	public String getAttr(String name){
		if(this.attr.containsKey(name))
		return this.attr.get(name).toString();
		else return "";
	}
	
	
	public String getAttr(String name,String desvalue){
		String value = this.getAttr(name);
		if(value!=null&&!"".equals(value)) return value;
		return desvalue;
	}

	public String getFlowname() {
		return flowname;
	}

	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}
	
	public Set getAttrKey(){
		return this.attr.keySet();
	}
	
	
	
	
	
}
