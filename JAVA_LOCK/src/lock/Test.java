package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Eve
 * @Date: 2018/11/12 21:26
 * @Version 1.0
 */

//class myThread implements Runnable{
//    private int t = 100;
//    @Override
//    public void run() {
//        for (int i = 0; i<t;i++){
//            sale();
//        }
//    }
//    public synchronized void sale(){
//        if(t > 0){
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "剩余" + t-- + "张票");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        myThread mt = new myThread();
//        new Thread(mt,"窗口A").start();
//        new Thread(mt,"窗口B").start();
//        new Thread(mt,"窗口C").start();
//        Lock lock = new ReentrantLock();
//    }
//}
class myThread {

    public synchronized void fun1(){
        System.out.println(Thread.currentThread().getName() + "方法1开始...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "方法1结束...");
    }
    public synchronized void fun2(){
        System.out.println(Thread.currentThread().getName() + "方法2");
    }
}

class Test{
    public static void main(String[] args) {
        myThread myThread = new myThread();
        //myThread myThread2 = new myThread();
        new Thread(myThread::fun1,"线程A").start();
        new Thread(myThread::fun2,"线程B").start();
    }
}