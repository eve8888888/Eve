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
    protected Integer x;
    protected Integer y;
    protected Integer width;
    protected Integer height;
    public FlyingObject(Integer width, Integer height) {
        Random random = new Random();
        this.width = width;
        this.height = height;
        this.x = random.nextInt(400 - width -1);
        //this.y = -height;
        this.y = 0;
    }

    public FlyingObject(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    abstract void step();


    //获取图片对象
    public BufferedImage getImage(String s){
        BufferedImage image = null;
        try {
            //读取一个图片资源
            image = ImageIO.read(Sky.class.getResource(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void paintObject(Graphics g,String str){
        g.drawImage(getImage(str),x,y,null);
    }
}
