package pers;

/**
 * @Author: Eve
 * @Date: 2018/12/2 9:38
 * @Version 1.0
 */
interface IFruit {
    void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat an Apple");
    }
}
class Orange implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat an Orange");
    }
}
class Banana implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat a banana");
    }
}
class Factory {
    public static IFruit getInstance(String fruitName){
        IFruit iFruit = null;
        try {
            Class<?> cls = Class.forName(fruitName);
            iFruit = (IFruit) cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return iFruit;

    }
}

public class Test {
    public static void main(String[] args) {
        IFruit iFruit = Factory2.getInstance("Apple");
        iFruit.eat();
    }
}
