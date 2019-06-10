package com.ai.ecs.dubbo.node;

import com.ai.ecs.dubbo.exception.EBPSException;
import com.ai.ecs.dubbo.util.ClassGenerator;
import junit.framework.Assert;
import junit.framework.TestCase;
import ognl.Ognl;
import ognl.OgnlException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuwenhui on 2017/11/18.
 * since
 *
 * @version 1.0
 */
public class TestOgnl extends TestCase {

    private Object comp=null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.comp = Ognl.parseExpression( "#root.age==1" );

    }

    public void testCompl(){
        try {
            ClassGenerator.compierOgnl("output='1234'");
        } catch (EBPSException e) {
            Assert.fail();
        }
    }

    public void testOngl(){
        Map<String,Object> info = new HashMap<String,Object>();
        info.put("name","wuwenhui");
        info.put("age",1);

//        SimpleObject root = new SimpleObject();
//        OgnlContext context =  (OgnlContext) Ognl.createDefaultContext(null);
//
//        Node node =  (Node) Ognl.compileExpression(context, root, "user.name");
//        String userName = （String）node.getAccessor().get(context, root)

//        OgnlContext contex = new OgnlContext(info);
        ;

        try {
            Object obj  =Ognl.getValue(comp, info);
            Assert.assertEquals(obj,Boolean.TRUE);
        } catch (OgnlException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
