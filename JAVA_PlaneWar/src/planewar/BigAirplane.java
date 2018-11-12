package planewar;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:02
 * @Version 1.0
 */
public class BigAirplane extends FlyingObject {
    private Integer step;
    public BigAirplane(){
        super(69,99);
        step = 50;
    }
    @Override
    public void step(){
            y += step;
        }
}
