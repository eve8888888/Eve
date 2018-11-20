package Practice;

/**
 * @Author: Eve
 * @Date: 2018/11/18 12:35
 * @Version 1.0
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.写两个线程，一个线程打印 1~52，另一个线程打印A~Z，
 * 打印顺序是12A34B...5152Z；
 *
 */
class Print{
    //信号量
    private boolean flag = false;
    int count = 1;
    //打印数字
    public synchronized void printNum(){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count * 2 - 1);
        System.out.println(count * 2);
        flag = true;
        notify();
    }
    //打印字母
    public synchronized void printChar(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println((char)('A' + count - 1));
        flag = false;
        count++;
        notify();
    }
}

class Test{
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(()->{
            for(int i = 0; i < 26;i++){
                print.printNum();
            }
        }).start();
        new Thread(()->{
            for(int i = 0; i < 26;i++){
                print.printChar();
            }
        }).start();

        Lock lock = new ReentrantLock();
        try{
            lock.lock();
            //同步块
        }finally {
            lock.unlock();
        }
    }
}

