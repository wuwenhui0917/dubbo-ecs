package com.ai.ecs.dubbo;
/**
 * 
 * EWrokflow 流程类
 *  
 * @author：wuwh@asiainfo-linkage.com
 * @Sep 18, 2012 10:48:43 AM 
 * @version 1.0
 */
public class EBPS {
	/**
	 * 
	 * PARAMSTYPE 系统参数声明
	 *  
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 14, 2012 6:18:04 PM 
	 * @version 1.0
	 */
	public interface PARAMSTYPE{
		public final static String PARAM_OUT="out";
		public final static String PARAM_IN="in";
		public final static String PARAM_ERROR="error";
		public final static String PARAM_OGNLTYPE="OGNL";
		public final static String OGNL_ROOT="#root.";

	}
	
	/**
	 * 
	 * NodeType 
	 *  
	 * @author：wuwh@asiainfo-linkage.com
	 * @Sep 14, 2012 6:18:37 PM 
	 * @version 1.0
	 */
	 public static enum NodeType
	  {
	     START, END, ACTION,SWITCH,LINKER,SCRIPT,SUBPROCESS,PARAMNODE,LOOP,INTERFACE,MEMCACHED,DBNODE,REDISENODE
	  }
	 
	 
	public static String getMessage(int code){
		
		//0001-0049流程编码
        //0050-0100业务编码
		
		switch (code){
		/*************流程编码************/
		case 0001: {
			 return "start node not find";
		}
		case 0021: {
				return "Mapper IntrospectionException ";
			}
         case 0002: {
        	 return "start node execute error";
		}
         case 0003: {
        	 return "action node execute error";
 		}	
         case 0004: {
        	 return "if node execute error";
 		}	
         case 0005: {
        	 return "script node error";
 		}	
         case 0006: {
        	 return "end node error";
 		}
         case 0020: {
        	 return "flow execute error";
 		}
        

         case 0010:{
        	 return "ClassNotFoundException";
         }
         
         case 10100:{
        	 return "键值对字符不符合规范";
         }
         
         case 40013:{
        	 return "expression error";
         }

        /*************业务编码***********/
         case 0050:{
        	 return "Map类型不能为空";
         }
         case 0051:{
        	 
        	 return "flowname must not null";
         }
         case 0052:{
        	 
        	 return "类型转换失败，请检查输入参数。";
         }
        case 0011:{
        	 
        	 return "开始节点执行的方法是空的";
         }
        case 0012:{
       	 
       	 return "开始节点执行的方法异常";
        }
        case 30200:{
          	 
          	 return "赋值表达式为空";
           }

        case 3001:{
        	 
        	 return "分支节点参数不能为空";
         }
        case 3002:{
       	 
       	 return "mark must not null";
        }
        case 30002:{
          	 
          	 return "动态编译失败，请检查脚本是否正确";
           }
        default:{
        	 return code+"[message not find] ";
         }
		
		}
		
		
	}

}
