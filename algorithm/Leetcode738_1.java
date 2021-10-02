/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 * Monotone Increasing Digits
 */
class Leetcode738_1 {
    public int monotoneIncreasingDigits(int n) {
        int result = 0;
        int pre = Integer.MAX_VALUE;
        int offset = 1;
        while (n != 0) {
            int digit = n % 10;
            if (digit > pre) {
                result = digit * offset - 1;
                pre = digit - 1;
            } else {
                result = result + digit * offset;
                pre = digit;
            }
            offset *= 10;
            n = n / 10;
        }
        return result;
    }
}