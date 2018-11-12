package planewar;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:03
 * @Version 1.0
 */
public class Bullet extends FlyingObject {
    private Integer step;
    public Bullet(int x,int y){
        super(x,y,8,14);
        step = 3;
    }
    @Override
    void step() {
        y -= step;
    }

}
