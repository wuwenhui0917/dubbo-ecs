/**
 * Created by Administrator on 2017/11/30.
 */


/**
 * 依据不同的节点类型生成不同的
 * @param obj
 */
function buildNode(id,obj){
        var nodehtml="";
        //动作节点
        if(obj.type=='action'){
            nodehtml = "<table>"
                +"<tr><td class=\"th\">名称：</td><td><input type=\"text\" style=\"width:250px\" id=\"name\"  readonly='readonly'  value='"+obj.name+"'/>"
                +"<input type='hidden' id='node_id' value='" +id+  "'/>"
                +"</td></tr>"
                +"<tr><td class=\"th\">类型：</td><td>动作节点</td></tr>"

                +"<tr><td class=\"th\">调用服务名：</td><td><input type=\"text\" style=\"width:250px\" id=\"interface\" value='"+obj.interface+"'   /></td></tr>"
                +"<tr><td class=\"th\">调用方法申明：</td><td><input type=\"text\" style=\"width:250px\" id=\"method\" value='"+obj.method+"' /></td></tr>"
                +"</table>";


        }
        //开始节点
        else if(obj.type=='start'){
            nodehtml = "<table>"
                +"<tr><td class=\"th\">名称：</td><td><input type=\"text\" style=\"width:250px\" id=\"name\"  readonly='readonly'  value='"+obj.name+"'/>"
                +"<input type='hidden' id='node_id' value='" +id+  "'/>"
                +"</td></tr>"
                +"<tr><td class=\"th\">类型：</td><td>开始节点</td></tr>"

                +"</table>";
        }
        //判断节点
        else if(obj.type=='SWITCH'){
            nodehtml = "<table>"
                +"<tr><td class=\"th\">名称：</td><td><input type=\"text\" style=\"width:250px\" id=\"name\"  readonly='readonly'  value='"+obj.name+"'/>"
                +"<input type='hidden' id='node_id' value='" +id+  "'/>"
                +"</td></tr>"                +"<tr><td class=\"th\">类型：</td><td>判断节点</td></tr>"
                +"<tr><td class=\"th\">判断条件：</td><td><textarea type=\"text\" style=\"width:250px\" rows=\"3\" cols=\"25\" id=\"condition\" >"+obj.condition+"</textarea></td></tr>"
                +"<tr><td class=\"th\">成功跳转：</td><td><input type=\"text\" style=\"width:250px\" id=\"sucessful\" value='"+obj.sucessful+"' /></td></tr>"
                +"<tr><td class=\"th\">失败跳转：</td><td><input type=\"text\" style=\"width:250px\" id=\"else\" value='"+obj.else+"' /></td></tr>"
                +"</table>";
        }
        //赋值节点
        else if(obj.type=='PARAMNODE'){
            nodehtml = "<table>"
                +"<tr><td class=\"th\">名称：</td><td><input type=\"text\" style=\"width:250px\" id=\"name\"  readonly='readonly'  value='"+obj.name+"'/>"
                +"<input type='hidden' id='node_id' value='" +id+  "'/>"
                +"</td></tr>"                +"<tr><td class=\"th\">类型：</td><td>赋值节点</td></tr>"
                +"<tr><td class=\"th\">赋值语句：</td><td><textarea  type=\"text\" style=\"width:250px\"  rows=\"3\" cols=\"25\"  id=\"statement\" >"+obj.statement+"</textarea></td></tr>"
                +"</table>";
        }
        //结束节点
        else if(obj.type=='end'){
            nodehtml = "<table>"
                +"<tr><td class=\"th\">名称：</td><td><input type=\"text\" style=\"width:250px\" id=\"name\"  readonly='readonly'  value='"+obj.name+"'/>"
                +"<input type='hidden' id='node_id' value='" +id+  "'/>"
                +"</td></tr>"                +"<tr><td class=\"th\">类型：</td><td>结束节点</td></tr>"
                +"</table>";
        }

        console.log(nodehtml)
        return nodehtml;

}

function loadMainframe(flow) {
    var frame =" <table>" +
        "<tr><td class=\"th\">流程名称：</td><td><input type=\"text\" style=\"width:250px;height: 30px;\" id=\"flow_name\"  value='"+flow.$title+"'  /></td></tr>" +
        "<tr><td class=\"th\">流程说明：</td><td><textarea type=\"text\" style=\"width:250px\" id=\"desc\" rows=\"5\">"+flow.$desc+"</textarea></td></tr>" +
        "<tr><td class=\"th\">事务类型：</td><td><select id=\"trans\" style=\"width:250px;height: 30px;\"><option value=\"local\" selected>无事务控制" +
             "</option><option value=\"local\">本地事务</option><option  value=\"XA\">两阶段提交</option><option value=\"cp\">最终一致性</option></select></td></tr>" +
        "<tr><td class=\"th\">创建人：</td><td><input type=\"text\" style=\"width:250px;height: 30px;\" id=\"ele_create\" value='"+flow.$create+"' /></td></tr>" +
        "</table>";
     return frame;
}


function testFlow(flowContext) {
    var options={};
    var data={};
    data.flow = flowContext;
    options.url="/flow/test";
    options.type="post"
    options.data=data;
    options.success=function (result,status,xhr) {
        //window.alert("处理成功："+JSON.stringify(result))
        $("#result").val(JSON.stringify(result));


    }

    $.ajax(options);
}

/**
 * 获取从这个节点的过来的线
 * @param formid
 * @param flow
 * @returns {*}
 */
function getLinkInfoByFrom(fromNodeid,flow) {

    var resul=[];
    var lineinfo=flow.$lineData;
    for(var line in lineinfo){
        var formline = lineinfo[line].from;
        if(formid==formline){
            result.push(lineinfo[line].name);
        }

    }
    return result;


}

function eheckFlow(node,flow){
	
}

function  modifyNode(flow) {


    if(document.getElementById('flow_name')){
        flow.setTitle($("#flow_name").val());
        flow.$create=$("#ele_create").val();
        flow.$desc=$("#desc").val();
        return ;
    }


    var ele_name = $("#node_id").val();
    console.log(flow.$nodeData);
    var nodeData = flow.$nodeData[ele_name];
    console.log(">>>>>>>>>>>>>"+nodeData);
    if(!nodeData) return ;
    //动作
    if(nodeData.type=='action'){
        nodeData.servicename=$("#servicename").val();
        nodeData.interface=$("#interface").val();
        nodeData.method=$("#method").val();
        // nodeData.method=$("#method").val();

    }
    //选择
    else if(nodeData.type=='SWITCH') {
        nodeData.condition=$("#condition").val();
        nodeData.sucessful=$("#sucessful").val();
        nodeData.else=$("#else").val();
        console.log($("#condition").val()+">>>>>>>>..");

    }
    //赋值
    else if(nodeData.type=='PARAMNODE') {
        nodeData.statement=$("#statement").val();
        console.log(">>>>>>>>>>>>>>>>>>>>>>")
    }


}
