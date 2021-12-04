/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Palindrome Partitioning
 */
public class LeetCode477 {

    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                total += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return total;
    }
}