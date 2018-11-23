package mulThread;

/**
 * @Author: Eve
 * @Date: 2018/11/11 11:35
 * @Version 1.0
 */



//class myThread implements Runnable{
//    int t = 100;
//    @Override
//    public void run() {
//        for (int i = 0;i<100;i++){
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
//            System.out.println(Thread.currentThread().getName() + "ʣ��" + t-- + "��Ʊ");
//        }
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"����A");
//        Thread thread2 = new Thread(mt,"����B");
//        Thread thread3 = new Thread(mt,"����C");
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
 * ͬ�������
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
//                    System.out.println(Thread.currentThread().getName() + "ʣ��" + t-- + "Ʊ");
//                }
//            }
//        }
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"��ţA");
//        Thread thread2 = new Thread(mt,"��ţB");
//        Thread thread3 = new Thread(mt,"��ţC");
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

//class myThread implements Runnable{
//
//    @Override
//    public void run() {
//        int i = 0;
//        for (i = 0;i<10;i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("�������");
//                System.out.println(Thread.currentThread().isInterrupted());
//                return;
//            }
//            System.out.println(Thread.currentThread().getName()+"����ִ��" + i + Thread.currentThread().isInterrupted());
//        }
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"A");
//        thread.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("main�߳̿�ʼ������");
//        myThread mt = new myThread();
//        Thread thread = new Thread(mt,"a");
//        thread.start();
//        Thread.sleep(1000);
//        mt.flag = true;
//        System.out.println("main�߳̽���������");
//    }
//}
//
//class myThread implements Callable<String> {
//    private int t = 10;
//    @Override
//    public String call() {
//        for(int i = 0;i <10 ;i++){
//            System.out.println("��ʣ��"+ t-- +"Ʊ");
//        }
//        return "Ʊ������";
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
//            System.out.println("��ʣ��"+ t-- +"Ʊ");
//        }
//        return "Ʊ������";
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




//class MyThread implements Runnable {
//    private boolean flag = true;
//    @Override
//    public void run() {
//        int i = 1;
//        while (flag) {
//            try {
//                /**
//                 * ��������֮��,�̱߳�������interrupte()������
//                 * ����жϱ�־���ͻ��׳�һ���쳣
//                 * java.lang.InterruptedException
//                 */
//
//                System.out.println(Thread.currentThread().isInterrupted());
//                Thread.sleep(1000);
//                boolean bool = Thread.currentThread().isInterrupted();
//                if (bool) {
//                    System.out.println("�����������ִ�иò����������߳�״̬" + bool);
//                    break;
//                }
//                System.out.println("��"+i+"��ִ�У��߳�����Ϊ:"+Thread.currentThread().getName());
//                i++;
//            } catch (InterruptedException e) {
//                System.out.println("�˳���");
//                /**
//                 * �����˳�����״̬�����жϱ�־��ϵͳ���Զ������
//                 * ������������Ϊfalse�����Դ˴�boolΪfalse
//                 */
//                boolean bool = Thread.currentThread().isInterrupted();
//                System.out.println(bool);
//                    //�˳�run�������жϽ���
//                return;
//            }
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread1 = new Thread(myThread, "���߳�A");
//        thread1.start();
//        Thread.sleep(3000);
//        thread1.interrupt();
//        System.out.println("�������");
//    }
//}


//class Sync {
//    public synchronized void test() {
//            System.out.println("test������ʼ����ǰ�߳�Ϊ " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test������������ǰ�߳�Ϊ " + Thread.currentThread().getName());
//    }
//}
//class MyThread extends Thread {
//    Sync sync;
//    public MyThread(Sync sync){
//        this.sync = sync;
//    }
//    @Override
//    public void run() {
//        sync.test();
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Sync sync = new Sync() ;
//        for (int i = 0; i < 3 ; i++) {
//            Thread thread = new MyThread(sync) ;
//            thread.start();
//        }
//    }
//}


class Sync {
    public  synchronized void test() {
            System.out.println("test������ʼ����ǰ�߳�Ϊ " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test������������ǰ�߳�Ϊ " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        Sync sync = new Sync() ;
        sync.test();
    }
}
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 3 ; i++) {
            Thread thread = new MyThread() ;
            thread.start();
        }
    }
}

//public class Test{
//    public static void main(String[] args) {
//        fun();
//    }
//    public synchronized static void fun(){
//        System.out.println("hello world");
//    }
//}

