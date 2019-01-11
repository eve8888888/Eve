package pers.chatroom;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Eve
 * @Date: 2019/1/10 18:29
 * @Version 1.0
 */
public class SingleClient {


    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",6666);

        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        PrintStream printStream =
                new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("This is Client");


        printStream.close();
        scanner.close();
        socket.close();

    }
}
