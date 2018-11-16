package flappybird;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Author: Eve
 * @Date: 2018/11/15 10:53
 * @Version 1.0
 */
public abstract class FlyingObject {
    Integer x;
    Integer y;

    FlyingObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    abstract public BufferedImage getImage();

    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
    }
}
