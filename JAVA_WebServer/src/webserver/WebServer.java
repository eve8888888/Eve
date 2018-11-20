package webserver;

import cn.http.HttpRequest;
import cn.http.HttpResponse;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;


/**
 * @Author: Eve
 * @Date: 2018/11/19 8:31
 * @Version 1.0
 */

public class WebServer {
    //定义套接字对象
    private ServerSocket serverSocket;

    private WebServer() {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("all")
    public void start() {
        while (true) {
            try {
                //可以处理客户端请求
                System.out.println("等待客户端链接。。。");
                Socket socket = serverSocket.accept();

                //使用线程处理客户端请求
                Thread thread = new Thread(new Handler(socket));
                thread.start();
                //关闭

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}
class Handler implements Runnable{
    private Socket socket;
    Handler(Socket socket) {
        this.socket = socket;
    }
    //线程体方法
    @Override
    public void run() {
        //处理客户端请求
        System.out.println("处理客户端请求。。。");
        //需要输入流
        try {
            InputStream inputStream = socket.getInputStream();
            HttpRequest httpRequest = new HttpRequest(inputStream);
            OutputStream outputStream = socket.getOutputStream();
            HttpResponse httpResponse = new HttpResponse(outputStream);

            System.out.println(httpRequest.getMethod());
            System.out.println(httpRequest.getUrl());
            System.out.println(httpRequest.getProtocol());

            if("/myweb/reg".equals(httpRequest.getRequestLine())){
                String name = httpRequest.getParame("name");
                name = URLDecoder.decode(name,"UTF-8");
                String ps = httpRequest.getParame("ps");

                String psMd5 = DigestUtils.md5Hex(ps);
                System.out.println(name +"," + psMd5);
                //把数据写到数据文件
                PrintStream out = new PrintStream(new FileOutputStream("user.txt",true));
                out.println(name +"#" + psMd5);
                out.close();
                //返回响应页面到客户端
                File file = new File("webapps" + "/myweb/regok.html");
                String name1 = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                httpResponse.setCotentType(HttpContext.getMimeType(name1));
                httpResponse.setCotentLength((int) file.length());
                httpResponse.setEntity(file);
                httpResponse.flush();
            }else {
                //定义响应文件对象
                File file = new File("webapps" + httpRequest.getUrl());
                //判断文件是否存在
                if (file.exists()) {

                    httpResponse.setEntity(file);
                    String name = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                    httpResponse.setCotentType(HttpContext.getMimeType(name));
                    httpResponse.setCotentLength((int) file.length());
                    httpResponse.flush();
                }
                outputStream.close();
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



