package com.ai.ecs.dubbo.configure;

import com.ai.ecs.dubbo.node.IEbpsflow;
import com.ai.ecs.dubbo.util.FileUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/8/3.
 */
public class JsonConfigure implements Configure {

    public IEbpsflow init(String filename) {
        if(filename!=null){
            String filecontent = FileUtil.getFileContent(filename);
            if(filecontent!=null){
               JSONObject json =  JSONObject.parseObject(filecontent);
            }
        }
        return null;
    }

    public String createJsonLcu(){
        JSONObject obj = new JSONObject();
        JSONArray links = new JSONArray();
        JSONArray nodes = new JSONArray();
        JSONObject startNode = new JSONObject();
        startNode.put("interface","com.alibaba.dubbo.demo.ExecuteIntf");
        startNode.put("type","action");
        startNode.put("servicename","executeFlow");
        startNode.put("method","helloFlow");
        startNode.put("name","node1");



        JSONObject conNode = new JSONObject();
        conNode.put("condition","name=='wuwenhui'");
        conNode.put("type","SWITCH");
        conNode.put("sucessful","line2");
        conNode.put("method","helloFlow");
        conNode.put("else","line2");
        conNode.put("name","c1");


        JSONObject start = new JSONObject();
        start.put("type","start");
        start.put("name","start");



        JSONObject param = new JSONObject();
        param.put("type","PARAMNODE");
        param.put("name","param");
        param.put("statement","output.param='1234'");





        JSONObject end = new JSONObject();
        end.put("type","END");
        end.put("name","end");

        nodes.add(start);
        nodes.add(end);
        nodes.add(startNode);
        nodes.add(conNode);
        nodes.add(param);

        JSONObject _linke = new JSONObject();
        _linke.put("name","line1");
        _linke.put("from","param");
        _linke.put("to","node1");

        JSONObject _linkep = new JSONObject();
        _linkep.put("name","line1");
        _linkep.put("from","start");
        _linkep.put("to","param");



        JSONObject _linke3 = new JSONObject();
        _linke3.put("name","line1");
        _linke3.put("from","node1");
        _linke3.put("to","c1");

        JSONObject _linke2 = new JSONObject();
        _linke2.put("name","line2");
        _linke2.put("from","c1");
        _linke2.put("to","end");



        links.add(_linke);
        links.add(_linke2);
        links.add(_linke3);
        links.add(_linkep);
//        links.add(_linke3);

        obj.put("nodes",nodes);
        obj.put("links",links);
        return obj.toJSONString();
    }

    public static void main(String[] a){
        JsonConfigure cong = new JsonConfigure();
        String filecontent=cong.createJsonLcu();
        System.out.print(filecontent);
        FileUtil.writeFile("D://temp/flow.json",filecontent);

        cong.init("D://temp/flow.json");

    }



}
