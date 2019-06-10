/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.demo.consumer;
//
//import com.ai.ecs.dubbo.engin.EbpsEngine;
//import com.ai.ecs.dubbo.exception.EBPSException;
import com.alibaba.dubbo.demo.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoAction {
    
    private DemoService demoService;

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

	public void start() throws Exception {

//        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
//            try {
            	String hello = demoService.sayHello("world" );
                System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);

//        EbpsEngine eng = new EbpsEngine();
//        try {
//            Map info =new HashMap();
//            info.put("name","wuwenhui");
//
//            CallBean returnbean = eng.executeEbpsflow("D:\\temp\\flow.json",info,CallBean.class,null);
//            System.out.println("返回值是："+returnbean);
//        } catch (EBPSException e) {
//            e.printStackTrace();
//        }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Thread.sleep(2000);
//        }
	}

}