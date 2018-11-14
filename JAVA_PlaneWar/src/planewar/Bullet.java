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
    Bullet(int x, int y){
        super(x,y,55,91);
        step = 10;
    }
    @Override
    void step() {
        y -= step;
    }
    void step2() {
        y -= step;
        x -= 2;
    }
    void step3() {
        y -= step;
        x += 2;
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

    @Override
    public boolean outOfBounds() {
        return this.y < 0;
    }

}
