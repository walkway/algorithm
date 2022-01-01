import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * Minimum Number of Arrows to Burst Balloons
 */
public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int answer = 0;
        long arrow = Long.MIN_VALUE;
        for (int[] point : points) {
            if (arrow < point[0]) {
                arrow = point[1];
                answer++;
            }
        }

        return answer;
    }
}