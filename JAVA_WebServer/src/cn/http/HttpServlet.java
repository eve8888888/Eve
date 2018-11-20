package cn.http;

import cn.webserver.HttpContext;

import java.io.File;

/**
 * @Author: Eve
 * @Date: 2018/11/20 16:23
 * @Version 1.0
 */
public abstract class HttpServlet {
    protected abstract void service(HttpRequest request, HttpResponse response);
    public void forward(String path,HttpRequest httpRequest,HttpResponse httpResponse){
        File file = new File("webapps" + path);
        String name1 = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        httpResponse.setCotentType(HttpContext.getMimeType(name1));
        httpResponse.setCotentLength((int) file.length());
        httpResponse.setEntity(file);
        httpResponse.flush();
    }
}
