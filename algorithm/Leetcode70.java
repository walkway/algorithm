/**
 * https://leetcode.com/problems/climbing-stairs/
 * Climbing Stairs
 */
class Leetcode70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int n2 = 1;
        int n1 = 2;
        int all = 0;

        for (int i = 2; i < n; i++) {
            all = n2 + n1;
            n2 = n1;
            n1 = all;
        }

        return all;
    }
}