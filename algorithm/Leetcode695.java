/**
 * https://leetcode.com/problems/max-area-of-island/
 * Max Area of Island
 */
class Leetcode695 {
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};
    private static int m;
    private static int n;
    private static int[][] areaGrid;
    private static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        areaGrid = grid;
        visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, 0));
            }
        }

        return max;
    }

    private static int dfs(int x, int y, int area) {
        if (x < 0 || y < 0 || x >= m || y >= n
                || visited[x][y]
                || areaGrid[x][y] == 0) {
            return area;
        }

        visited[x][y] = true;
        area++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            area = dfs(nextX, nextY, area);
        }

        return area;
    }
}