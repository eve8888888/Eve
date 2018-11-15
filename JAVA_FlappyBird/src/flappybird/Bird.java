package flappybird;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/15 11:06
 * @Version 1.0
 */
public class Bird extends FlyingObject {
    double d;
    double g=4.9;
    double t=0.25;
    double v=40;
    private static BufferedImage[] images = new BufferedImage[8];
    static {
        for(int i = 0;i<images.length;i++) {
            try {
                images[i] =
                        ImageIO.read(Bird.class.getResource(i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    Bird() {
        super(50, 298, 56, 48);
    }
    int imageIndex = 0;
    @Override
    public BufferedImage getImage() {
        return images[imageIndex++ / 9 % 8 ];
    }
    @Override
    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
    }
    public void birdMove(){
        double v0 = v;
        d = v0*t - 0.5*g*t*t;
        v = v0 - g*t;
        y -= (int)d;
        //当小鸟到达上线时，设置速度值为10；
        if(y >= 450) {
            v = 10;
        }
        if(y <= 0){
            y = 0;
        }
    }
    public void step(){
        v = 20;
    }

}
