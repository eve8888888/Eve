package flappybird;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/15 11:25
 * @Version 1.0
 */
public class Ground extends FlyingObject {
    private int x1;
    private int y1;
    private static BufferedImage gIma;
    static {
        try {
            gIma = ImageIO.read(Ground.class.getResource("ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Ground() {
        super(0, 498);
        x1 = 432;
        y1 = 498;
    }
    void step(){
        int step = 2;
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
        return gIma;
    }
    @Override
    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
        g.drawImage(getImage(),x1,y1,null);
    }
}
