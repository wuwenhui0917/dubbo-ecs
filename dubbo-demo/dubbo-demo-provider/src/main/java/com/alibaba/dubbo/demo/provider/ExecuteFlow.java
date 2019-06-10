package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.CallBean;
import com.alibaba.dubbo.demo.ExecuteIntf;

/**
 * Created by wuwenhui on 2017/11/14.
 * since
 *
 * @version 1.0
 */
public class ExecuteFlow implements ExecuteIntf {

    public CallBean helloFlow(CallBean calbean) {
        CallBean call = new CallBean();

        call.setAge(12);
        call.setName(calbean.getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+calbean);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%"+call);

        return call;
    }
}
