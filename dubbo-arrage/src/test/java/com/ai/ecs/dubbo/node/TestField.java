package com.ai.ecs.dubbo.node;

import ognl.Ognl;
import ognl.OgnlException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */
public class TestField {

    public static void execute(Map info,String executeStatement){
        String[] statems = executeStatement.split(";");
        try {
        for (String stat:statems){

                Ognl.getValue("#root."+stat,info);

        }
        } catch (OgnlException e) {
            e.printStackTrace();
        }



    }

    public static void testMethod(){

        String method = "com.alibaba.dubbo.demo.ExecuteIntf$helloFlow(CallBean,CallBean)";
        List<String> ls=new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<=\\()(.+?)(?=\\))");
        Matcher matcher = pattern.matcher(method);
        if(matcher.find())
            System.out.println(matcher.group());

        System.out.println(ls.size());
        String s = method.split("\\$")[1];
        String methods = s.split("\\(")[0];
        System.out.println("Method"+methods);
        System.out.println(ls);


        //return ls;

//        Class interface_calss = null;
//        try {
//            interface_calss = Class.forName("com.alibaba.dubbo.demo.ExecuteIntf");
//            try {
//
//                Method mt  = interface_calss.getDeclaredMethod("helloFlow", CallBean.class);
//
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public static void main(String[] a){
//        Map info = new HashMap();
//        Map info2 = new HashMap();
//        info2.put("name4","579");
//        info.put("input",info2);
//        info.put("input2",new HashMap());
//        execute(info,"input.value=5;input.name3=input.name4;input2.ccc=input.name4");
//        System.out.println(info);
        testMethod();
    }
}
