package cn.http;

import cn.webserver.HttpContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Eve
 * @Date: 2018/11/19 14:25
 * @Version 1.0
 */
public class HttpResponse {
    private OutputStream out;
    private File entity;
    //设置响应报头信息
    private Map<String,Object> headers = new HashMap<>();
    public File getEntity() {
        return entity;
    }

    public void setEntity(File entity) {
        this.entity = entity;
    }

    public HttpResponse(OutputStream out) {
        this.out = out;
    }
    public void print(String line){
        try {
            out.write(line.getBytes("ISO8859-1"));
            out.write(13);
            out.write(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //发送响应行到客户端
    public void sendStatus(){
        print("HTTP/1.1 200 OK");
    }
    //发送响应头信息
    public void sendHanders(){
        Set<String> setKeys = headers.keySet();
        for (String name : setKeys){
            String line = name + ":" + headers.get(name);
            print(line);
        }
        print("");
    }
    //响应文件的内容
    public void sendContent(){

        try {
            FileInputStream fin = new FileInputStream(getEntity());
            byte[] buff = new byte[1024 * 4];
            //把文件中数据读到数组中
            int len = fin.read(buff);
            //把数组中数据写到客户端
            out.write(buff,0,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //定义
    public void flush(){
        sendStatus();
        sendHanders();
        sendContent();
    }
    public void setCotentType(String type){
        headers.put("Content-Type",type);
    }
    public void setCotentLength(int len){
        headers.put("Content-Length",len+"");
    }

    public void sendRedirect(String path){
        File file = new File("webapps" + path);
        String name1 = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        setCotentType(HttpContext.getMimeType(name1));
        setCotentLength((int) file.length());
        setEntity(file);
        flush();
    }
}