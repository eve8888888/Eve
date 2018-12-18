package pers;

import java.io.*;
import java.util.concurrent.*;

/**
 * @Author: Eve
 * @Date: 2018/12/2 8:57
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) throws Exception {
//        BlockingQueue<Runnable> basket = new LinkedBlockingQueue<>(5);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                3,5,
//                0, TimeUnit.SECONDS,
//                basket);
//        for (int i = 0; i < 5; i++) {
//            threadPoolExecutor.execute(()->{
//                for (int j = 0 ;j<5;j++) {
//                    System.out.println(Thread.currentThread().getName() + "*********" + j);
//                }
//            });
//        }
//        threadPoolExecutor.shutdown();

        File file =
                new File("C:\\Users\\Eve\\Pictures\\wallpaper\\0e75fd864f329f4eb07c6a5df30a60ce.jpg");
        File file1 = new File("C:\\Users\\Eve\\Desktop\\a.jpg");
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(file1);
        //byte[] data = new byte[2048];
        long size = file.length();
        int t = 0;
        if(file.exists()&&file.isFile()){
            while (( t = in.read()) != -1){
                out.write(t);
            }
        }

        in.close();
        out.close();
    }
}
