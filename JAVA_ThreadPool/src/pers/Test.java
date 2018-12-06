package pers;

import java.util.concurrent.*;

/**
 * @Author: Eve
 * @Date: 2018/12/2 8:57
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        BlockingQueue<Runnable> basket = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,5,
                0, TimeUnit.SECONDS,
                basket);
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(()->{
                for (int j = 0 ;j<5;j++) {
                    System.out.println(Thread.currentThread().getName() + "*********" + j);
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}
