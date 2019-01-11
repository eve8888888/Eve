package pers.chatroom;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Eve
 * @Date: 2019/1/10 18:57
 * @Version 1.0
 */
public class MultiThreadServer {
    private static Map<String, Socket> clientLists =
            new ConcurrentHashMap<>();
    private static class ExecuteClientRequest implements Runnable{
        private Socket client;

        public ExecuteClientRequest(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try {
                //读取用户发来的信息
                Scanner in = new Scanner(client.getInputStream());
                String str = "";
                while (true){
                    if(in.hasNext()){
                        str = in.nextLine();
                    }
                    //windows下消除用户输入自带的\r
                    //将\r替换为空字符串
                    Pattern pattern = Pattern.compile("\r");
                    Matcher matcher = pattern.matcher(str);
                    str = matcher.replaceAll("");
                    //注册
                    if(str.startsWith("userName")){
                        String userName = str.split(":")[1];
                        userRegister(userName,client);
                    }
                    //群聊信息
                    if(str.startsWith("G")){
                        groupChat(str.split(":")[1]);
                    }
                    //私聊
                    if(str.startsWith("P")){
                        String userName = str.split(":")[1].split("-")[0];
                        String msg = str.split(":")[1].split("-")[1];
                        privateChat(userName,msg);
                    }
                    //退出
                    if(str.contains("byebye")){
                        String userName = str.split(":")[0];
                        userOffLine(userName);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void userRegister(String userName,Socket socket){
            clientLists.put(userName,socket);
            System.out.println("用户" + userName + "上线了");
            System.out.println("当前聊天室人数为:"+clientLists.size());
            try {
                PrintStream out = new PrintStream(client.getOutputStream());
                out.println("注册成功");
                groupChat("用户" + userName + "已上线");
                out.println("当前聊天室人数为:"+clientLists.size());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        private void groupChat(String groupMsg){
            Set<Map.Entry<String,Socket>> clientEntry =
                    clientLists.entrySet();
            Iterator<Map.Entry<String, Socket>> iterator = clientEntry.iterator();
            while (iterator.hasNext()){
                Socket socket = iterator.next().getValue();
                try {
                    PrintStream printStream = new PrintStream(socket.getOutputStream());
                    printStream.println("群发消息:" + groupMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private void privateChat(String userName,String privateMsg){
            Socket socket = clientLists.get(userName);
            try {
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println(privateMsg + "From" + Thread.currentThread().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 用户退出流程
        private void userOffLine(String userName) {
            clientLists.remove(userName);
            System.out.println(userName+"已下线!");
            System.out.println("当前聊天室共"+clientLists.size()+"人");
            groupChat(userName+"已下线!");
        }
    }
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6666);
        //使用线程池处理多个客户端连接
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        System.out.println("等待客户端连接...");
        for (int i = 0; i < 20; i++) {
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接,端口号为:"+client.getPort());
            executorService.submit(new ExecuteClientRequest(client));
        }
        executorService.shutdown();
        serverSocket.close();
    }
}
