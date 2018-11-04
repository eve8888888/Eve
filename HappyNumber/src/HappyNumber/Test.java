package HappyNumber;


public class Test {
    public static void main(String[] args) {
        fun(19);
    }
    public static void fun(int n){
        int sum = 0;

        while (n >= 1){
            int re = (n % 10) *  (n % 10);
            sum += re;
            n = n / 10;
        }
        if(sum == 1){
            System.out.println("是快乐数");
        }
        else {
            fun(sum);
        }
    }
}
