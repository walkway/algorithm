import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Remove Duplicates from Sorted Array II
 */
public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> result = new TreeMap<>();
        int minus = 0;
        for (int num : nums) {
            Integer number = result.get(num);
            if (number == null) {
                result.put(num, 1);
            } else if (number < 2) {
                result.put(num, number + 1);
            } else {
                minus++;
            }
        }

        int index = 0;
        for (Integer key : result.keySet()) {
            for (int i = 0; i < result.get(key); i++) {
                nums[index] = key;
                index++;
            }
        }

        return nums.length - minus;
    }
}
