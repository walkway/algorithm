import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-mismatch/
 * Set Mismatch
 */
class Leetcode645 {

    public int[] findErrorNums(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int[] result = new int[2];
        for (int n : nums) {
            if (numbers.contains(n)) {
                result[0] = n;
            } else {
                numbers.add(n);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                result[1] = i;
            }
        }

        return result;
    }

}