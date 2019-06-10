package com.ai.ecs.dubbo.common;

import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.node.IEbpsNode;

import java.util.Iterator;

/**
 * .
 * Token
 * @since 1.0
 * @author：wuwenhui
 * @Sep：May 8, 2013 4:01:45 PM
 * @version 1.0
 */
public interface Token {

/**
 * .
 * getCurrentNodeName 方法说明
 * @return String返回说明
 * @Exception 异常说明
 * @author：wuwenhui
 * @create：May 8, 2013 4:02:40 PM
 * @moduser：
 * @moddate：
 * @remark：
 */
String getCurrentNodeName();
///**
// * nextNode 方法说明.
// * @return String返回说明
// * @Exception 异常说明
// * @author：wuwenhui
// * @create：May 8, 2013 4:05:52 PM
// * @moduser：
// * @moddate：
// * @remark：
// */
//Ilink nextNode();
/**
 * getSubToken 方法说明.
 * @param subTokenName 子名称
 * @return Token返回说明
 * @Exception 异常说明
 * @author：wuwenhui
 * @create：May 8, 2013 4:19:06 PM
 * @moduser：
 * @moddate：
 * @remark：
 */
Token getSubToken(String subTokenName);

/**
* getParamentToken 获得父令牌.
* @return Token返回说明
* @Exception 异常说明
* @author：wuwenhui
* @create：May 7, 2013 3:09:57 PM 
* @moduser： 
* @moddate：
* @remark：
*/
	public Token getParamentToken();
	
	/**
	 * 
	 * getTokenName 获得令牌的名称
	 * @return
	 * @return String返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 3:16:31 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public String getTokenName();
	
	
	/**
	 * 
	 * getSubTokeSize 获得子令牌的个数
	 * @return
	 * @return int返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 3:19:06 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public int getSubTokeSize();
	
	/**
	 * 
	 * getSubname 获得子令牌名称的迭代器
	 * @return
	 * @return Iterator<String>返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 7, 2013 3:19:39 PM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */	
	public Iterator<String> getSubname();
	
	
	/**
	 * 
	 * getCurrentNode 获取当前节点对象
	 * @return
	 * @return IEbpsNode返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 8, 2013 11:37:12 AM 
	 * @moduser： 
	 * @moddate：
	 * @remark：
	 */
	public IEbpsNode getCurrentNode();
	
	
	/**
	 * getContext 获得上下文对象.
	 * @return EbpsContext返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 13, 2013 8:44:34 PM
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public IEbpsContext getContext();
	
	
	/**
	 * putSubToken 方法说明.
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 13, 2013 10:12:27 PM
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public void putSubToken(String name, Token subToken);
	
	
	/**
	 * deleteSubToken 删除子令牌.
	 * @return void返回说明
	 * @Exception 异常说明
	 * @author：wuwenhui
	 * @create：May 14, 2013 9:29:26 AM
	 * @moduser：
	 * @moddate：
	 * @remark：
	 */
	public void deleteSubToken(String nae);
	
	
	public void clear();
	
	
	
	
	
	
}
