package mulThread;

/**
 * @Author: Eve
 * @Date: 2018/11/11 11:35
 * @Version 1.0
 */
//class myThread extends Thread{
//    @Override
//    public void run() {
//        for(int i = 0;i < 3;i++){
//            System.out.println(this.getName() + "线程" + i);
//        }
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
//
//    }
//}

class myThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 3;i++){
                System.out.println(Thread.currentThread().getName() + "线程" + i);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println("main线程开始。。。");
        myThread mt = new myThread();
        Thread thread = new Thread(mt,"a");
        Thread thread2 = new Thread(mt,"b");
        Thread thread3 = new Thread(mt,"c");

        thread.start();
        thread2.start();
        thread3.start();

        System.out.println("main线程结束。。。");
    }
}
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