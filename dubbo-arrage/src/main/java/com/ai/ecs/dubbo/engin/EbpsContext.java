package com.ai.ecs.dubbo.engin;

import com.ai.ecs.dubbo.common.Token;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.engin.intf.IEngine;
import com.ai.ecs.dubbo.node.IEbpsNode;
import com.ai.ecs.dubbo.node.IEbpsflow;
import com.ai.ecs.dubbo.spi.FactoryBean;
import com.ai.ecs.dubbo.spi.SpringFacotryBean;
import com.ai.ecs.dubbo.spi.SpringHolder;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
public class EbpsContext implements IEbpsContext {
    private Map<String,Map> params = new HashMap<String, Map>();
    private String ebspName;
    private IEbpsflow self;
    static final String FIELD_INPUT="input";
    static final String FIELD_OUTPUT="output";
    private FactoryBean app = new SpringFacotryBean(SpringHolder.getApplicationContext());


//    @Override
//    public Map<String, Variable> getAllParamsByMap() {
//        return params;
//    }

    @Override
    public Map<String, Map> getAllParams() {
       return this.params;
    }

//    @Override
//    public List<Variable> getAllParams() {
//        return null;
//    }

    @Override
    public String getEBpsName() {
        return ebspName;
    }

    @Override
    public void clear() {
        params.clear();

    }

    @Override
    public Map getVariable(String name) {
        return (Map)this.params.get(name);
    }

    @Override
    public IEbpsflow getEbpsflow() {
        return this.self;
    }

    @Override
    public void initParams(Map input) {
//        Variable va = new Variable();
//        va.attributeName=FIELD_INPUT;
//        va.obj=input;
        this.params.put(FIELD_INPUT,input);
    }

    @Override
    public void setEbpsflow(IEbpsflow ebps) {
        self = ebps;
    }

    @Override
    public Token getToken() {
        return null;
    }

    @Override
    public IEngine getIEngine() {
        return null;
    }

    @Override
    public Token setToken(IEbpsNode node) {
        return null;
    }

    @Override
    public Map getInput() {
        return (Map)this.params.get(FIELD_INPUT);

    }

    @Override
    public Map getOutput() {
       return  (Map<String,Object>)this.get(FIELD_OUTPUT);
    }

    @Override
    public void put(String name, Object obj) {
        Map var = new HashMap();
//        var.attributeName = name;
//        var.obj = obj;
        this.params.put(name,var);


    }

    @Override
    public Object get(String name) {
        Map var = this.params.get(name);
        if(var==null){
//            var = new Variable();
//            var.obj = new HashMap<String,Object>();
//            this.params.put(name,var);
            var = new HashMap();
            this.params.put(name,var);

        }

        return var;
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void rollback() {

    }

    @Override
    public void commit() {

    }

    @Override
    public FactoryBean getAppContext() {
        return this.app;
    }



}
