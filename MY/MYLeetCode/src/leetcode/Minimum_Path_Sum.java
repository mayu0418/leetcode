package leetcode;

public class Minimum_Path_Sum {
    /*
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。
    示例:
    输入:
            [
            [1,3,1],
            [1,5,1],
            [4,2,1]
            ]
    输出: 7
    解释: 因为路径 1→3→1→1→1 的总和最小。
    */
    public static int minPathSum(int[][] grid) {
//        return test(grid,0,0);
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i == 0 && j == 0) {

                } else {
                    grid[i][j] += Math.min(grid[i - 1][j],grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    static int test(int[][] grid,int row,int col) {//超时
        int cur = grid[row][col];
        int right = Integer.MAX_VALUE;
        if (col + 1 < grid[0].length) right = test(grid,row,col + 1);
        int down = Integer.MAX_VALUE;
        if (row + 1 < grid.length) down = test(grid,row + 1,col);
        if (right != Integer.MAX_VALUE && down != Integer.MAX_VALUE) return cur + Math.min(right,down);
        if (right != Integer.MAX_VALUE) return cur + right;
        if (down != Integer.MAX_VALUE) return cur + down;
        return cur;
    }

    public static void main(String[] strings) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(grid);
    }


}
