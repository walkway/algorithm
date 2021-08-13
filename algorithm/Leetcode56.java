import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Merge Intervals
 */
class Leetcode56 {
    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int[] before = intervals[0];
        for (int[] interval : intervals) {
            int beforeEnd = before[1];
            int start = interval[0];
            int end = interval[1];
            if (beforeEnd >= start) {
                before[1] = Math.max(beforeEnd, end);
            } else {
                result.add(interval);
                before = interval;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}