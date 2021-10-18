/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 * Max Increase to Keep City Skyline
 */
class Leetcode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top = new int[grid[0].length], left = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                top[j] = Math.max(top[j], grid[i][j]); //max per col
                left[i] = Math.max(left[i], grid[i][j]); //max per row
            }
        }
        int diff = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                diff += Math.min(left[i], top[j]) - grid[i][j];
            }
        }
        return diff;
    }
}
