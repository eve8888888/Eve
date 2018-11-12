package planewar;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:01
 * @Version 1.0
 */
public class Bee extends FlyingObject {
    private Integer xstep;
    private Integer ystep;
    private Integer awardType;//0为命；1为分

    public Bee(){
        super(60,50);
        awardType = new Random().nextInt(2);
        xstep = 1;
        ystep = 2;
    }
    @Override
    public void step(){

    }

}
