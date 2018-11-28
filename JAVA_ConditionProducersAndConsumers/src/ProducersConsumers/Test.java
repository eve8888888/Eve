package ProducersConsumers;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Eve
 * @Date: 2018/11/28 18:35
 * @Version 1.0
 */
class Goods{
    private int maxCount;
    private String name;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    //生产者等待队列
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();
    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 生产者方法
     * @param name
     */
    public void setGood(String name){
        lock.lock();
        try {
            while (count == maxCount){
                //当前商品已经达到最大值,生产者线程需要等待
                System.out.println(Thread.currentThread().getName() + "商品已经达到最大值");
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            //唤醒消费者线程
            consumerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void getGood(){
        lock.lock();
        try{
            while (count == 0){
                System.out.println(Thread.currentThread().getName() + "商品卖完,需要生产");
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "消费" + toString());
            //唤醒生产者线程
            producerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
class Producer implements Runnable{
    private Goods goods;
    private String name;
    Producer(Goods goods,String name){
        this.goods = goods;
        this.name = name;
    }
    @Override
    public void run() {
        while (true){
            goods.setGood(name);
        }
    }
}
class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
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
        Goods goods = new Goods(50);
        Producer producer = new Producer(goods,"汽车");
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new LinkedList<>();
        for (int i = 0; i<5;i++){
            list.add(new Thread(producer));
        }
        for (int i = 0;i<10;i++){
            list.add(new Thread(consumer));
        }
        for (Thread thread :
                list) {
            thread.start();
        }
    }
}
