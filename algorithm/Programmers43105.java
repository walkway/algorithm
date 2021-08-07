/**
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 *
 * 정수 삼각형
 */
class Programmers43105 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(dp[length - 1][i], max);
        }

        return max;
    }
}