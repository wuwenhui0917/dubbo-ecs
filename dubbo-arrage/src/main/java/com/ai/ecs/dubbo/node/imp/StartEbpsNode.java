package com.ai.ecs.dubbo.node.imp;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.node.AbstractNode;
import com.ai.ecs.dubbo.node.IEbpsflow;
import com.ai.ecs.dubbo.node.Ilink;

import static com.ai.ecs.dubbo.EBPS.NodeType.START;

/**
 * Created by wuwenhui on 2017/8/4.
 */
public class StartEbpsNode extends AbstractNode {

    public StartEbpsNode(EBPS.NodeType nodeType) {
        super(nodeType);
    }
    public StartEbpsNode(){
        this(START);
    }
    private Ilink nextLink;
    public void setNextLink(Ilink nextLink){
         this.nextLink = nextLink;
    }

    public Ilink execute(IEbpsContext context) throws EBPSException {
        if(loger.isDebugEnabled()){
            loger.debug("进入开始节点");
        }
        IEbpsflow flows = context.getEbpsflow();
        Ilink links = flows.getLinkByFrom(this.getName());
        loger.debug(this.getName()+"===================="+links);
        if(loger.isDebugEnabled()){
            loger.debug("开始节点执行结束");
        }
        return context.getEbpsflow().getLinkByFrom(this.getName());

    }


    public void init() throws EBPSException {



    }

    public Ilink getNextLink() {
        return this.nextLink;
    }


}
