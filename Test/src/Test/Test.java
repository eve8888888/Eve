package Test;

/**
 * 迷宫问题
 * 深度优先遍历
 */
class Map{
    int[] fx = new int[]{1,-1,0,0};
    int[] fy = new int[]{0,0,-1,1};
    int[][] a;
    Map(int[][] a){
        this.a = a;
    }
    void go(int row, int col) {
        int k, newrow = 0, newcol = 0;
        for (k = 0; k < 4; k++) {
            if (canStay(row, col, k) == 1) {
                newrow = row + fx[k];
                newcol = col + fy[k];
                a[newrow][newcol] = 3;
                if (newrow == a.length-1 && newcol == a.length-1) {
                    out();
                } else {
                    go(newrow, newcol);
                }
            }
        }
        a[row][col] = 2;
    }
    public int canStay(int row, int col,int k) {

        row = row + fx[k];
        col = col + fy[k];
        if (row < 0 || row >= a.length || col < 0 || col >= a.length) {
            return 0;
        }
        if (a[row][col] != 0) {
            return 0;
        }
        return 1;
    }
    public void out(){
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a.length;j++){
                if(a[i][j] == 3 ){
                    System.out.print("v");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 1, 0, 0, 0, 0,0},
                {0, 1, 1, 1, 1, 1,0},
                {0, 1, 0, 0, 0, 0,1},
                {0, 1, 1, 0, 1, 0,0},
                {0, 0, 0, 0, 1, 1,0},
                {1, 1, 1, 1, 1, 0,0},
                {1, 1, 1, 1, 1, 0,0}
        };
        Map m = new Map(a);
        m.a[0][0] = 3;
        m.go(0,0);
    }
}


