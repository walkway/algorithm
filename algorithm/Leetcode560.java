/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Subarray Sum Equals K
 */
class Leetcode560 {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                result++;
            }
            sum = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }

        return result;
    }

}