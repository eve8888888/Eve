package mulThread;

/**
 * @Author: Eve
 * @Date: 2018/11/11 11:35
 * @Version 1.0
 */


//
//class myThread implements Runnable{
//    int t = 10;
//    @Override
//    public void run() {
//        for (int i = 0;i<10;i++){
//            sale();
//        }
//    }
//    public synchronized void sale(){
//        if(t > 0){
//            System.out.println(Thread.currentThread().getName() + "剩余" + t--);
//        }
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"黄牛A");
//        Thread thread2 = new Thread(mt,"黄牛B");
//        Thread thread3 = new Thread(mt,"黄牛C");
//        thread.start();
//        thread2.start();
//        thread3.start();
//
//    }
//}

//class myThread extends Thread{
//    @Override
//    public void run() {
//        System.out.println();
//    }
//}

/**
 * 同步代码块
 */
//class myThread implements Runnable{
//    int t = 100;
//    @Override
//    public void run() {
//        for (int i = 0;i<100;i++){
//            synchronized (this) {
//                if(t>0) {
//                    try {
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "剩余" + t-- + "票");
//                }
//            }
//        }
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"黄牛A");
//        Thread thread2 = new Thread(mt,"黄牛B");
//        Thread thread3 = new Thread(mt,"黄牛C");
//        thread.start();
//        thread2.start();
//        thread3.start();
//
//    }
//}

//public class Test {
//    public static void main(String[] args) {
//        myThread myThread1 = new myThread();
//        myThread myThread2 = new myThread();
//        myThread myThread3 = new myThread();
//
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//    }
//}

class myThread implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        for (i = 0;i<10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

public class Test{
    public static void main(String[] args) {
        myThread mt = new myThread();
        Thread thread = new Thread(mt,"A");
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("main线程开始。。。");
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"a");
//        thread.start();
//        Thread.sleep(1000);
//        mt.flag = true;
//        System.out.println("main线程结束。。。");
//    }
//}
//
//class myThread implements Callable<String> {
//    private int t = 10;
//    @Override
//    public String call() {
//        for(int i = 0;i <10 ;i++){
//            System.out.println("还剩下"+ t-- +"票");
//        }
//        return "票卖完了";
//    }
//}
//public class Test {
//    public static void main(String[] args) throws Exception{
//
//        Callable<String> callable = new myThread();
//        FutureTask<String> futureTask = new FutureTask<>(callable);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        System.out.println(futureTask.get());
//    }
//}


//class myThread implements Callable<String> {
//    private int t = 10;
//    @Override
//    public String call() {
//        for(int i = 0;i <10 ;i++){
//            System.out.println("还剩下"+ t-- +"票");
//        }
//        return "票卖完了";
//    }
//}
//public class Test {
//    public static void main(String[] args) throws Exception{
//
//        Callable<String> callable = new myThread();
//        FutureTask<String> futureTask = new FutureTask<>(callable);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        System.out.println(futureTask.get());
//    }
//}