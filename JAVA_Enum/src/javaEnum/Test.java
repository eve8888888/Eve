package javaEnum;

/**
 * @Author: Eve
 * @Date: 2018/11/9 16:25
 * @Version 1.0
 */
interface IColor{
    String getColor();
}
enum Color implements IColor{
    RED("红色"),BLUE("蓝色"),GREEN("绿色");
    private String title;
    private Color(String titie){
        this.title = titie;
    }
    @Override
    public String toString() {
        return this.title;
    }
    @Override
    public String getColor() {
        return title;
    }
}
public class Test {
    public static void main(String[] args) {
        IColor iColor = Color.BLUE;
        System.out.println(Color.RED);
        System.out.println(iColor.getColor());
    }
}

