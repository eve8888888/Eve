package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:01
 * @Version 1.0
 */
public class Bee extends FlyingObject implements Award{
    private Integer awardType;
    private Integer xstep;
    private Integer ystep;
    //加载图片
    private static BufferedImage[] images = new BufferedImage[5];
    static {
        for(int i = 0;i<images.length;i++) {
            try {
                images[i] =
                        ImageIO.read(Bee.class.getResource("bee"+ i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    Bee(){
        super(60,50);
        //0为火力值；1为命
        awardType = new Random().nextInt(2);
        xstep = 3;
        ystep = 2;
    }
    @Override
    public void step(){
        x += xstep;
        y += ystep;
        if(x > 480 - this.width){
            xstep *= -1;
        }
        if(x < 0){
            xstep *= -1;
        }
    }
    private int dadeIndex = 1;
    @Override
    public BufferedImage getImage() {
        if(this.isLife()) {
            return images[0];
        }else if(this.isDead()){
            BufferedImage image = images[dadeIndex++];
            if(dadeIndex == images.length){
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
    public int getType() {
        return awardType;
    }
}
