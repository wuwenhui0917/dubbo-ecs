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
 * Created by wuwenhui on 2017/11/18.
 * since
 * 判断节点：异常码定义为30300-30100
 *
 * @version 1.0
 */
public class ConditionNode extends AbstractNode {

    private String okLink;
    private String filtLink;
    private String condion;

    /*成功时的指向名称*/
    public final static String OK_LINK_FILED_NAME="sucessful";
    /**失败时的指向名称*/
    public final static  String F_LINK_FILED_NAME="else";
    /** 获取条件判断的*/
    public final static String CONDITION="condition";
    /**输入参数名称*/
    public final static  String INPUT_FILED="input";
    /**编译后的对象*/
    private Object compl;
    public ConditionNode(){
        this(EBPS.NodeType.SWITCH);
    }
    public ConditionNode(EBPS.NodeType nodeType) {
        super(nodeType);
    }
    @Override
    public Ilink execute(IEbpsContext context) throws EBPSException {

        if(loger.isDebugEnabled()){
            loger.debug("开始进入判断节点：");
            loger.debug("输入参数为——————>"+context.getInput());
            loger.debug("执行表达式为——————>"+this.condion);

        }
         Map<String, Map> root = context.getAllParams();
        Boolean b =Boolean.FALSE;
        if(this.compl==null){
            return context.getEbpsflow().getLink(this.filtLink);
        }
        try {
             b = (Boolean) Ognl.getValue(this.compl,root);
        } catch (Exception e) {
            throw  new EBPSException(30103,"执行判断节点失败异常原因：确认表达式返回值是否是boolean类型，判断节点只接受返回值是 boolean 类型的表达式");
        }
        if(loger.isDebugEnabled()){
            loger.debug("判断节点执行结束：结果为———————>"+b);
        }
        if(b.equals(Boolean.TRUE)){
            return context.getEbpsflow().getLink(this.okLink);
        }
        else {
            return context.getEbpsflow().getLink(this.filtLink);
        }
    }

    @Override
    public void init() throws EBPSException {
        this.okLink = this.getAttr(this.OK_LINK_FILED_NAME);
        this.filtLink = this.getAttr(this.F_LINK_FILED_NAME);
        this.condion = this.getAttr(this.CONDITION);
        if(StringUtils.isBlank(this.okLink)) throw  new EBPSException(30100,"判断节点成功时跳转不能为空");
        if(StringUtils.isBlank(this.filtLink)) throw  new EBPSException(30101,"判断节点失败时跳转不能为空");
        if(StringUtils.isBlank(this.condion)) throw  new EBPSException(30102,"判断条件不能为空");
        String realcondion = "#root."+this.condion;
        try {
            this.compl = Ognl.parseExpression(realcondion);
        } catch (OgnlException e) {
            throw new EBPSException(30103,"表达式"+this.condion+"编译错误");
        }


    }

    @Override
    public Ilink getNextLink() {
        return null;
    }
}
