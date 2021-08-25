import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 * Single Number
 */
class Leetcode136 {
    public int singleNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                numbers.remove(nums[i]);
            } else {
                numbers.add(nums[i]);
            }

        }
        return numbers.toArray(new Integer[1])[0];
    }
}