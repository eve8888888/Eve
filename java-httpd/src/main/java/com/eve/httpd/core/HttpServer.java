package com.eve.httpd.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Eve
 * @Date: 2018/12/1 21:09
 * @Version 1.0
 */
public class HttpServer {

    public void start(){
        while (true){

            try {
                ServerSocket serverSocket = new ServerSocket(80);
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("running");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
