package com.ai.ecs.dubbo.common;

/**
 * 
 * Variable 
 * 
 * 如下声明
    <type>
   <description></description>
	 <variable name="buf1" class="java.util.HashMap" type="in" ></variable>
  </type>
 
 *  
 * @author：wuwh@asiainfo-linkage.com
 * @Sep 18, 2012 10:47:07 AM 
 * @version 1.0
 */
public class Variable {

	//变量名称
	public String attributeName;
	//变量类型
	public String type;
	//变量class类型
	public String className="java.util.HashMap";
	//变量值
	public Object obj;

	public String toString() {
		return "{ "+this.attributeName+": TYPE="+type+" value="+obj.toString()+" }";
	}
	
	
	
}
