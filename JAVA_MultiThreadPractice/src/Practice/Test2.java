package Practice;

/**
 * @Author: Eve
 * @Date: 2018/11/20 18:21
 * @Version 1.0
 */

/**
 *  2.编写一个程序，启动三个线程，三个线程的名称分别是 A，B，C；
 *  每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC...
 */

class Print2{
    private int flag = 1;
    private int count = 0;
    public synchronized void printA(){
        while (flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 2;
        count ++;
        notifyAll();
    }
    public synchronized void printB(){
        while (flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 3;
        //count ++;
        notifyAll();
    }
    public synchronized void printC(){
        while (flag != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 1;
        //count ++;
        notifyAll();
    }
}
class myThread implements Runnable{
    Print2 print2;
    public myThread(Print2 print2) {
        this.print2 = print2;
    }
    @Override
    public void run() {
        for(int i = 0; i < 5;i++){
            if(Thread.currentThread().getName().equals("A")){
                print2.printA();
            }else if(Thread.currentThread().getName().equals("B")){
                print2.printB();
            }else {
                print2.printC();
            }
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        Print2 print2 = new Print2();
        myThread mt = new myThread(print2);
        new Thread(mt,"A").start();
        new Thread(mt,"B").start();
        new Thread(mt,"C").start();
    }
}
