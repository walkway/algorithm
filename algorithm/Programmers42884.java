import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 * 단속카메라
 */
class Programmers42884 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int answer = 0;

        int min = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                answer++;
            }
        }
        return answer;
    }
}