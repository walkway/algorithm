import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 * 4Sum
 */
class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int t = 0; t < nums.length - 3; t++) {
            for (int i = t + 1; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[t];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j++], nums[k--], nums[t]));
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}