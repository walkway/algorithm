/**
 * https://leetcode.com/problems/jump-game/
 * Jump Game
 */
class Leetcode55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }

        int length = nums.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (num < i) {
                break;
            }

            if (num < i + nums[i]) {
                num = i + nums[i];
            }

            if (num >= length - 1) {
                return true;
            }
        }

        return false;
    }
}