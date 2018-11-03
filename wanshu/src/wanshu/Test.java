package wanshu;

/**
 * 找出1000以内的所有完数
 * 一个数如果恰好等于它的因子之和，这个数就称为完数
 * 如：6 = 1 + 2 +3
 */
public class Test {
    public static void main(String[] args) {
        for(int i = 1;i <= 1000;i++){
            int sum = 0;
            for (int j = 1;j < i ; j ++){
                if(i%j == 0){
                    sum += j;
                }
            }
            if(sum == i){
                System.out.println(i);
            }
        }
    }
}
