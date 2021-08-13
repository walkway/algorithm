import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Kth Largest Element in an Array
 */
class Leetcode215 {
    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] sorted = Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        return sorted[k-1];
    }
}