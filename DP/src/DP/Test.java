package DP;
/**
 * 动态规划
 * 资源分配问题
 */
public class Test {
    public static void main(String[] args) {
        double[][] TABLE = new double[][]{
                {0,0.11,0.13,0.15,0.21,0.24,0.30,0.35},//A
                {0,0.12,0.16,0.21,0.23,0.25,0.24,0.34},
                {0,0.08,0.12,0.20,0.24,0.26,0.30,0.35}
        };
        double gain[];
        double temp[] = new double[10];
        gain = TABLE[0];

            int x = 0;
            double max = 0;
            for (int i = 0; i < 8; i++) {//总资金
                for (int j = 0; j <= i; j++) {//b
                    if (TABLE[1][j] + gain[i - j] > max) {
                        max = TABLE[1][j] + gain[i - j];
                    }
                    temp[x] = max;
                }
                x++;
            }
            gain = temp;


        for(int i = 0;i < 8 ;i++){
            gain[i] = temp[i] + TABLE[2][7 - i];
        }
        for (double var :
                gain) {
            System.out.print(var + ",");
        }
    }
}
