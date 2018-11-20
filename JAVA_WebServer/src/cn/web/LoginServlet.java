package cn.web;

import cn.http.HttpRequest;
import cn.http.HttpResponse;
import cn.http.HttpServlet;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @Author: Eve
 * @Date: 2018/11/20 16:33
 * @Version 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        try {
            String name = request.getParame("name");
            name = URLDecoder.decode(name, "UTF-8");
            String ps = request.getParame("ps");
            String psMd5 = DigestUtils.md5Hex(ps);
            System.out.println("***********" + name);
            System.out.println("***********" + ps);
            BufferedReader br = new BufferedReader(new FileReader("user.txt"));
            String str;
            boolean flag = false;
            while ((str = br.readLine()) != null) {
                String data[] = str.split("#");
                if (name.equals(data[0]) && psMd5.equals(data[1])) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                forward("/myweb/loginok.html", request, response);
            } else {
                forward("/myweb/loginerror.html", request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
