/**
 * https://leetcode.com/problems/max-area-of-island/
 * Max Area of Island
 */
class Leetcode695_1 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                result = Math.max(dfs(grid, i, j), result);
            }
        }

        return result;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        int temp = 1;
        grid[i][j] = 2;
        temp += dfs(grid, i - 1, j);
        temp += dfs(grid, i + 1, j);
        temp += dfs(grid, i, j - 1);
        temp += dfs(grid, i, j + 1);

        return temp;
    }

}