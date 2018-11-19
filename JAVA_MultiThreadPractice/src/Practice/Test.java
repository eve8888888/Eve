package Practice;

/**
 * @Author: Eve
 * @Date: 2018/11/18 12:35
 * @Version 1.0
 */

class Print{
    public synchronized void print(){

    }
}
class myThread implements Runnable{
    @Override
    public void run() {
        System.out.println();
    }
}

class Test{
    public static void main(String[] args) {
        myThread myThread = new myThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}

//class print{
//    int i = 1;
//    char c = 'a';
//    public synchronized void printNumber() {
//        notify();
//        System.out.println(i);
//        if(i % 2 == 0){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        i++;
//        notify();
//    }
//    public synchronized void printZimu() {
//        if (i <= 1) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }else {
//            System.out.println(c);
//            c ++;
//            try {
//                notify();
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//class myThread implements Runnable{
//    print print;
//    myThread(print print){
//        this.print = print;
//    }
//    @Override
//    public void run() {
//        while (print.i<=52) {
//            print.printNumber();
//        }
//    }
//}
//class myThread2 implements Runnable{
//    print print;
//    myThread2(print print){
//        this.print = print;
//    }
//    @Override
//    public void run() {
//        while (print.c<='z') {
//            print.printZimu();
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        print print = new print();
//        myThread myThread = new myThread(print);
//        myThread2 myThread2 = new myThread2(print);
//        new Thread(myThread2).start();
//        new Thread(myThread).start();
//
//
//    }
//}
