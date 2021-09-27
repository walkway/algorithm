/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Count Numbers with Unique Digits
 */
class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 10;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else {
            int product = 9;
            for (int i = 2; i <= n; i++) {
                product = product * (11 - i);
                result += product;
            }
        }

        return result;
    }
}