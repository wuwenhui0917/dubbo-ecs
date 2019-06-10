package com.ai.ecs.dubbo.util;

/**
 * Created by wuwenhui on 2017/11/18.
 * since
 *
 * @version 1.0
 */
public class StringUitl {

    /**
     * 判断输入的字符串是否为空
     * @param
     * @return
     */
    public static boolean isBlank(String s){
        if(s==null||"".equals(s)) return true;
        return false;
    }
}
