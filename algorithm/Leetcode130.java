/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Surrounded Regions
 */
class Leetcode130 {
    private static boolean[][] visited;
    private static int m;
    private static int n;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        solve(new char[][]{{'X'}});
    }

    public static void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i <  m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int x, int y, char[][] board) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (board[x][y] == 'O'
                    && !visited[nextX][nextY]
                    && nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                dfs(nextX, nextY, board);
            }
        }
    }
}