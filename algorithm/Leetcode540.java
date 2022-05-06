import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * Single Element in a Sorted Array
 */
class Leetcode540 {

    public int singleNonDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int i : nums) {
            if (elements.contains(i)) {
                elements.remove(i);
            } else {
                elements.add(i);
            }
        }

        return elements.stream().findFirst().get();
    }
}