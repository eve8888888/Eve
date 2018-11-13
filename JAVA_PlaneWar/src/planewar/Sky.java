package planewar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:03
 * @Version 1.0
 */
public class Sky extends FlyingObject {
    private Integer y1;
    private Integer step;
    //加载图片
    private static BufferedImage image;
    static {
        try {
            image = ImageIO.read(Sky.class.getResource("background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Sky(){
        super(0,0,480
                ,850);
        y1 = -850;
        step = 3;
    }
    /**
     * 天空向下移动
     */
    @Override
    public void step(){
        y += step;
        y1 += step;
        if(y >= this.height){
            y=-height;
        }
        if(y1 >= this.height){
            y1=-height;
        }
    }
    public BufferedImage getImage(){
        return image;
    }
    @Override
    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
        g.drawImage(getImage(),x,y1,null);
    }
}