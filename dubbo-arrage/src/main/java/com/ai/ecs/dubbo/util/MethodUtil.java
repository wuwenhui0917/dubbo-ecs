package com.ai.ecs.dubbo.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */
public class MethodUtil {

    /**
     * 处理method  类型如：helloFlow(com.alibaba.dubbo.demo.CallBean)
     * @param ClassName
     * @param method
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static Method parseMethod(Class ClassName,String method) throws ClassNotFoundException, NoSuchMethodException {
        //String method = "com.alibaba.dubbo.demo.ExecuteIntf$helloFlow(CallBean,CallBean)";
        List<Class> ls=new ArrayList<Class>();
        Pattern pattern = Pattern.compile("(?<=\\()(.+?)(?=\\))");
        Matcher matcher = pattern.matcher(method);
        //匹配到了
        if(matcher.find()){
            String paramClass = matcher.group();
            String[] classStr = paramClass.split("\\,");
            for(String paramType:classStr){
                Class cla_paramClass = Class.forName(paramClass);
                ls.add(cla_paramClass);
            }
//            ls.add(cla_paramClass);
        }

        Class[] paramClass = new Class[ls.size()];
        ls.toArray(paramClass);
        String methods = method.split("\\(")[0];
        Method array_methods = null;
        if(!ls.isEmpty()){
             array_methods= ClassName.getMethod(methods,paramClass);
        }
        else {
             //array_methods = ClassName.getMethod(methods);
            array_methods = getMethod(ClassName,methods);
        }
        return array_methods;
    }

    /**
     * 依据名字做模糊匹配，相同的名字，以先后顺序为主
     * @param ClassName
     * @param method
     * @return
     */
    public static Method getMethod(Class ClassName,String method){
        Method[] methd = ClassName.getMethods();
        for(Method meth:methd){
            if(meth.getName().equalsIgnoreCase(method)){
                return meth;
            }
        }
        return null;

    }

}
