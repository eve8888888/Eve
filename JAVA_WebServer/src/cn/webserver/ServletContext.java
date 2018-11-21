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

/**
 * @Author: Eve
 * @Date: 2018/11/21 8:25
 * @Version 1.0
 */
public class ServletContext {
    public static Map<String,String> map;
    static {
        init();
    }
    public static void init(){
        setUrlMapping();
    }
    //把请求的路径（映射名）和类之间建立关联关系
    public static void setUrlMapping(){
        map = new HashMap<>();

        //解析web.xml文件
        SAXReader reader = new SAXReader();
        try {
            //把文件解析成文档
            Document document = reader.read(new FileInputStream("conf/ServletMapping.tld"));
            //获取根节点对象
            Element root = document.getRootElement();
            //获取子节点
            @SuppressWarnings("all")
            List<Element> list = root.elements("mapping");
            for (Element e :
                    list) {
                String name = e.attributeValue("uri");
                String value = e.attributeValue("className");
                map.put(name,value);
            }
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
