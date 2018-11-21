package cn.web;

import cn.http.HttpRequest;
import cn.http.HttpResponse;
import cn.http.HttpServlet;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: Eve
 * @Date: 2018/11/20 16:26
 * @Version 1.0
 */
public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        String name = request.getParame("name");
        try {
            name = URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String ps = request.getParame("ps");

        String psMd5 = DigestUtils.md5Hex(ps);
        System.out.println(name +"," + psMd5);
        //把数据写到数据文件
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream("user.txt",true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println(name +"#" + psMd5);
        out.close();
        //返回响应页面到客户端
        response.sendRedirect("/myweb/regok.html");
    }
}
