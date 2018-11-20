package lock;

/**
 * @Author: Eve
 * @Date: 2018/11/12 21:26
 * @Version 1.0
 */

class myThread implements Runnable{
    private int t = 100;
    @Override
    public void run() {
        while (t > 0) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "剩余" + --t + "张票");
        }
    }
}
public class Test {
    public static void main(String[] args) {
        myThread mt = new myThread();
        new Thread(mt,"窗口A").start();
        new Thread(mt,"窗口B").start();
        new Thread(mt,"窗口C").start();
    }
}
