import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 * Minimize Maximum Pair Sum in Array
 */
class Leetcode1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int pairCount = nums.length / 2;
        int end = nums.length - 1;
        int max = 0;
        for (int i = 0; i < pairCount; i++) {
            max = Math.max(max, nums[i] + nums[end]);
            end--;
        }

        return max;
    }
}