package com.ai.ecs.dubbo.node.imp;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.node.AbstractNode;
import com.ai.ecs.dubbo.node.Ilink;

/**
 * Created by wuwenhui on 2017/11/13.
 * since
 *
 * @version 1.0
 */
public class EndEbpsNode extends AbstractNode {

    public EndEbpsNode(EBPS.NodeType nodeType) {
        super(nodeType);
    }

    public EndEbpsNode(){
        this(EBPS.NodeType.END);
    }
    @Override
    public Ilink execute(IEbpsContext context) throws EBPSException {
        if(loger.isDebugEnabled()){
            loger.debug("开始进入结束节点");
        }
        if(loger.isDebugEnabled()){
            loger.debug("流程处理结束");
        }

        return null;
    }

    @Override
    public void init() throws EBPSException {

    }

    @Override
    public Ilink getNextLink() {
        return null;
    }
}
