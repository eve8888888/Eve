package CitySkyline;

/**
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。
 * 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。
 * 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。
 * 建筑物高度可以增加的最大总和是多少？
 */

/**
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释：
 * The grid is:
 * [ [3, 0, 8, 4],
 *   [2, 4, 5, 7],
 *   [9, 2, 6, 3],
 *   [0, 3, 1, 0] ]
 *
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 *
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 *
 * gridNew = [ [8, 4, 8, 7],
 *             [7, 4, 7, 7],
 *             [9, 4, 8, 7],
 *             [3, 3, 3, 3] ]
 */
public class Test {
    public static void main(String[] args) {
        int[][] grid = {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        };
        System.out.println(Solution.maxIncreaseKeepingSkyline(grid));
    }
}
class Solution {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int max = 0;
        int max2 = 0;
        int sum = 0;
        int[] hang = new int[grid.length];
        int[] lie = new int[grid[0].length];
        for (int i = 0; i < hang.length; i++){
            max = 0;
            max2 = 0;
            for (int j = 0; j < lie.length; j++) {
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
                if(grid[j][i] > max2){
                    max2 = grid[j][i];
                }
            }
            hang[i] = max;
            lie[i] = max2;
        }

        for (int i = 0; i < hang.length; i++){
            for (int j = 0; j < lie.length; j++){
                if(hang[i] < lie[j]){
                    sum = sum + (hang[i] - grid[i][j]);
                }
                else
                    sum = sum + (lie[j] - grid[i][j]);
            }
        }
        return sum;
    }
}
