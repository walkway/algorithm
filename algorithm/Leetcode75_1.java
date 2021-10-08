import java.io.IOException;

/**
 * https://leetcode.com/problems/sort-colors/
 * Sort Colors
 */
class Leetcode75_1 {
    public static void main(String args[]) throws IOException {
        sortColors(new int[] {2,0,2,1,1,0});
    }
    public static void sortColors(int[] nums) {
        for(int i = 0 ; i < nums.length - 1 ; i ++) {
            for(int j = 0 ; j < nums.length - i - 1 ; j ++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}