package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:03
 * @Version 1.0
 */
public class Bullet extends FlyingObject {
    private Integer step;
    private static BufferedImage image;
    static {
        try {
            image = ImageIO.read(Sky.class.getResource("bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Bullet(int x,int y){
        super(x,y,55,91);
        step = 7;
    }
    @Override
    void step() {
        y -= step;
    }

    @Override
    public BufferedImage getImage() {
        if(this.isLife()) {
            return image;
        }else if(this.isDead()){
            state = REMOVE;
        }
        return null;
    }

}
