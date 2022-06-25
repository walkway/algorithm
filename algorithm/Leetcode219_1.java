import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Contains Duplicate II
 */
class Leetcode219_1 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (indexByValue.containsKey(value) && i - indexByValue.get(value) <= k) {
                return true;
            } else {
                indexByValue.put(value, i);
            }
        }

        return false;
    }

}