package cn.webserver;

import cn.http.HttpRequest;
import cn.http.HttpResponse;
import cn.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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

    class Handler implements Runnable {
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

                if(ServletContext.map.containsKey(httpRequest.getRequestLine())){
                    try {
                        //得到字符串类型的类名
                        String className = ServletContext.map.get(httpRequest.getRequestLine());
                        //返回class类型的对象，Class完成反射功能的类
                        Class clazz = Class.forName(className);
                        //创建对象
                        HttpServlet servlet = (HttpServlet)clazz.newInstance();
                        servlet.service(httpRequest, httpResponse);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    //定义响应文件对象
                    File file = new File("webapps" + httpRequest.getUrl());
                    //判断文件是否存在
                    if (file.exists()) {
                        httpResponse.sendRedirect(httpRequest.getUrl());
                    }
                    outputStream.close();
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




