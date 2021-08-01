import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2573
 *
 * 빙산
 */
public class Baekjoon2573 {
    private static int n;
    private static int m;
    private static int[][] area;
    private static int[][] meltValues;
    private static boolean[][] visited;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        area = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(row[j]);
            }
        }

        int year = 0;
        while (true) {
            year++;
            meltValues = new int[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (area[i][j] != 0) {
                        countMeltGlacier(i, j);
                    }
                }
            }

            meltGlacier();

            int glacierCount = 0;
            visited = new boolean[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (!visited[i][j] && area[i][j] != 0) {
                        glacierCount++;
                        dfs(i, j);
                    }
                }
            }

            if (glacierCount == 0 || glacierCount >= 2) {
                year = glacierCount == 0 ? 0 : year;

                break;
            }
        }

        System.out.println(year);
    }

    private static void countMeltGlacier(int x, int y) {
        int melt = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                    && area[x][y] != 0 && area[nextX][nextY] == 0) {
                melt++;
            }
        }

        meltValues[x][y] = melt;
    }

    private static void meltGlacier() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = Math.max(area[i][j] - meltValues[i][j], 0);
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                    && area[nextX][nextY] > 0
                    && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
