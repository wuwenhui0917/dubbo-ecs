import com.ai.ecs.dubbo.node.Ilink;
import com.ai.ecs.dubbo.node.imp.JSONEbpsFlow;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by wuwenhui on 2017/11/13.
 * since
 *
 * @version 1.0
 */
public class TestJSONEbpsFlow extends TestCase {

    String fileContext=null;
    JSONEbpsFlow jsonEbpsFlow = null;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        FileReader reader = new FileReader(new File("D:\\temp\\flow.json"));
        BufferedReader buffreader = new BufferedReader(reader);
        StringBuilder builder = new StringBuilder();
        String line = buffreader.readLine();
        while(line!=null){
            builder.append(line);
            line = buffreader.readLine();
        }
        buffreader.close();
        this.fileContext = builder.toString();

//        jsonEbpsFlow = new JSONEbpsFlow();
//        jsonEbpsFlow.init(this.fileContext);
    }

    public  void testInit(){
        jsonEbpsFlow = new JSONEbpsFlow();

        try {
            System.out.println(this.fileContext);
            jsonEbpsFlow.init(this.fileContext);
            Assert.assertEquals(1,1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertEquals(1,0);
        }

    }
    public void testgetLink(){
        try {
            Ilink line =  this.jsonEbpsFlow.getLink("line1");
            Assert.assertNotNull(line);
        } catch (Exception e) {
           // Assert.assertEquals(1,2);
            e.printStackTrace();
        }

    }

//    public void testEnum(){
//        EBPS.NodeType  action=  EBPS.NodeType.valueOf("ACTION");
//        int i =0;
//        for(EBPS.NodeType e:EBPS.NodeType.values() ){
//
//            if(e.equals(action))
//        }
//    }
}
