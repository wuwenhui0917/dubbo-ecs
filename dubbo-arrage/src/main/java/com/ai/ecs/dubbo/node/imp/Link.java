package com.ai.ecs.dubbo.node.imp;

import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.node.Ilink;

/**
 * Created by Administrator on 2017/8/9.
 */
public class Link implements Ilink {

    private String formName;
    private String toName;
    private String name;
    public Link(String formName,String toName,String name){
        this.formName = formName;
        this.toName = toName;
        this.name = name;
    }
    public String getFormNode() {
        return this.formName;
    }

    public String getToNode() {
        return this.toName;
    }

    public String getName() throws EBPSException {
        return this.name;
    }

    @Override
    public String toString() {
        return "name:"+this.name+" from:"+this.formName+" to:"+this.toName;
    }
}
