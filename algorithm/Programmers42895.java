/**
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 * N으로 표현
 */
class Programmers42895 {
    private int answer = -1;

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);

        return answer;
    }

    public void dfs(int n, int number, int count, int value) {
        if (count > 8) {
            return;
        }

        if (number == value) {
            if (answer > count || answer == -1) {
                answer = count;
            }
            return;
        }

        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(n, number, count + 1 + i, value + nn);
            dfs(n, number, count + 1 + i, value - nn);
            dfs(n, number, count + 1 + i, value * nn);
            dfs(n, number, count + 1 + i, value / nn);
        }
    }
}