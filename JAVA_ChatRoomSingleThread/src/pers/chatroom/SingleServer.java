package pers.chatroom;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Eve
 * @Date: 2019/1/10 18:23
 * @Version 1.0
 */
public class SingleServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("等待客户端连接...");
        Socket socket = serverSocket.accept();

        PrintStream printStream =
                new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("This is Server");

        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        scanner.close();
        printStream.close();
        socket.close();
        serverSocket.close();
    }
}
