import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence/
 * Longest Arithmetic Subsequence
 */
class Leetcode1027 {

    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        int result = 2;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int difference = nums[i] - nums[j];
                dp[i].put(difference, dp[j].getOrDefault(difference, 1) + 1);
                result = Math.max(result, dp[i].get(difference));
            }

        }

        return result;
    }

}