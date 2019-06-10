package com.ai.ecs.dubbo.mapper;

import com.ai.ecs.dubbo.exception.EBPSException;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuwh6 on 2017/7/28.
 */
public class ObjectMapper {

    /**
     * 将map转化成对象
     *
     * @param info
     * @param classType
     * @param <T>
     * @return
     * @throws EBPSException
     */
    public static <T> T createConverObject(Map info, Class<T> classType) throws EBPSException {

        if(classType.getName().equalsIgnoreCase("Map")){
            return (T)info;
        }
        Object objetvalue = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(classType); // 获取类属性
            objetvalue = classType.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
//                Class filedtype = descriptor.getPropertyType();
                String propertyName = descriptor.getName();
//                System.out.println(propertyName);
                if (propertyName.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                if (info.containsKey(propertyName)) {
                    Object filevaluedc = info.get(propertyName);
//                    System.out.println("type="+filedtype.getName());
//                    System.out.println("filevaluedctype="+filevaluedc.getClass().getName());
                    //
                    if (filevaluedc != null) {
                        //为了处理非对象类型，如 int 等对象，将其屏蔽
//                        if(!filedtype.isInstance(filevaluedc)){
//                            continue;
//                        }
                        Object[] args = new Object[1];
                        args[0] = filevaluedc;
                        try {
                            descriptor.getWriteMethod().invoke((Object) objetvalue, args);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new EBPSException(21,e);
        }
        System.out.println(objetvalue);
        return (T) objetvalue;

    }

    /**
     * 将对象转化成map
     *
     * @param obj
     * @return
     * @throws EBPSException
     */
    public static Map converMap(Object obj) throws EBPSException {
        Map info = new HashMap();
        Class classname = obj.getClass();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(classname);
//            System.out.println(classname);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (propertyName.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method method = descriptor.getReadMethod();
//                System.out.println(propertyName);
                if (method != null) {
                    try {
                        Object value = method.invoke(obj);
                        if (value != null) {
                            info.put(propertyName, value);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
//            e.fillInStackTrace();
           throw new EBPSException(22,e);
        }
        return info;
    }


}
