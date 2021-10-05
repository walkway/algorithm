/**
 * https://leetcode.com/problems/sort-colors/
 * Sort Colors
 */
class Leetcode75 {
    public void sortColors(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count1++;
            } else if (nums[i] == 1) {
                count2++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count1) {
                nums[i] = 0;
            } else if (i < count1 + count2) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}