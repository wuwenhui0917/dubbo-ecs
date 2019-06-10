package com.alibaba.dubbo.remoting.transport.extnetty.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Copyright wuwenhui
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class NetAddressConfig {

    private final static String ADDRESS_NET_FILE="dubbo.properties";

    public final static String ADDRESS_NET_IP="dubbo.iplist";


    private Properties config = new Properties();

    private static NetAddressConfig instace = new NetAddressConfig();

    public static NetAddressConfig getNetAddressConfig(){
        return instace;

    }
    private NetAddressConfig(){
        init();
    }

    private void init(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader==null){
            loader = this.getClass().getClassLoader();
        }
        if(loader==null){
            loader = ClassLoader.getSystemClassLoader();
        }
        if(loader!=null){
            InputStream input = loader.getResourceAsStream(ADDRESS_NET_FILE);
            try {
                config.load(input);
            } catch (IOException e) {
            }
            finally {
                try {
                    input.close();
                } catch (IOException e) {
                }

            }
        }

    }

    public String[] getWhiteListIp(){
       return this.config.getProperty(ADDRESS_NET_IP,"-1").split(",");
    }

    public String getValue(String key){
        return this.config.getProperty(key);
    }

    /**
     * 判断此IP是不是符合ip配置的要求
     * @param hostName
     * @return
     */
    public boolean isWhiteIp(String hostName){
        if(hostName==null||"".equals(hostName)) {return false;}
        String[] ips = this.getWhiteListIp();
        if(ips.length==1&&"-1".equals(ips[0])){return true;}
        for(String ipString :ips){
            if(hostName.contains(ipString)){ return true;}
        }
        return false;
    }


}
