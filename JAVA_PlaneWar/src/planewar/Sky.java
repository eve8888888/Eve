package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:03
 * @Version 1.0
 */
public class Sky extends FlyingObject {
    private Integer y1;
    private Integer step;

    public Sky(){
        super(0,0,400,700);
        y1 = -700;
        step = 1;
    }
    /**
     * 天空向下移动
     */
    @Override
    public void step(){
        y += step;
        y = 50;
    }
}