/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Remove Duplicates from Sorted Array
 */
class Leetcode26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
    }
}