package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:02
 * @Version 1.0
 */
public class BigAirplane extends FlyingObject {
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
    public BigAirplane(){
        super(69,99);
        step = 3;
    }
    @Override
    public void step(){
            y += step;
        }
    int dadeIndex = 1;
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

}
