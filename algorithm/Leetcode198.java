/**
 * https://leetcode.com/problems/house-robber/
 * House Robber
 */
class Leetcode198 {

    public int rob(int[] nums) {
        int money1 = 0;
        int money2 = 0;
        for(int num : nums) {
            int temp = money1;
            money1 = Math.max(money2 + num, money1);
            money2 = temp;
        }

        return money1;
    }

}