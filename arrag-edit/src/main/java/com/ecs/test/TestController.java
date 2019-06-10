package com.ecs.test;

import com.ai.ecs.dubbo.engin.EbpsEngine;
import com.ai.ecs.dubbo.engin.intf.IEngine;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.spi.SpringHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuwenhui on 2017/12/20.
 * since
 *
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/flow")
public class TestController
{
    @RequestMapping(value = "/test")
    @ResponseBody
    public Map test(HttpServletRequest request, HttpServletResponse resp){
        String flow = request.getParameter("flow");
        ApplicationContext webApplicationContext = SpringHolder.getApplicationContext();
//        Object intr = webApplicationContext.getBean("executeFlow");
//        System.out.println(intr);

        Map info = new HashMap();

        if(StringUtils.isNotBlank(flow)){
            IEngine eng = new EbpsEngine();
            try {
                info = eng.executeEbpsflowByContext(flow,info,null,webApplicationContext);
                info.put("sucessful","0");
            } catch (EBPSException e) {
                e.printStackTrace();
                info.put("sucessful","-1");
            }
        }



        return info;

    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map saveFlow(HttpServletRequest request, HttpServletResponse resp){
       request.getParameter("");
       return null;

    }


}
