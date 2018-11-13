package planewar;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Eve
 * @Date: 2018/11/12 16:30
 * @Version 1.0
 */

/**
 * 窗口类
 */


public class World extends JPanel {
    //天空
    Sky sky = new Sky();
    //英雄机
    Hero hero = new Hero();
    //敌人的数组
    FlyingObject[] object = {};
    Bullet[] bullets = {};
    public void action(){
        this.objectAction();
        this.bulletAction();
        //使用定时器
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //objectAction();
                bulletAction();
                heroAction();
            }
        },10,10);

        new Thread(()->{
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //bulletAction();
                    objectAction();
                    stepAction();
                    repaint();
                }
            }).start();
    }

    //子弹入场
    int index = 0;
    public void bulletAction(){
        index++;
        if(index % 20 == 0) {
            Bullet[] bu = hero.getBullet();
            bullets = Arrays.copyOf(bullets, bullets.length + bu.length);
            System.arraycopy(bu, 0, bullets, bullets.length - bu.length, bu.length);
        }
    }
    public void heroAction(){
        PointerInfo pinfo = MouseInfo.getPointerInfo();
        Point p = pinfo.getLocation();
        int mx = (int)p.getX();
        int my = (int)p.getY();
        hero.move(mx - 800,my - 200);
    }
    /**
     * 随机产生一个敌人对象
     * @return
     */
    public FlyingObject nextOne(){
        int temp = new Random().nextInt(21);
        if(temp < 8){
            return new Airplane();
        }else if(temp < 18){
            return new BigAirplane();
        }else {
            return new Bee();
        }
    }
    int index2 = 0;
    public void objectAction(){
        //小敌机初始化
        index2++;
        if(index2 % 50 == 0) {
            FlyingObject ob = nextOne();
            object = Arrays.copyOf(object, object.length + 1);
            object[object.length - 1] = ob;
        }
    }
    //让飞行物动起来
    public void stepAction(){
        //天空移动
        sky.step();
        //敌人对象动
        for(int i = 0;i<object.length;i++){
            object[i].step();
        }
        //子弹动
        for (int i =0 ;i<bullets.length;i++){
            bullets[i].step();
        }
        //hero.step();
    }
    Airplane airplane = new Airplane();
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        //设置窗口标题
        frame.setTitle("PlaneWar");
        //设置窗口大小
        frame.setSize(480,850);
        //设置窗口位置居中
        frame.setLocationRelativeTo(null);
        //x按钮退出运行环境
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        world.action();
        //显示窗口
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        sky.paintObject(g);
        //画敌机对象
        for (int i = 0;i < object.length; i++){
            object[i].paintObject(g);
        }
        //画子弹
        for (int i = 0;i < bullets.length; i++){
            bullets[i].paintObject(g);
        }
        hero.paintObject(g);
    }
}
