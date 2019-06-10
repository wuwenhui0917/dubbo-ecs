package com.ai.ecs.dubbo.node;

import com.ai.ecs.dubbo.util.MethodUtil;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */
public class TestMethodUtil extends TestCase {

    public void testMethod(){
        try {
            Class classname = Class.forName("com.alibaba.dubbo.demo.ExecuteIntf");
            try {
                Method me = MethodUtil.parseMethod(classname,"helloFlow(com.alibaba.dubbo.demo.CallBean)");
                System.out.println(me.getParameterTypes());
            } catch (NoSuchMethodException e) {
                Assert.fail();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        }


    }

}
