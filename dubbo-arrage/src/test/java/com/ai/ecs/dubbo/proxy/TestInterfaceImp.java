package com.ai.ecs.dubbo.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class TestInterfaceImp implements  TestInterface {
    @Override
    public void test() {

    }

    @Override
    public Map getMap() {
        HashMap info = new HashMap();
        info.put("hell","你好");
        return info;
    }
}
