package Cylinder;

interface A{
    double PI = 3.14;
    double area();
}
interface B{
    void setColor(String c);
}
interface C extends A,B{
    void volume();
}
class Cylinder implements C{
    private double radius;
    private double height;
    private String color;
    Cylinder(double radius,double height,String color){
        this.radius = radius;
        this.height = height;
        this.color = color;
    }
    @Override
    public double area() {
        return radius*radius*PI;
    }

    @Override
    public void volume() {
        System.out.println("Volume is" + radius*radius*PI*height);
    }

    @Override
    public void setColor(String c) {
        System.out.println("color is " + this.color);
    }
}
public class Test {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3.2,3.1,"red");

        System.out.println(cylinder.area());
        cylinder.volume();
        cylinder.setColor("red");
    }
}
