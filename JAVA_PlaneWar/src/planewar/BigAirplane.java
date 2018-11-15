package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:02
 * @Version 1.0
 */
public class BigAirplane extends FlyingObject implements Enemy {
    private Integer step;
    //加载图片
    private static BufferedImage[] images = new BufferedImage[5];
    static {
        for(int i = 0;i<images.length;i++) {
            try {
                images[i] =
                        ImageIO.read(BigAirplane.class.getResource("bigplane"+ i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    BigAirplane(){
        super(69,99);
        step = 4;
    }
    @Override
    public void step(){
            y += step;
    }
    private int deadIndex = 1;
    @Override
    public BufferedImage getImage() {
        if(this.isLife()) {
            return images[0];
        }else if(this.isDead()){
            BufferedImage image = images[deadIndex++];
            if(deadIndex == images.length){
                state = REMOVE;
            }
            return image;
        }
        return null;
    }
    @Override
    public boolean outOfBounds() {
        return this.y > 850;
    }
    @Override
    public int getScore() {
        return 3;
    }
}
