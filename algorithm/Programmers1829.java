/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1829
 * 카카오 프렌즈 컬러링북
 */
class Programmers1829 {
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    count = dfs(i, j, picture, 0);
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    public int dfs(int x, int y, int[][] picture, int count) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < picture.length && nextY < picture[0].length
                    && picture[x][y] == picture[nextX][nextY] && !visited[nextX][nextY]) {
                count = dfs(nextX, nextY, picture, count);
            }
        }

        return count;
    }

}