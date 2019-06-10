import com.ai.ecs.dubbo.mapper.ObjectMapper;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/28.
 */
public class TestObjectMapper {

    public  static void main(String[] a){
        Bean1 b1 = new Bean1();
        Bean2 bean2 = new Bean2();
        b1.setName("wuwenhui");
        b1.setSex(2);
        //Map info = new HashMap();
        try {
            Map info = ObjectMapper.converMap(b1);
            System.out.println(info);
            bean2 = ObjectMapper.createConverObject(info,bean2.getClass());
            System.out.print(bean2);
//            org.apache.commons.beanutils.BeanUtils.populate(b1,info);
//            System.out.println(info);

//
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
