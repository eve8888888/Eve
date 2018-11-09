package lambda;

/**
 * @Author: Eve
 * @Date: 2018/11/9 17:33
 * @Version 1.0
 */
@FunctionalInterface
interface IMyInterface{
    int print(int x,int y);
}
interface IMyInterface2{
    void print2();
}
//class myClass implements IMyInterface{
//    @Override
//    public void print() {
//        System.out.println("Hello World");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        IMyInterface iMyInterface = new IMyInterface() {
//            @Override
//            public void print() {
//                System.out.println("Hello World");
//            }
//        };
//        iMyInterface.print();
//    }
//}

//class Test{
//    public static void main(String[] args) {
//        IMyInterface iMyInterface = (x,y)-> {
//            x = x + y;
//            y = x - y;
//            x = x - y;
//            return x - y;
//        };
//        System.out.println(iMyInterface.print(2,3));
//    }
//}

class Test{
    public static void main(String[] args) {
        IMyInterface iMyInterface = (x,y)-> x + y;
        IMyInterface2 iMyInterface2 = ()-> System.out.println("Hello World");
        System.out.println(iMyInterface.print(2,3));
        iMyInterface2.print2();
    }
}