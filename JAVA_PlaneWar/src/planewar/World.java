package planewar;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Eve
 * @Date: 2018/11/12 16:30
 * @Version 1.0
 */

/**
 * 窗口类
 */
public class World extends JPanel {
    Sky sky = new Sky();
    Hero hero = new Hero();
    BigAirplane bigAirplane = new BigAirplane();
    Airplane airplane = new Airplane();
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        //设置窗口标题
        frame.setTitle("PlaneWar");
        //设置窗口大小
        frame.setSize(400,700);
        //设置窗口位置居中
        frame.setLocationRelativeTo(null);
        //显示窗口
        frame.setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        //sky.paintObject(g,"background.png");
        myThread mt = new myThread();
        mt.setG(g);
        Thread thread = new Thread(mt);
        thread.start();
        //bigAirplane.paintObject(g, "bigplane0.png");

        hero.paintObject(g,"hero0.png");

    }
}
class myThread extends JPanel implements Runnable{
    BigAirplane bigAirplane = new BigAirplane();
    Graphics g = null;

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bigAirplane.step();
            bigAirplane.paintObject(g,"bigplane0.png");
        }
    }
}