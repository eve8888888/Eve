package planewar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:03
 * @Version 1.0
 */
public class Hero extends FlyingObject {
    private Integer life;//生命值
    private Integer doubleFire;//火力设置
    private static BufferedImage[] images = new BufferedImage[6];
    static {
        for(int i = 0;i<images.length;i++) {
            try {
                images[i] =
                        ImageIO.read(Hero.class.getResource("hero0"+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Hero(){
        super(480 / 2 - 60, 480,97,124);
        life = 3;
        doubleFire = 0;//等于0表示单倍火力，大于0表示双倍火力
    }
    public Bullet[] getBullet(){
        if(doubleFire == 0){
            Bullet[] b = new Bullet[1];
            int bx = this.width / 2 + this.x - 30;
            int by = this.y - 20;
            b[0] = new Bullet(bx,by);
            return b;
        }else {
            Bullet[] b = new Bullet[2];
            int bx = this.width / 4 + this.x - 10;
            int by = this.y - 20;
            b[0] = new Bullet(bx,by);
            int bx2 = this.x + this.width/4*3;
            b[1] = new Bullet(bx2,by);
            return b;

        }
    }
    public void move(int x,int y){

    }
    @Override
    void step() {

    }

    int dadeIndex = 2;
    int lifeIndex = 0;
    @Override
    public BufferedImage getImage(){
        if(this.isLife()) {
            return images[lifeIndex++ % 2];
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
