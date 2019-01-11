package pers.chatroom;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Eve
 * @Date: 2019/1/10 18:43
 * @Version 1.0
 */
class ReadFromServer implements Runnable{
    private Socket client;
    public ReadFromServer(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            if(client.isClosed()){
                System.out.println("client is closed");
                scanner.close();
                break;
            }
            if(scanner.hasNext()){
                String msgFromServer = scanner.nextLine();
                System.out.println("服务器发送来的消息:"+msgFromServer);
            }
        }
    }
}
class SendToServer implements Runnable{
    private Socket client;

    public SendToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream printStream = new PrintStream(client.getOutputStream(),true,"UTF-8");
            Scanner in = new Scanner(System.in);
            in.useDelimiter("\n");
            while (true){
                String str = "";
                if(in.hasNext()) {
                    str = in.nextLine();
                    //向服务器发送信息
                    printStream.println(str);
                    if (str.endsWith("byebye")) {
                        System.out.println("客户端退出聊天室");
                        printStream.close();
                        in.close();
                        client.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class MultiThreadClient {
    public static void main(String[] args) throws Exception{
        //
        Socket client = new Socket("127.0.0.1",6666);
        Thread readThread = new Thread(new ReadFromServer(client));
        readThread.start();
        Thread sendThread = new Thread(new SendToServer(client));
        sendThread.start();
    }
}
