/**
 * https://leetcode.com/problems/sort-colors/
 * Sort Colors
 */
class Leetcode75 {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            } else if (nums[i] == 1) {
                white++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
            } else if (i < red + white) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}