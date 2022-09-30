import java.util.*;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Find the Duplicate Number
 */
class Leetcode287 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return num;
            } else {
                uniqueNums.add(num);
            }
        }

        return 0;
    }
}