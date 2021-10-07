/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Search in Rotated Sorted Array II
 */
class Leetcode81 {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
}