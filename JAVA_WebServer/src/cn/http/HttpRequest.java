package cn.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Eve
 * @Date: 2018/11/19 10:49
 * @Version 1.0
 */
public class HttpRequest {
    private String method;
    private String url;
    private String protocol;

    public HttpRequest(InputStream in) {
        parseRequestLine(in);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getProtocol() {
        return protocol;
    }

    //解析请求行，给三个变量赋值,在构造方法调用
    private void parseRequestLine(InputStream in) {
        int d;
        char c1 = '\u0000', c2;
        //用来存放报头信息第一行
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //获取http协议的报头信息
            while ((d = in.read()) != -1) {
                //System.out.print((char)d);
                c2 = (char) d;
                if ((int) c1 == 13 && (int) c2 == 10) {
                    break;
                }
                stringBuilder.append(c2);
                c1 = c2;
            }
            String[] str = stringBuilder.toString().split("\\s");
            method = str[0];
            url = str[1];
            protocol = str[2];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

