import java.util.HashSet;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 * Sum of Square Numbers
 */
class Leetcode633 {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}