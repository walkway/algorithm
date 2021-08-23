/**
 * https://leetcode.com/problems/word-search/
 *
 * Word Search
 */
class Leetcode79 {
    private static boolean[][] visited;
    private static int m;
    private static int n;
    private static String inputWord;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        inputWord = word;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && search(i, j, board, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean search(int x, int y, char[][] board, int index) {
        if (x < 0 || y < 0 || x >= m || y >= n
                || visited[x][y]
                || board[x][y] != inputWord.charAt(index)) {
            return false;
        }

        if (index == inputWord.length() - 1) {
            return true;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (search(nextX, nextY, board, index + 1)) {
                return true;
            }
        }

        visited[x][y] = false;

        return false;
    }
}