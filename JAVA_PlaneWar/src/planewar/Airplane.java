package planewar;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:00
 * @Version 1.0
 */
public class Airplane extends FlyingObject {
    private Integer step;

    public Airplane(){
        super(49,36);
        step = 2;
    }
    @Override
    public void step(){
        y += step;
    }

}
