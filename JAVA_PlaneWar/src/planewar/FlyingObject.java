package planewar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:00
 * @Version 1.0
 */

/**
 * 定义飞行物类，设置对象的初始坐标和大小
 * 2个构造方法供子类调用来完成初始化操作
 */
abstract class FlyingObject {
    //定义状态常量
    public static final int LIFE = 0; //表示活着
    public static final int DEAD = 1; //表示死了
    public static final int REMOVE = 2;//表示可回收
    protected int state = LIFE;
    protected Integer x;
    protected Integer y;
    protected Integer width;
    protected Integer height;
    public FlyingObject(Integer width, Integer height) {
        Random random = new Random();
        this.width = width;
        this.height = height;
        this.x = random.nextInt(480 - width -1);
        this.y = -height;
    }

    public FlyingObject(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    abstract void step();


    //获取图片对象
    abstract public BufferedImage getImage();

    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
    }

    //判断生死、删除的方法
    public boolean isLife(){
        return state == LIFE;
    }
    public boolean isDead(){
        return state == DEAD;
    }
    public boolean isRemove(){
        return state == REMOVE;
    }
}
