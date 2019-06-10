/*
 * Copyright (c) 2013 by wuwenhui
 * All rights reserved.
 */
package com.ai.ecs.dubbo.exception;

import com.ai.ecs.dubbo.EBPS;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;



/**
 * 
 * EBPSException
 *  
 * @author：wuwh@asiainfo-linkage.com
 * @Sep 7, 2012 10:24:38 PM 
 * @version 1.0
 */
public class EBPSException extends Exception {

	private static final long serialVersionUID = -8752338694577817727L;
	private Exception rootCause;
	private String desc="";
	private int error_code;



    public EBPSException() {
    }

    public EBPSException(String s) {
        super(s);
    }

    public EBPSException(String s, Exception rootCause) {
        super(s);
        this.rootCause = rootCause;
    }
    
    public EBPSException(int result_code){
    	
    	super(EBPS.getMessage(result_code));
    	this.error_code=result_code;
    
    }
 public EBPSException(int result_code,String desc){
    
    	super(EBPS.getMessage(result_code));
    	this.desc=desc;
    
    }

    public EBPSException(Exception rootCause) {
        this.rootCause = rootCause;
    }
    public EBPSException(int errorCode,Exception rootCause) {
    	super(EBPS.getMessage(errorCode)+rootCause);
    	
        this.rootCause = rootCause;
       // this.error_code=errorCode;
    }

    public String getMessage() {
        StringBuffer sb = new StringBuffer(this.desc);
        String msg = super.getMessage();

        if (msg != null) {
            sb.append(msg);

        }

        if (rootCause != null) {
            sb.append( rootCause.getMessage());
        }

        return sb.toString();
    }

    public Exception getRootCause() {
        return rootCause;
    }

    public void printStackTrace() {
        super.printStackTrace();

        if (rootCause != null) {
            synchronized (System.err) {
               
                rootCause.printStackTrace();
            }
        }
    }

    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);

        if (rootCause != null) {
            synchronized (s) {
               
                rootCause.printStackTrace(s);
            }
        }
    }

    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);

        if (rootCause != null) {
            synchronized (s) {
                //s.println("");
                rootCause.printStackTrace(s);
            }
        }
    }
    
    
    public String getStackTraceInfo(){
    	return getStackTrace(this);
    }
 
    
    /**
     * 
     * getStackTrace 获得所有堆栈信息
     * @param e
     * @return
     * @return String返回说明
     * @Exception 异常说明
     * @author：wuwenhui
     * @create：May 7, 2013 9:48:05 AM 
     * @moduser： 
     * @moddate：
     * @remark：
     */
    public static String getStackTrace(Throwable e) {
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    e.printStackTrace(pw);
	    String str = sw.toString();
	    pw.close();
	    return str;

	  }
}
