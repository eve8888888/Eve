package generic;

/**
 * @Author: Eve
 * @Date: 2018/11/9 14:22
 * @Version 1.0
 */

interface IMyinterface<T>{
    void print(T t);
}

//class myClassImpl<T> implements IMyinterface<T>{
//    @Override
//    public void print(T t) {
//        System.out.println(t);
//    }
//}

class myClassImpl implements IMyinterface<String>{
    @Override
    public void print(String t) {
        System.out.println(t);
    }
}
class Test{
    public static void main(String[] args) {
        IMyinterface<String> iMyinterface = new myClassImpl();
        iMyinterface.print("Hello");
    }
}


//class Point{
//    private Object x;
//    public Object getX() {
//        return x;
//    }
//
//    public void setX(Object x) {
//        this.x = x;
//    }
//}

//class Point<T>{
//    private T x;
//    public T getX() {
//        return x;
//    }
//
//    public void setX(T x) {
//        this.x = x;
//    }
//}
//class MyClass<T>{
//    public void method(T t){
//        System.out.println(t);
//    }
//    public <E> E method2(E e){
//        return e;
//    }
//}

//public class Test {
//    public static void main(String[] args) {
//        //Point p = new Point();
//        //p.setX(20);
//        //p.setX("东经80度");
//        //int x = (Integer) p.getX();//取出数据
////        Point<Integer> p = new Point<>();
////        p.setX(80);
////        int x = p.getX();
//        MyClass myClass = new MyClass();
//        String  x = myClass.method("10");
//    }
//}

//class Test{
//    public static void main(String[] args) {
//        MyClass<String> myClass = new MyClass<>();
//        myClass.method("泛型类");
//        Integer s = myClass.method2(100);
//        System.out.println(s);
//    }
//}