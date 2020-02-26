package com.ai.ecs.dubbo.node.imp;

import com.ai.ecs.dubbo.EBPS;
import com.ai.ecs.dubbo.common.Variable;
import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.node.AbstractNode;
import com.ai.ecs.dubbo.node.IEbpsNode;
import com.ai.ecs.dubbo.node.IEbpsflow;
import com.ai.ecs.dubbo.node.Ilink;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by wuwh6 on 2017/8/4.
 */
public class JSONEbpsFlow implements IEbpsflow {
    //node节点列表
    private static final String NODE="nodes";
    private static final String NODE_TYPE="type";
    private static final String LINKS="links";
    private StartEbpsNode  startEbpsEnode;
    private JSONObject json = null;
    //节点集合
    private Map<String,IEbpsNode> nodes = new HashMap<String,IEbpsNode>();
    //线节点
    private Map<String,Ilink> links = new HashMap<String,Ilink>();
    //流程名称
    private String flowName;

    /**
     * 依据类型获取下标值
     * @param type
     * @return
     */
    private int getTyeByInt(String type ){
        EBPS.NodeType  action=  EBPS.NodeType.valueOf(type.toUpperCase());
        EBPS.NodeType[] types = EBPS.NodeType.values();
        for(int i=0;i<types.length;i++){
            if(action.equals(types[i])) return i;
        }
        return -1;

    }

    /**
     * 初始化将json报文转化成流程实例
     * @param filecontent
     * @throws Exception
     */
    public void init(String filecontent) throws Exception {
        if(filecontent==null||"".equals(null)){
            throw new EBPSException("文件内容为空");
        }
        if(filecontent!=null){
            json =  JSONObject.parseObject(filecontent);
//            json = JSONObject.parse(filecontent);
        }
        JSONArray nodes = json.getJSONArray(NODE);
        //节点
        for(Object node:nodes){
            JSONObject jobject = (JSONObject) node;
            String strtype = jobject.getString(NODE_TYPE);
            int type = getTyeByInt(strtype);
            AbstractNode ebpsnode = null;
           // EBPS.NodeType[] types = EBPS.NodeType.values();
            switch (type){
                //开始节点
                case 0:{
                    startEbpsEnode= new StartEbpsNode();
                    ebpsnode = startEbpsEnode;
                    break;
                }
                //结束节点
                case 1:{
                    ebpsnode= new EndEbpsNode();
                    ebpsnode.setAttr("name",jobject.getString("name"));
                    break;
                }
                //动作节点
                case 2:{
                    ebpsnode = new ActionNode();
                    ebpsnode.setAttr(ActionNode.EIELD_SERVICE_NAME,jobject.getString(ActionNode.EIELD_SERVICE_NAME));
                    ebpsnode.setAttr(ActionNode.FIELD_INTFACE_NAME,jobject.getString(ActionNode.FIELD_INTFACE_NAME));
                    ebpsnode.setAttr(ActionNode.FIELD_METHOD,jobject.getString(ActionNode.FIELD_METHOD));
                    break;
                }
                //判断条件
                case 3:{
                    ebpsnode = new ConditionNode();
                    ebpsnode.setAttr(ConditionNode.INPUT_FILED,jobject.getString(ConditionNode.INPUT_FILED));
                    ebpsnode.setAttr(ConditionNode.CONDITION,jobject.getString(ConditionNode.CONDITION));
                    ebpsnode.setAttr(ConditionNode.OK_LINK_FILED_NAME,jobject.getString(ConditionNode.OK_LINK_FILED_NAME));
                    ebpsnode.setAttr(ConditionNode.F_LINK_FILED_NAME,jobject.getString(ConditionNode.F_LINK_FILED_NAME));
                    break;
                }
                //赋值节点
                case 7:{
                    ebpsnode = new ParamNode();
                    ebpsnode.setAttr(ParamNode.FIELD_STATEMENT,jobject.getString(ParamNode.FIELD_STATEMENT));
//                    ebpsnode.setAttr(ConditionNode.CONDITION,jobject.getString(ConditionNode.CONDITION));
//                    ebpsnode.setAttr(ConditionNode.OK_LINK_FILED_NAME,jobject.getString(ConditionNode.OK_LINK_FILED_NAME));
//                    ebpsnode.setAttr(ConditionNode.F_LINK_FILED_NAME,jobject.getString(ConditionNode.F_LINK_FILED_NAME));
                    break;
                }
            }
            ebpsnode.setAttr("name",jobject.getString("name"));
            if(StringUtils.isNotBlank(jobject.getString("id"))){
                ebpsnode.setName(jobject.getString("id"));

            }
            else {
                ebpsnode.setName(jobject.getString("name"));

            }

            //初始化处理
            ebpsnode.init();
            this.nodes.put(ebpsnode.getName(),ebpsnode);
        }
        JSONArray links = json.getJSONArray("links");
        initLinks(links);
        this.startEbpsEnode.setNextLink(this.getLinkByFrom(this.startEbpsEnode.getName()));
    }

    /**
     * 初始化 线操作
     * @param linkinfos
     */
    private void initLinks(JSONArray linkinfos){
        for(int i=0;i<linkinfos.size();i++){
            JSONObject line = linkinfos.getJSONObject(i);
            Ilink link = new Link(line.getString("from"),line.getString("to"),line.getString("name"));
            this.links.put(line.getString("name"),link);
        }
    }

//    /**
//     * 获取链接线
//     * @param fromName 从开始节点获取链接线
//     * @return
//     */
//    private Ilink getNextLink(String fromName){
//        if(fromName ==null||"".equals(fromName)) return null;
//        return this.links.get(fromName);
////        for(int i=0;i<links.size();i++){
////            Ilink line = links.get(i);
////            if(line!=null){
////
////            }
////             String LinefromName = line.getFormNode();
////             if(fromName.equals(LinefromName)){
////                 return line;
////             }
////        }
////        return null;
//    }

    public void deloyBpm() throws EBPSException {

    }

    public Ilink getLink(String linkName) throws EBPSException {
        return this.links.get(linkName);
    }

    public IEbpsNode getToNodeByLink(Ilink link) throws EBPSException {
        String toName = link.getToNode();
        if(org.apache.commons.lang.StringUtils.isNotBlank(toName)){
            return this.nodes.get(toName);
        }
        return null;
    }

    public IEbpsNode getNodeByName(String nodeName) {
        return this.nodes.get(nodeName);
    }

    @Override
    public Ilink getLinkByFrom(String fromName) {
        if(fromName==null||"".equals(fromName)) return null;
        Set<Map.Entry<String, Ilink>> sets= this.links.entrySet();
        Iterator<Map.Entry<String, Ilink>> itr = sets.iterator();
        while(itr.hasNext()){
            Map.Entry<String,Ilink> ent = itr.next();
            Ilink link = ent.getValue();
            String fornNode = link.getFormNode();
            if(fromName.equalsIgnoreCase(fornNode)){
                return link;
            }
        }
        return null;

    }

    public IEbpsNode getStartNode() {
        return this.startEbpsEnode;
    }

    public String getFlowName() {
        return this.flowName;
    }

    public void clear() {
         this.links.clear();
         this.nodes.clear();
         this.links = null;
         this.nodes=null;
    }

    public Map<String, Variable> getParamInfos() {
        return null;
    }

    public String getUpdateDate() {
        return null;
    }

    public String getCreator() {
        return null;
    }

    public String getVersion() {
        return null;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }
}
