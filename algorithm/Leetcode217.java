import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * Contains Duplicate
 */
class Leetcode217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Set<Integer> elements = new HashSet<>();
        for (Integer num : nums) {
            elements.add(num);
        }

        return elements.size() != nums.length;
    }
}