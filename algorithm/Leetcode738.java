import java.util.Arrays;

/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 * Monotone Increasing Digits
 */
class Leetcode738 {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int endPoint = digits.length;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                digits[i - 1]--;
                endPoint = i;
            }
        }
        Arrays.fill(digits, endPoint, digits.length, '9');

        return Integer.parseInt(new String(digits));
    }
}