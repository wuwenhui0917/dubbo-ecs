import junit.framework.TestCase;
import ognl.Ognl;
import ognl.OgnlException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuwenhui on 2017/11/14.
 * since
 *
 * @version 1.0
 */
public class TestEbpsEngine extends TestCase {
    public void testEbpsExecute(){
        Map root = new HashMap();
        //Ognl.setRoot(root,root);
        root.put("inut",new HashMap());
        Map out = new HashMap();
        out.put("age",12);
        out.put("name","wuwenhui");
        root.put("output",out);
        try {
            Ognl.getValue("#root.output.para='测试'",root);
        } catch (OgnlException e) {
            e.printStackTrace();
        }


    }
}
