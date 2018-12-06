package com.eve.httpd;

import com.eve.httpd.core.HttpServer;

/**
 * @Author: Eve
 * @Date: 2018/12/1 21:05
 * @Version 1.0
 */
public class Httpd {
    public static void main(String[] args) {
        System.out.println("Hello HTTP");
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }
}
