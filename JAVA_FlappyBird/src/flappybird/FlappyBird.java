package flappybird;

import javax.swing.*;

/**
 * @Author: Eve
 * @Date: 2018/11/15 10:41
 * @Version 1.0
 */
public class FlappyBird {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        GamePanel gamePanel = new GamePanel();
        f.add(gamePanel);
        f.setTitle("飞扬小鸟");
        //设置窗口大小
        f.setSize(432, 644);
        //设置关闭按钮关闭程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口不可以拖动（锁定窗口）
        f.setResizable(false);
        gamePanel.action();
        //设置窗口可见
        f.setVisible(true);
    }
}
