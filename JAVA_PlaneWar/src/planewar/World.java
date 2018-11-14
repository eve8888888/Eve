package planewar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*
  @Author: Eve
 * @Date: 2018/11/12 16:30
 * @Version 1.0
 */

/**
 * 窗口类
 */


public class World extends JPanel {
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;
    private int state = START;

    //加载图片
    private static BufferedImage startImage;
    private static BufferedImage pauseImage;
    private static BufferedImage gameOverImage;
    static {
        try {
            startImage = ImageIO.read(Sky.class.getResource("start.png"));
            pauseImage = ImageIO.read(Sky.class.getResource("pause.png"));
            gameOverImage = ImageIO.read(Sky.class.getResource("gameover.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //天空
    private Sky sky = new Sky();
    //英雄机
    private Hero hero = new Hero();
    //敌人的数组
    private FlyingObject[] object = {};
    private Bullet[] bullets = {};
    private Bullet[] bullets2 = {};
    private Bullet[] bullets3 = {};
    int score = 0;
    //回收越界对象（敌人、子弹）
    private void outOfBoundsAction(){
        //装活着的敌人的对象的数组
        FlyingObject[] fo = new FlyingObject[object.length];
        int index = 0;
        for (FlyingObject f : object) {
            if (!f.outOfBounds() && !f.isRemove()) {
                fo[index] = f;
                index++;
            }
        }
        //数组拷贝
        object = Arrays.copyOf(fo,index);

        //装子弹对象
        if(!hero.getDoubleFire()) {
            Bullet[] bu = new Bullet[bullets.length];
            int index2 = 0;
            for (Bullet f : bullets) {
                if (!f.outOfBounds() && !f.isRemove()) {
                    bu[index2] = f;
                    index2++;
                }
            }
            bullets = Arrays.copyOf(bu,index2);
        }else {
            Bullet[] bu = new Bullet[bullets2.length];
            int index2 = 0;
            for (Bullet f : bullets2) {
                if (!f.outOfBounds() && !f.isRemove()) {
                    bu[index2] = f;
                    index2++;
                }
            }
            bullets2 = Arrays.copyOf(bu,index2);

            Bullet[] bu2 = new Bullet[bullets3.length];
            int index3 = 0;
            for (Bullet f : bullets3) {
                if (!f.outOfBounds() && !f.isRemove()) {
                    bu2[index3] = f;
                    index3++;
                }
            }
            bullets3 = Arrays.copyOf(bu2,index3);
        }
    }
    //英雄机和敌人碰撞
    public void heroHitAction(){
        for (int i = 0;i < object.length;i++){
            if(object[i].isLife() && object[i].hit(hero)){
                if(object[i] instanceof Enemy){
                    object[i].goDead();
                    hero.subLife();
                }else {
                    hero.clearDoubleFire();
                }
            }
        }
    }
    //子弹碰撞
    public void bulletHitAction(){
        //1.遍历子弹集合，拿到一个子弹对象
        //2.子弹对象要和所有的敌人进行碰撞的匹配
        //3.如果发生碰撞，敌人去死，Enemy得分、Award得命或者火力值
        if(!hero.getDoubleFire()) {
            for (int i = 0; i < bullets.length; i++) {
                for (int j = 0; j < object.length; j++) {
                    if (bullets[i].isLife() && object[j].isLife() && object[j].hit(bullets[i])) {
                        object[j].goDead();
                        bullets[i].goDead();
                        if (object[j] instanceof Enemy) {
                            score += ((Enemy) object[j]).getScore();
                        }
                        if (object[j] instanceof Award) {
                            switch (((Award) object[j]).getType()) {
                                case Award.DOUBLEFIRE:
                                    hero.addDoubleFire();
                                    break;
                                case Award.LIFE:
                                    hero.addLife();
                            }
                        }
                    }
                }
            }
        }else {
            for (int i = 0; i < bullets2.length; i++) {
                for (int j = 0; j < object.length; j++) {
                    if (bullets2[i].isLife() && object[j].isLife() && object[j].hit(bullets2[i])) {
                        object[j].goDead();
                        bullets2[i].goDead();

                        if (object[j] instanceof Enemy) {
                            score += ((Enemy) object[j]).getScore();
                        }
                        if (object[j] instanceof Award) {
                            switch (((Award) object[j]).getType()) {
                                case Award.LIFE:
                                    hero.addLife();
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < bullets3.length; i++) {
                for (int j = 0; j < object.length; j++) {
                    if (bullets3[i].isLife() && object[j].isLife() && object[j].hit(bullets3[i])) {
                        object[j].goDead();
                        bullets3[i].goDead();

                        if (object[j] instanceof Enemy) {
                            score += ((Enemy) object[j]).getScore();
                        }
                        if (object[j] instanceof Award) {
                            switch (((Award) object[j]).getType()) {
                                case Award.LIFE:
                                    hero.addLife();
                            }
                        }
                    }
                }
            }

        }
    }

    public void checkGameOverAction(){
        if(hero.getLife() <= 0){
            state = GAMEOVER;
        }
    }
    private void action(){

        //给JPanel添加事件监视器
        //定义鼠标的移动事件处理方法（匿名内部类完成）
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(state == RUNNING) {
                    //获取鼠标点坐标 传入move中
                    hero.move(e.getX(), e.getY());
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(state == PAUSE){
                    state = RUNNING;
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(state == RUNNING){
                    state = PAUSE;
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if(state == START){
                    state = RUNNING;
                }
                if(state == GAMEOVER){
                    //state == START
                    //初始化操作
                    object = new FlyingObject[0];
                    bullets = new Bullet[0];
                    score = 0;
                    hero = new Hero();
                    state = START;
                }
            }
        });
        //使用定时器
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(state == RUNNING) {
                    objectAction();
                    stepAction();
                    bulletAction();
                    //outOfBoundsAction();
                    bulletHitAction();
                    heroHitAction();
                    checkGameOverAction();
                }
                repaint();
            }
        },10,10);
    }

    //子弹入场
    private int index = 0;
    private void bulletAction(){
        index++;
        if(index % 20 == 0) {
            if(!hero.getDoubleFire()) {
                Bullet[] bu = hero.getBullet();
                bullets = Arrays.copyOf(bullets, bullets.length + bu.length);
                System.arraycopy(bu, 0, bullets, bullets.length - bu.length, bu.length);
                System.out.println("HHHHHHHH"+bullets.length);
            }else {
                Bullet[] bu2 = hero.getBullet();
                bullets2 = Arrays.copyOf(bullets2, bullets2.length + bu2.length);
                System.arraycopy(bu2, 0, bullets2, bullets2.length - bu2.length, bu2.length);
                Bullet[] bu3 = hero.getBullet();
                bullets3 = Arrays.copyOf(bullets3, bullets3.length + bu3.length);
                System.arraycopy(bu3, 0, bullets3, bullets3.length - bu3.length, bu3.length);
            }
        }
    }
    /**
     * 随机产生一个敌人对象
     */
    private FlyingObject nextOne(){
        int temp = new Random().nextInt(21);
        if(temp < 8){
            return new Airplane();
        }else if(temp < 18){
            return new BigAirplane();
        }else {
            return new Bee();
        }
    }
    private int index2 = 0;
    private void objectAction(){
        //小敌机初始化
        index2++;
        if(index2 % 10 == 0) {
            FlyingObject ob = nextOne();
            object = Arrays.copyOf(object, object.length + 1);
            object[object.length - 1] = ob;
        }
    }
    //让飞行物动起来
    private void stepAction(){
        //天空移动
        sky.step();
        //敌人对象动
        for (FlyingObject anObject : object) {
            anObject.step();
        }
        //子弹动

        if(!hero.getDoubleFire()){
            for (int i =0;i<bullets.length;i++){
                bullets[i].step();
            }
        }
        else {
            for (int i =0;i<bullets2.length;i++){
                bullets2[i].step2();
            }
            for (int i =0;i<bullets3.length;i++){
                bullets3[i].step3();
            }
        }
    }

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
        for (FlyingObject anObject : object) {
            anObject.paintObject(g);
        }
        //画子弹
        if(!hero.getDoubleFire()){
            for (Bullet bullet : bullets) {
                bullet.paintObject(g);
            }
        }else {
            for (Bullet bullet : bullets2) {
                bullet.paintObject(g);
            }
            for (Bullet bullet : bullets3) {
                bullet.paintObject(g);
            }
        }

        hero.paintObject(g);
        g.drawString("Scours:"+ score,10,20);
        g.drawString("Life:"+hero.getLife(),10,40);
        switch (state){
            case START:
                g.drawImage(startImage,0,0,null);
                break;
            case PAUSE:
                g.drawImage(pauseImage,0,0,null);
                break;
            case GAMEOVER:
                g.drawImage(gameOverImage,0,0,null);
                break;
        }
    }
}
