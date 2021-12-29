/**
 * https://leetcode.com/problems/combination-sum-ii/
 * Combination Sum II
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        int closest = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    } else if (Math.abs(target - sum) < Math.abs(target - closest)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }
}