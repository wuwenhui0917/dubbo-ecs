package com.ai.ecs.dubbo.configure;

/**
 * Created by Administrator on 2017/8/3.
 */
public class ConfigureFactory {

//    private static ConfigureFactory factory = new ConfigureFactory();
//
//    private ConfigureFactory(){};
    private static  Configure config = null;

    public static  synchronized  Configure getDefaultConfigure(){
        if(config!=null) return config;
        return null;

    }

    public static Configure getConfigureByType(int type){
        return null;

    }
}
