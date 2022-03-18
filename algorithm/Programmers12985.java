/**
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 *
 * 예상 대진표
 */
public class Programmers12985 {
    public static void main(String args[]) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = a % 2 == 1 ? (a / 2) + 1 : a / 2;
            b = b % 2 == 1 ? (b / 2) + 1 : b / 2;

            answer++;
        }

        return answer;
    }
}
