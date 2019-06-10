package com.ai.ecs.dubbo.node.imp;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.engin.intf.IEbpsContext;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.node.AbstractNode;
import com.ai.ecs.dubbo.node.Ilink;
import com.alibaba.dubbo.common.utils.StringUtils;
import ognl.Ognl;
import ognl.OgnlException;

import java.util.Map;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 * 赋值节点，对其进行赋值
 * 错误码为30400-30500
 *
 * @version 1.0
 */
public class ParamNode extends AbstractNode {

    private String[] statemens =null;
    private String statement;
    public static final String FIELD_STATEMENT="statement";


    public ParamNode(EBPS.NodeType nodeType) {
        super(nodeType);
    }

    public ParamNode(){
        this(EBPS.NodeType.PARAMNODE);
    }

    @Override
    public Ilink execute(IEbpsContext context) throws EBPSException {

        if(loger.isDebugEnabled()){
            loger.debug("开始进入赋值节点");
            loger.debug("执行前结果为"+context.getAllParams());
        }

        Map<String, Map> root = context.getAllParams();
        for (String stat:statemens){
            try {
                Ognl.getValue(stat,root);
            } catch (OgnlException e) {
                e.printStackTrace();
                throw new EBPSException(30401,"执行赋值语句失败,执行的语句是："+stat);
            }

        }
        if(loger.isDebugEnabled()){
            loger.debug("赋值节点执行结束");
            loger.debug("执行结果后变量为："+context.getAllParams());

        }

        loger.debug("name is"+this.getName());

        return context.getEbpsflow().getLinkByFrom(this.getName());
//        return null;
    }



    @Override
    public void init() throws EBPSException {
        this.statement = this.getAttr(FIELD_STATEMENT);
        if(StringUtils.isBlank(this.statement)) throw  new EBPSException(30200,"赋值节点");
        this.statemens = this.statement.split(";");
        for(int i=0;i<this.statemens.length;i++){
//            ClassGenerator.compierOgnl( statemens[i]);
            statemens[i]=EBPS.PARAMSTYPE.OGNL_ROOT+ statemens[i];
        }

    }

    @Override
    public Ilink getNextLink() {
        return null;
    }
}
