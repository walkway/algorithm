import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Longest Consecutive Sequence
 */
class Leetcode128 {

    public int longestConsecutive(int[] num) {
        int result = 0;
        Map<Integer, Integer> sequence = new HashMap<>();
        for (int n : num) {
            if (!sequence.containsKey(n)) {
                int left = sequence.getOrDefault(n - 1, 0);
                int right = sequence.getOrDefault(n + 1, 0);
                int sum = left + right + 1;
                sequence.put(n, sum);

                result = Math.max(result, sum);

                sequence.put(n - left, sum);
                sequence.put(n + right, sum);
            }
        }

        return result;
    }
}