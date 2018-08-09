
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int target = 0;
            int[] v = new int[grid.length];
            int[] h = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (v[j] < grid[i][j]) v[j] = grid[i][j];
                    if (h[i] < grid[i][j]) h[i] = grid[i][j];
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] < Math.min(v[j], h[i])) target = target + Math.min(v[j], h[i]) - grid[i][j];
                }
            }
        return target;
    }
}
