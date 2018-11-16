package flappybird;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/15 10:58
 * @Version 1.0
 */
public class Sky extends FlyingObject{
    private int x1 = 432;
    private static BufferedImage bgIma;
    static {
        try {
            bgIma = ImageIO.read(Sky.class.getResource("bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Sky(){
        super(0,0);
    }
    void step(){
        int step = 1;
        x -= step;
        x1 -= step;
        if(x <= -432) {
            x = 423;
        }
        if(x1 <= -432) {
            x1 = 423;
        }
    }
    @Override
    public BufferedImage getImage() {
        return bgIma;
    }
    @Override
    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
        int y1 = 0;
        g.drawImage(getImage(),x1, y1,null);
    }
}
