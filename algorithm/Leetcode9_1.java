/**
 * https://leetcode.com/problems/palindrome-number/
 * Palindrome Number
 */
class Leetcode9_1 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String value = Integer.toString(x);

        return isPalindrome(value);
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}