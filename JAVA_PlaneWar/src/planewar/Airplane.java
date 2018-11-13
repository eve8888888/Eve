package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:00
 * @Version 1.0
 */
public class Airplane extends FlyingObject {
    private Integer step;
    //加载图片
    private static BufferedImage[] images = new BufferedImage[5];
    static {
        for(int i = 0;i<images.length;i++) {
            try {
                images[i] =
                        ImageIO.read(Airplane.class.getResource("airplane"+ i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Airplane(){
        super(49,36);
        step = 2;
    }
    @Override
    public void step(){
        y += step;
    }

    /**
     * 如果当前状态为活着，加载数组的第一张图片
     * 如果当前的状态为死了，加载剩下的4张图片
     * @return image
     */
    int dadeIndex = 1;
    @Override
    public BufferedImage getImage(){
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
}
