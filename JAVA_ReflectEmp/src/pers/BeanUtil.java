package pers;

import java.lang.reflect.Method;

/**
 * @Author: Eve
 * @Date: 2018/12/2 15:42
 * @Version 1.0
 */
public class BeanUtil {
    public static void setValue(Object action,String str) throws Exception{
        String[] temp = str.split("\\|");
        for (int i = 0; i < temp.length; i++) {
            String[] temp2 = temp[i].split(":");
            String value = temp2[1];
            String className = temp2[0].split("\\.")[0];
            String setName = temp2[0].split("\\.")[1];
//            Object realObj = getRealObject(action,className);
//            Class<?> cls = realObj.getClass();
//            String sName = "set"+initCap(setName);
//            Method method = cls.getMethod(sName,String.class);
//            method.invoke(realObj,value);
            getRealObject(action,className).getClass().getMethod(
                    "set"+initCap(setName),String.class).invoke(getRealObject(action,className),value);
        }
    }
    public static Object getRealObject(Object action,String className) throws Exception{
        return action.getClass().getMethod("get"+initCap(className)).invoke(action);
    }
    public static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
