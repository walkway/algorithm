import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number-ii/
 *
 * Single Number II
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int num : nums) {
            if (numbers.get(num) == null) {
                numbers.put(num, 0);
            } else if (numbers.get(num) == 1) {
                numbers.remove(num);
            } else {
                numbers.put(num, 1);
            }
        }

        return numbers.keySet().iterator().next();
    }
}
