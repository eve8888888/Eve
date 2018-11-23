package cn.web;

import cn.http.HttpRequest;
import cn.http.HttpResponse;
import cn.http.HttpServlet;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.net.URLDecoder;

/**
 * @Author: Eve
 * @Date: 2018/11/21 16:08
 * @Version 1.0
 */
public class DeleteServlet extends HttpServlet {
    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            String name = request.getParame("name");
            name = URLDecoder.decode(name, "UTF-8");
            String ps = request.getParame("ps");
            String psMd5 = DigestUtils.md5Hex(ps);

            BufferedReader br = new BufferedReader(new FileReader("user.txt"));
            String str;
            String temp = "";
            boolean flag = false;
            while ((str = br.readLine()) != null) {
                String data[] = str.split("#");
                if (name.equals(data[0]) && psMd5.equals(data[1])) {
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
                response.sendRedirect("/myweb/deleteok.html");
            } else {
                response.sendRedirect("/myweb/deleteerror.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
