package com.ai.ecs.dubbo.node;

import com.ai.ecs.dubbo.EBPS;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/4.
 */
public  abstract class AbstractNode implements IEbpsNode {

    //节点属性
    private Map<String,Object> attr = new HashMap<String,Object>();

    public EBPS.NodeType type;

    public final Logger loger = LoggerFactory.getLogger(this.getClass());


    public AbstractNode(EBPS.NodeType nodeType){
        this.type = nodeType;
    }
    private String name;

    public Map<String, Object> getAttr() {
        return attr;
    }
    public Object getAttrValue(String name) {
        return this.attr;
    }

    public String getName() {
        return this.name;
    }

    public EBPS.NodeType getNodeType() {
        return this.type;
    }
    public void setAttr(String name, String value) {
        this.attr.put(name,value);
    }

    public void setAttr(String name, Object value) {
        this.attr.put(name,value);

    }

    public String getAttr(String name) {
        return (String)this.attr.get(name);
    }

    public Set getAttrKey() {
        return this.attr.keySet();
    }


    public void setName(String name) {
        this.name = name;
    }


}
