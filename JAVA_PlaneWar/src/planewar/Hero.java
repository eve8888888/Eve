package planewar;

/**
 * @Author: Eve
 * @Date: 2018/11/12 14:03
 * @Version 1.0
 */
public class Hero extends FlyingObject {
    private Integer life;//生命值
    private Integer doubleFire;//火力设置
    public Hero(){
        super(400 / 2 - 97 / 2, 450,97,124);
        life = 3;
        doubleFire = 1;
    }
    public void move(int x,int y){

    }
    @Override
    void step() {

    }

}
