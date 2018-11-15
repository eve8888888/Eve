package flappybird;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Author: Eve
 * @Date: 2018/11/15 10:53
 * @Version 1.0
 */
public abstract class FlyingObject {
    protected Integer x;
    protected Integer y;
    protected Integer width;
    protected Integer height;
    FlyingObject(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    abstract public BufferedImage getImage();

    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
    }
}
