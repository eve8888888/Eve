package cn.web;

import cn.http.HttpRequest;
import cn.http.HttpResponse;
import cn.http.HttpServlet;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.net.URLDecoder;

/**
 * @Author: Eve
 * @Date: 2018/11/21 14:27
 * @Version 1.0
 */
public class ModifyServlet extends HttpServlet {
    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            String name = request.getParame("name");
            name = URLDecoder.decode(name, "UTF-8");
            String ps = request.getParame("ps");
            String psMd5 = DigestUtils.md5Hex(ps);
            String newps = request.getParame("newps");
            newps = DigestUtils.md5Hex(newps);

            BufferedReader br = new BufferedReader(new FileReader("user.txt"));
            String str;
            String temp = "";
            boolean flag = false;
            while ((str = br.readLine()) != null) {
                String data[] = str.split("#");
                if (name.equals(data[0]) && psMd5.equals(data[1])) {
                    temp = temp + data[0] +"#"+ newps +"#"+ data[2] +"#"+ data[3] + "\n";
                    flag = true;
                }else {
                    temp = temp + str + "\n";
                }
            }
            br.close();
            PrintStream out = new PrintStream(new FileOutputStream("user.txt"));
            out.println(temp);
            out.close();
            if (flag) {
                response.sendRedirect("/myweb/modifyok.html");
            } else {
                response.sendRedirect("/myweb/modifyerror.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
