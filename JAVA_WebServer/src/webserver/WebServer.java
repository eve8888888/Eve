package webserver;

import cn.http.HttpRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
            HttpRequest httpRequest = new HttpRequest(socket.getInputStream());
            OutputStream outputStream = socket.getOutputStream();
            System.out.println(httpRequest.getMethod());
            System.out.println(httpRequest.getUrl());
            System.out.println(httpRequest.getProtocol());
            //定义响应文件对象
            File file = new File("webapps" +httpRequest.getUrl());
            //判断文件是否存在
            if(file.exists()){
                outputStream.write("HTTP/1.1 200 OK".getBytes("ISO8859-1"));
                outputStream.write(13);
                outputStream.write(10);
                outputStream.write("Content-Type:text/html".getBytes("ISO8859-1"));
                outputStream.write(13);
                outputStream.write(10);
                outputStream.write(("Content-Length:"+file.length()).getBytes("ISO8859-1"));
                outputStream.write(13);
                outputStream.write(10);
                outputStream.write(13);
                outputStream.write(10);
                //先读后写
                //获取输入流对象
                FileInputStream fin = new FileInputStream(file);
                byte[] buff = new byte[1024 * 4];
                //把文件中数据读到数组中
                int len = fin.read(buff);
                //把数组中数据写到客户端
                outputStream.write(buff,0,len);
            }

            socket.getInputStream().close();
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



