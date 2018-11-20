package cn.webserver;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Eve
 * @Date: 2018/11/19 16:30
 * @Version 1.0
 */

/**
 *  封装web应用的介质类型
 */
public class HttpContext {
    static {
        init();
    }
    private  static Map<String,String> mimeType;
    private static void init(){
        setMimeType();
    }
    private static void setMimeType(){
        mimeType = new HashMap<>();
        //解析web.xml文件
        SAXReader reader = new SAXReader();
        try {
            //把文件解析成文档
            Document document = reader.read(new FileInputStream("conf/web.xml"));
            //获取根节点对象
            Element root = document.getRootElement();
            //获取子节点
            @SuppressWarnings("all")
            List<Element> list = root.elements("mime-mapping");
            for (Element e :
                    list) {
                String name = e.elementText("extension");
                String value = e.elementText("mime-type");
                mimeType.put(name,value);
            }
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String getMimeType(String name){
        return mimeType.get(name);
    }
}

