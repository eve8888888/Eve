import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Eve
 * @Date: 2018/11/23 20:50
 * @Version 1.0
 */

public class WebServer {
    ServerSocket serverSocket = null;
    WebServer(){
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            System.out.println("等待客户端链接。。。");
            Socket socket = serverSocket.accept();

            InputStream in = socket.getInputStream();
            //in.read(new byte[2048]);
//            StringBuilder stringBuilder = new StringBuilder();
//            //获取http协议的报头信息
//            int d;
//            char c1 = 0;
//            char c2 = 0;
//            while ((d = in.read()) != -1) {
//                //System.out.print((char)d);
//                c2 = (char) d;
////                if ((int) c1 == 13 && (int) c2 == 10) {
////                    break;
////                }
//                stringBuilder.append(c2);
//                c1 = c2;
//                System.out.println(stringBuilder.toString());
//            }

            OutputStream os = socket.getOutputStream();

            os.write("HTTP/1.1 200 OK\r\n".getBytes());
            os.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
            os.write("Content-Length:38\r\n".getBytes());
            os.write("Server:gybs\r\n".getBytes());
            os.write(("Date:"+new Date()+"\r\n").getBytes());
            os.write("\r\n".getBytes());
           os.write("<h1>hello!</h1>".getBytes());
            os.write("<h3>HTTP服务器ddddd!</h3>".getBytes("utf-8"));
            //File file = new File("myweb/index.html");
            //FileInputStream fin = new FileInputStream(file);
            //byte[] buff = new byte[1024 * 4];
            //把文件中数据读到数组中
            //int len = fin.read(buff);
            //把数组中数据写到客户端
            //os.write(buff,0,len);
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}