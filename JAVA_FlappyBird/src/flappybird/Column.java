package flappybird;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: Eve
 * @Date: 2018/11/15 11:37
 * @Version 1.0
 */
public class Column extends FlyingObject {
    int x1;
    int y1;
    int step = 1;
    private static BufferedImage colIma;
    static {
        try {
            colIma = ImageIO.read(Column.class.getResource("column.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Column() {
        super(200, -351, 78, 1200);
        x1 = 200 + 432;
    }

    @Override
    public BufferedImage getImage() {
        return colIma;
    }
    @Override
    public void paintObject(Graphics g){
        g.drawImage(getImage(),x,y,null);
    }
    public void step(){
        x -= step;
        x1 -= step;
        if(x <= -78) {
            x = 432;
            y = new Random().nextInt(268) - 480;
        }
        if(x1 <= -78) {
            x1 = 432;
            y1 = new Random().nextInt(268) - 480;
        }
    }
}
