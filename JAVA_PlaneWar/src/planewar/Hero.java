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
    private Integer life;
    private boolean doubleFire;//火力设置
    private static BufferedImage[] images = new BufferedImage[6];
    static {
        for(int i = 0;i<images.length;i++) {
            try {
                images[i] =
                        ImageIO.read(Hero.class.getResource("hero"+ i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    Hero(){
        super(480 / 2 - 60, 480,97,124);
        //生命值
        life = 3;
        doubleFire = false;//等于0表示单倍火力，大于0表示双倍火力
    }
    Bullet[] getBullet() {
            Bullet[] b = new Bullet[1];
            int bx = this.width / 2 + this.x - 30;
            int by = this.y - 20;
            b[0] = new Bullet(bx, by);
            return b;
    }
    //xy表示鼠标坐标
    void move(int x, int y){
        this.x = x - this.width / 2;
        this.y = y - this.height / 2;
    }
    @Override
    void step() {

    }
    private int deadIndex = 2;
    private int lifeIndex = 0;
    @Override
    public BufferedImage getImage(){
        if(this.isLife()) {
            return images[lifeIndex++ % 2];
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
        return false;
    }
    //加命
    public void addLife(){
        life++;
    }
    //获取声明值
    public int getLife(){
        return life;
    }
    //加火力
    public void addDoubleFire(){
        doubleFire = true;
    }
    public boolean getDoubleFire(){
        return doubleFire;
    }
    public void subLife(){
        life--;
    }
    public void clearDoubleFire(){
        doubleFire = false;
    }
}
