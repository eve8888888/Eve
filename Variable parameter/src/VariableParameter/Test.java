package VariableParameter;

public class Test {
    public static void main(String[] args) {
        System.out.println(add2(1,2,3));
        System.out.println(add2(4,5,6,7,8));
        System.out.println(add2(5,7,9,1,5,3,8,1,8));
    }
    public static int add(int ... data) {
        int result = 0 ;
        for (int i = 0; i < data.length; i++) {
            result += data[i] ;
        }
        return result ;
    }
    public static int add2(int n, int ... data){
        int result = 0;
        for(int i = 0; i < data.length; i ++){
            result += data[i];
        }
        result += n;
        return result;
    }
}
