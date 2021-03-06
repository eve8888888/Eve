package producerAndconsume;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Eve
 * @Date: 2018/11/18 11:26
 * @Version 1.0
 */

class Goods{
    private String goodName;
    private int count = 0;
    public synchronized void setGood(String name){
        while (count > 0 ){
            try {
                System.out.println("还有商品。。。");
                this.count++;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodName = name;
        this.count++;
        System.out.println(Thread.currentThread().getName() + "生产 "+toString());
        notifyAll();
    }
    public synchronized void getGood(){
        while (count == 0){
            try {
                System.out.println("没有商品了，需要生产。。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName() + "消费 "+toString());
        notifyAll();
    }

    @Override
    public String toString() {
        return goodName + "count = " + count;
    }
}
class Producer implements Runnable{
    Goods goods;
    Producer(Goods goods){
        this.goods = goods;
    }
    @Override
    public void run() {
        while (true) {
            goods.setGood("面包");
        }
    }
}
class Consume implements Runnable{
    Goods goods;
    Consume(Goods goods){
        this.goods = goods;
    }
    @Override
    public void run() {
        while (true) {
            goods.getGood();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();
        for (int i = 0 ;i < 15;i++){
            Producer producer = new Producer(goods);
            Thread thread = new Thread(producer,"线程"+i);
            thread.start();
        }
        for (int i = 0 ;i < 5;i++) {
            Consume consume = new Consume(goods);
            Thread thread1 = new Thread(consume,"线程"+i);
            thread1.start();
        }
    }
}


//class Goods{
//    private String goodName;
//    private int count = 0;
//    public synchronized void setGood(String name){
//        if(this.count > 0){
//            System.out.println("还有");
//            try {
//                wait();
//                System.out.println("生产线程被唤醒");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.goodName = name;
//        this.count++;
//        System.out.println(Thread.currentThread().getName() + "生产" + toString());
//        notify();
//    }
//    public synchronized void getGood(){
//        if(this.count == 0){
//            System.out.println("需要生产");
//            try {
//                wait();
//                System.out.println("消费线程被唤醒");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.count--;
//        System.out.println(Thread.currentThread().getName() + "消费 "+toString());
//        notify();
//    }
//    @Override
//    public String toString() {
//        return goodName + "count = " + count;
//    }
//}
//class Producer implements Runnable{
//    Goods goods;
//    Producer(Goods goods){
//        this.goods = goods;
//    }
//    @Override
//    public void run() {
//        goods.setGood("面包");
//    }
//}
//class Consume implements Runnable{
//    Goods goods;
//    Consume(Goods goods){
//        this.goods = goods;
//    }
//    @Override
//    public void run() {
//        goods.getGood();
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Goods goods = new Goods();
//        Producer producer = new Producer(goods);
//        Thread thread = new Thread(producer,"线程");
//        Consume consume = new Consume(goods);
//        Thread thread1 = new Thread(consume,"线程");
//        thread1.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.start();
//    }
//}