/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Longest Palindromic Substring
 */
class Leetcode5 {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extendPalindrome(s, i, i);
            String s2 = extendPalindrome(s, i, i + 1);

            if (s1.length() > max.length()) {
                max = s1;
            }
            if (s2.length() > max.length()) {
                max = s2;
            }
        }

        return max;
    }

    private String extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }
}