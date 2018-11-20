package webserver;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Eve
 * @Date: 2018/11/19 16:30
 * @Version 1.0
 */

/**
 *  封装web应用的介质类型
 */
public class HttpContext {
    static {
        mimeType = new HashMap<>();
        init();
    }
    private  static Map<String,String> mimeType;
    public static void init(){
        setMimeType();
    }
    public static void setMimeType(){
        mimeType.put("html","text/html");
        mimeType.put("png","image/png");
    }
    public static String getMimeType(String name){
        return mimeType.get(name);
    }
}

