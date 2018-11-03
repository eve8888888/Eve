package Calculator;

interface IComput{
    int computer(int n,int m);
}
class Add implements IComput{
    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}
class Sub implements IComput{
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}
class Mul implements IComput{
    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}
class Div implements IComput{
    @Override
    public int computer(int n, int m) {
        try{
            return n/m;
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("分子不能为0");
            return 0;
        }

    }
}

class UseComput{
    public void useCom(IComput com,int one,int two){
        System.out.println(com.computer(one,two));
    }
}
public class Test {
    public static void main(String[] args) {
        UseComput useComputer = new UseComput();
        useComputer.useCom(new Add(),3,2);
        useComputer.useCom(new Sub(),3,2);
        useComputer.useCom(new Mul(),3,2);
        useComputer.useCom(new Div(),3,2);
        useComputer.useCom(new Div(),3,0);
    }
}