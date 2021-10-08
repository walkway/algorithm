/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Longest Palindromic Substring
 */
class Leetcode5_1 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }

        int start = 0;
        int end = 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length; j > i; j--) {
                if (isPalindrome(s.substring(i, j))) {
                    if (i == 0 && j == length) {
                        return s;
                    }

                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end);
    }

    private static boolean isPalindrome(String value) {
        int center = value.length() / 2;
        int end = value.length() - 1;

        for (int start = 0; start < center; start++) {
            if (value.charAt(start) != value.charAt(end - start)) {
                return false;
            }
        }

        return true;
    }
}